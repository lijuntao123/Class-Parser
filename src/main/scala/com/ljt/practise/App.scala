package com.ljt.practise

import java.io.InputStream

import com.ljt.practise.basicinfo.MemberInfo
import com.ljt.practise.basicinfo.attribute.CodeAttribute
import com.ljt.practise.basicinfo.instruction.InstructionTable
import com.ljt.practise.basictype.{U2, U4}
import com.ljt.practise.constantinfo.{ConstantClass, ConstantUtf8}

/**
  * java class 文件解析
  *
  */
object App {
    def main(args: Array[String]) {

        val in: InputStream = Thread.currentThread.
            getContextClassLoader.getResource("APIResponse.class").openStream()

        val classFile: ClassFile = new ClassFile();
        classFile.magic = U4.read(in);
        classFile.minorVersion = U2.read(in);
        classFile.majorVersion = U2.read(in);

        //解析常量池
        val constantPoolCount: Int = U2.read(in);
        val constantPool: ConstantPool = new ConstantPool(constantPoolCount);
        constantPool.read(in);
        classFile.constantPool = constantPool;


        //获取类信息
        classFile.accessFlags = U2.read(in);
        val classIndex: Int = U2.read(in);
        val clazz: ConstantClass = constantPool.constantPoolInfos(classIndex).asInstanceOf[ConstantClass];
        val className: ConstantUtf8 = constantPool.constantPoolInfos(clazz.nameIndex).asInstanceOf[ConstantUtf8];
        classFile.className = className.value;
        println("className:" + className);

        //获取父类信息
        val superIndex = U2.read(in);
        val superClazz: ConstantClass = constantPool.constantPoolInfos(superIndex).asInstanceOf[ConstantClass];
        val superClazzName: ConstantUtf8 = constantPool.constantPoolInfos(superClazz.nameIndex).asInstanceOf[ConstantUtf8];
        classFile.superClass = superClazzName.value;
        println("superClazzName:" + classFile.superClass);

        //获取接口信息
        classFile.interfacesCount = U2.read(in);
        classFile.interfaces = new Array[String](classFile.interfacesCount);
        for (i <- 0 to classFile.interfacesCount - 1) {
            val interfaceIndex: Int = U2.read(in);
            val interfaceClazz: ConstantClass = constantPool.constantPoolInfos(superIndex).asInstanceOf[ConstantClass];
            val interfaceClazzName: ConstantUtf8 = constantPool.constantPoolInfos(superClazz.nameIndex).asInstanceOf[ConstantUtf8];
            classFile.interfaces(i) = interfaceClazzName.value;
            println("interfaceClazzName:" + interfaceClazzName.value);
        }

        println("\n");

        //获取字段信息
        classFile.fieldCount = U2.read(in);
        classFile.fields = new Array[MemberInfo](classFile.fieldCount);
        for (m <- 0 to classFile.fieldCount - 1) {
            val fieldInfo: MemberInfo = new MemberInfo(constantPool);
            fieldInfo.read(in);
            classFile.fields(m) = fieldInfo;

            val fName: ConstantUtf8 = constantPool.constantPoolInfos(fieldInfo.nameIndex)
                .asInstanceOf[ConstantUtf8];
            val fDesc: ConstantUtf8 = constantPool.constantPoolInfos(fieldInfo.descriptionIndex)
                .asInstanceOf[ConstantUtf8];
            println("fieldName:" + fName.value);
            println("fieldName:" + fDesc.value);
        }

        println("\n");

        //获取字段信息
        classFile.methodCount = U2.read(in);
        classFile.methods = new Array[MemberInfo](classFile.methodCount);
        var n: Int = 0;
        while (n < classFile.methodCount) {
            val memberInfo: MemberInfo = new MemberInfo(constantPool);
            memberInfo.read(in);

            val fName: ConstantUtf8 = constantPool.constantPoolInfos(memberInfo.nameIndex)
                .asInstanceOf[ConstantUtf8];
            val fDesc: ConstantUtf8 = constantPool.constantPoolInfos(memberInfo.descriptionIndex)
                .asInstanceOf[ConstantUtf8];
            println("method:" + fName.value);
            println("desc:" + fDesc.value);

            for (j <- 0 until memberInfo.attributeCount) {
                if (memberInfo.attributes(j).isInstanceOf[CodeAttribute]) {}
                val codeAttribute: CodeAttribute = memberInfo.attributes(j).asInstanceOf[CodeAttribute];
                for (k <- 0 until codeAttribute.codeLength) {
                    val code: Short = codeAttribute.code(k);
                    println(InstructionTable.getInstruction(code));

                }
            }
            println("\n");

            n += 1;

        }

        println("----------------------解析完毕！-------------------------------------------------");
        println(classFile);


    }


}

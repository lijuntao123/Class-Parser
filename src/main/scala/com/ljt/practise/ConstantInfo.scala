package com.ljt.practise

import java.io.InputStream

import com.ljt.practise.constantinfo._


/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 16:09
  */
abstract class ConstantInfo {
    //定义各种类型的在常量池中的代码
    val CONSTANT_Class: Short = 7;
    val CONSTANT_Fieldref: Short = 9;
    val CONSTANT_Methodref: Short = 10;
    val CONSTANT_InterfaceMethodref: Short = 11;
    val CONSTANT_String: Short = 8;
    val CONSTANT_Integer: Short = 3;
    val CONSTANT_Float: Short = 4;
    val CONSTANT_Long: Short = 5;
    val CONSTANT_Double: Short = 6;
    val CONSTANT_NameAndType: Short = 12;
    val CONSTANT_Utf8: Short = 1;
    val CONSTANT_MethodHandle: Short = 15;
    val CONSTANT_MethodType: Short = 16;
    val CONSTANT_InvokeDynamic: Short = 18;

    var tag: Short = 0;

    def read(in: InputStream);

    /**
      * 使用模式匹配，根据常量池代码获取类型
      *
      * @param tag 量池代码
      * @return 对应类型
      */
    def getConstantInfo(tag: Short): ConstantInfo = tag match {
        case CONSTANT_Class => new ConstantClass()
        case CONSTANT_Fieldref => new ConstantMethodRef()
        case CONSTANT_Methodref => new ConstantMethodRef()
        case CONSTANT_InterfaceMethodref => new ConstantMethodRef()
        case CONSTANT_String => new ConstantString()
        case CONSTANT_Integer => new ConstantInteger()
        case CONSTANT_Float => new ConstantFloat()
        case CONSTANT_Long => new ConstantLong()
        case CONSTANT_Double => new ConstantDouble()
        case CONSTANT_NameAndType => new ConstantNameAndType()
        case CONSTANT_Utf8 => new ConstantUtf8()
        case CONSTANT_MethodHandle => new ConstantMethodHandle()
        case CONSTANT_MethodType => new ConstantMethodType()
        case CONSTANT_InvokeDynamic => new ConstantInvokeDynamic()
        case _ => {
            println(tag + "undefine");
            return null;
        }

    }

}

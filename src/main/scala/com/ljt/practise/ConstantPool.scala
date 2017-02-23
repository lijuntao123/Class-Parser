package com.ljt.practise

import java.io.InputStream

import com.ljt.practise.basictype.U1
import com.ljt.practise.constantinfo.{ConstantDouble, ConstantInfoImpl, ConstantLong}


/**
  * 常量池对象
  *
  * @author lijuntao1 
  * @date 2017/2/20 10:26
  */
class ConstantPool(count: Int) {
    /**
      * 常量池大小
      */
    var constantPoolCount: Int = count;
    /**
      * 常量池存储的对象列表
      */
    var constantPoolInfos: Array[ConstantInfo] = new Array[ConstantInfo](constantPoolCount);

    def read(inputStream: InputStream): Unit = {
        var i: Int = 1;
        while (i < constantPoolCount) {
            val tag: Short = U1.read(inputStream);//读取一个字节的类型标签
            val constantInfo = ConstantInfoImpl.getConstantInfo(tag);//根据类型标签获取对应的类型
            if (constantInfo != null) {
                constantInfo.read(inputStream);//解析对应类型
                constantPoolInfos(i) = constantInfo;
                if (constantInfo.isInstanceOf[ConstantLong] || constantInfo.isInstanceOf[ConstantDouble]) {
                    i += 1;
                }
            }

            i += 1;
        }

    }


}

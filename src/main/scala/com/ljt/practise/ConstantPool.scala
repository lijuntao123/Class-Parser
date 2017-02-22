package com.ljt.practise

import java.io.InputStream

import com.ljt.practise.basictype.U1
import com.ljt.practise.constantinfo.{ConstantDouble, ConstantInfoImpl, ConstantLong}


/**
  *
  * @author lijuntao1 
  * @date 2017/2/20 10:26
  */
class ConstantPool(count: Int) {
  var constantPoolCount: Int = count;
  var constantPoolInfos: Array[ConstantInfo] = new Array[ConstantInfo](constantPoolCount);

  def read(inputStream: InputStream): Unit = {
    var i: Int = 1;
    while (i < constantPoolCount) {
      val tag: Short = U1.read(inputStream);
      val constantInfo = ConstantInfoImpl.getConstantInfo(tag);
      if (constantInfo != null) {
        constantInfo.read(inputStream);
        constantPoolInfos(i) = constantInfo;
        if (constantInfo.isInstanceOf[ConstantLong] || constantInfo.isInstanceOf[ConstantDouble]) {
          i += 1;
        }
      }

      i += 1;
    }

  }


}

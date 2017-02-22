package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.{U2, U4}

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 17:08
  */
class ConstantMethodRef extends ConstantInfo {
  var classIndex: Int =_;
  var nameAndTypeIndex: Int =_;

  override def read(in: InputStream): Unit = {
    classIndex = U2.read(in);
    nameAndTypeIndex = U2.read(in);
  }
}

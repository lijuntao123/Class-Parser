package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U2

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 19:00
  */
class ConstantNameAndType extends ConstantInfo {
  var nameIndex: Int =_;
  var typeIndex: Int =_;

  override def read(in: InputStream): Unit = {
    nameIndex = U2.read(in);
    typeIndex = U2.read(in);
  }
}

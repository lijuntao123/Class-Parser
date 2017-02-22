package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U2

/**
  *
  * @author lijuntao1 
  * @date 2017/2/21 10:52
  */
class ConstantMethodHandle extends ConstantInfo {
  var referenceKind: Int = _;
  var referenceIndex: Int = _;

  override def read(in: InputStream): Unit = {
    referenceKind = U2.read(in)
    referenceIndex = U2.read(in)
  }
}

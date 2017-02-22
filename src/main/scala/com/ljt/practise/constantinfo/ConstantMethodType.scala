package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U2

/**
  *
  * @author lijuntao1 
  * @date 2017/2/21 10:52
  */
class ConstantMethodType extends ConstantInfo {
  var descType: Int = _;

  override def read(in: InputStream): Unit = {
    descType = U2.read(in)
  }
}

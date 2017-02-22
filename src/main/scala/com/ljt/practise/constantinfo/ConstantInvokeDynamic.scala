package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U2

/**
  *
  * @author lijuntao1 
  * @date 2017/2/21 10:52
  */
class ConstantInvokeDynamic extends ConstantInfo {
  var bootstrapMethodAttrIndex: Int = _;
  var nameAndTypeIndex: Int = _;

  override def read(in: InputStream): Unit = {
    bootstrapMethodAttrIndex = U2.read(in)
    nameAndTypeIndex = U2.read(in)
  }
}

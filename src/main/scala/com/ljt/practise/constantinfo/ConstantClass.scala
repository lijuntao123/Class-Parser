package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U2

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 15:36
  */
class ConstantClass extends ConstantInfo {
  var nameIndex: Int=_;

  override def read(in: InputStream): Unit = {
    nameIndex = U2.read(in);
  }
}

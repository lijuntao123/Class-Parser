package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U4

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 17:08
  */
class ConstantFloat extends ConstantInfo {
  var value: Long =_;

  override def read(in: InputStream): Unit = {
    value = U4.read(in);
  }
}

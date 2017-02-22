package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.{U1}

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 17:08
  */
class ConstantShort extends ConstantInfo {
  var value: Short = _;

  override def read(in: InputStream): Unit = {
    value = U1.read(in);
  }
}

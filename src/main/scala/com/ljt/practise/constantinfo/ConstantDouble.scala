package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U4

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 17:03
  */
class ConstantDouble extends ConstantInfo {
  var highValue: Long = _;
  var lowValue: Long = _;

  override def read(in: InputStream): Unit = {
    highValue = U4.read(in);
    lowValue = U4.read(in);
  }
}

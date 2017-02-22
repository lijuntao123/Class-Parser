package com.ljt.practise.basicinfo

import java.io.InputStream

import com.ljt.practise.ConstantPool

/**
  *
  * @author lijuntao1 
  * @date 2017/2/20 12:58
  */
abstract class BasicInfo(cp: ConstantPool) {
  var constantPool: ConstantPool = cp;

  def read(in: InputStream): Unit;

}

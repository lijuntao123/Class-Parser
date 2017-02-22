package com.ljt.practise.basicinfo.attribute

import java.io.InputStream

import com.ljt.practise.basictype.U2


/**
  *
  * @author lijuntao1 
  * @date 2017/2/20 16:00
  */
class ExceptionTable {
  var startPc: Int=_;
  var endPc: Int=_;
  var handlerPc: Int=_;
  var catchType: Int=_;

  def read(in: InputStream): Unit = {
    startPc = U2.read(in);
    endPc = U2.read(in)
    handlerPc = U2.read(in)
    catchType = U2.read(in)
  }

}

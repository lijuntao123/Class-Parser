package com.ljt.practise.basictype

import java.io.InputStream


/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 14:57
  */
class U2 {
  def read(in: InputStream): Int = {
    val bytes = new Array[Byte](2);
    in.read(bytes);

    var value: Int = 0;
    for (i <- 0 until bytes.length) {
      value <<= 8;
      value |= bytes(i) & 0xFF;
    }

    return value;

  }
}

object U2 {
  val u2 = new U2();

  def read(in: InputStream): Int = {
    return u2.read(in);
  }
}

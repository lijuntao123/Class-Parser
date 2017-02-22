package com.ljt.practise.basictype

import java.io.InputStream

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 15:09
  */
class U4 {
  def read(in: InputStream): Long = {
    val bytes = new Array[Byte](4);
    in.read(bytes);

    var value: Long = 0;
    for (i <- 0 until bytes.length) {
      value <<= 8;
      value |= bytes(i) & 0xFF;
    }

    return value;

  }
}

object U4 {
  val u4 = new U4();

  def read(in: InputStream): Long = {
    return u4.read(in);
  }
}

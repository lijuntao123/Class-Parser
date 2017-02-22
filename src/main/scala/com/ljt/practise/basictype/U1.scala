package com.ljt.practise.basictype

import java.io.{File, FileInputStream, InputStream}


/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 14:18
  */
class U1 {
  def read(in: InputStream): Short = {
    val bytes: Array[Byte] = new Array[Byte](1);
    in.read(bytes);
    val value: Short = (bytes(0) & 0xFF).toShort;
    return value;
  }

}

object U1 {
  val u1=new U1();
  def read(in: InputStream): Short = {
    return u1.read(in);
  }
}


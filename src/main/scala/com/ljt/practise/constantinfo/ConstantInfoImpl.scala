package com.ljt.practise.constantinfo

import java.io.InputStream

import com.ljt.practise.ConstantInfo
import com.ljt.practise.basictype.U2

/**
  *
  * @author lijuntao1 
  * @date 2017/2/15 15:36
  */
class ConstantInfoImpl extends ConstantInfo {

  override def read(in: InputStream): Unit = {

  }
}

object ConstantInfoImpl{
  val constantInfoImpl=new ConstantInfoImpl();
  def getConstantInfo(tag: Short): ConstantInfo = {
    return constantInfoImpl.getConstantInfo(tag);
  }
}

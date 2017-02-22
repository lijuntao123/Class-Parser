package com.ljt.practise.basicinfo.attribute

import java.io.InputStream

import com.ljt.practise.ConstantPool
import com.ljt.practise.basicinfo.BasicInfo
import com.ljt.practise.basictype.{U1, U2, U4}
import com.ljt.practise.constantinfo.ConstantUtf8

/**
  *
  * @author lijuntao1 
  * @date 2017/2/20 13:50
  */
class AttributeInfo(cp: ConstantPool, mNameIndex: Int) extends BasicInfo(cp) {
  val nameIndex: Int = mNameIndex;

  var length: Int=_;
  var info: Array[Short]=_;

  override def read(in: InputStream): Unit = {
    length = U4.read(in).toInt;
    info = new Array[Short](length);
    for (i <- 0 until length) {
      info(i) = U1.read(in);
    }
  }

  def getAttribute(cp: ConstantPool, in: InputStream): AttributeInfo = {
    val nameIndex: Int = U2.read(in);
    val name = cp.constantPoolInfos(nameIndex).asInstanceOf[ConstantUtf8].value;

    if ("Code".equals(name)) {
      return new CodeAttribute(cp, nameIndex);
    }

    return new AttributeInfo(cp, nameIndex);
  }
}

object AttributeInfo {
  val attributeInfo:AttributeInfo=new AttributeInfo(null, 0);
  def getAttribute(cp: ConstantPool, in: InputStream): AttributeInfo = {
    return attributeInfo.getAttribute(cp, in);
  }
}

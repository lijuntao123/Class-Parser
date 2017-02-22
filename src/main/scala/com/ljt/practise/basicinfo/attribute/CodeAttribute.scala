package com.ljt.practise.basicinfo.attribute

import java.io.InputStream

import com.ljt.practise.ConstantPool
import com.ljt.practise.basictype.{U1, U2, U4}

/**
  *
  * @author lijuntao1 
  * @date 2017/2/20 16:22
  */
class CodeAttribute(cp: ConstantPool, nameIndex: Int) extends AttributeInfo(cp, nameIndex) {
  var maxStack: Int=_;
  var maxLocals: Int=_;
  var codeLength: Int=_;
  var code: Array[Short]=_;
  var excepetionTableLength: Int=_;
  var exceptionTable: Array[ExceptionTable]=_;
  var attributesCount: Int=_;
  var attributes: Array[AttributeInfo]=_;

  override def read(in: InputStream): Unit = {
    length = U4.read(in).toInt;
    maxStack = U2.read(in);
    maxLocals = U2.read(in);
    codeLength = U4.read(in).toInt;
    code = new Array[Short](codeLength);

    for (i <- 0 to codeLength - 1) {
      code(i) = U1.read(in);
    }

    excepetionTableLength = U2.read(in);
    exceptionTable = new Array[ExceptionTable](excepetionTableLength);
    for (i <- 0 to excepetionTableLength - 1) {
      val execTable = new ExceptionTable();
      execTable.read(in);
      exceptionTable(i) = execTable;
    }

    attributesCount = U2.read(in);
    attributes = new Array[AttributeInfo](attributesCount);
    for (i <- 0 to attributesCount - 1) {
      val attr = AttributeInfo.getAttribute(cp, in);
      attr.read(in);
      attributes(i) = attr;
    }


  }
}

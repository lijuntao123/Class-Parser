package com.ljt.practise.basicinfo

import java.io.InputStream

import com.ljt.practise.ConstantPool
import com.ljt.practise.basicinfo.attribute.AttributeInfo
import com.ljt.practise.basictype.U2

/**
  *
  * @author lijuntao1 
  * @date 2017/2/20 13:07
  */
class MemberInfo(cp: ConstantPool) extends BasicInfo(cp) {

    var accessFlags: Int = _;
    var nameIndex: Int = _;
    var descriptionIndex: Int = _;
    var attributeCount: Int = _;
    var attributes: Array[AttributeInfo] = _;

    override def read(in: InputStream): Unit = {
        accessFlags = U2.read(in);
        nameIndex = U2.read(in);
        descriptionIndex = U2.read(in);
        attributeCount = U2.read(in);
        attributes = new Array[AttributeInfo](attributeCount);

        for (index <- 0 until attributeCount) {
            val attributeInfo = AttributeInfo.getAttribute(cp, in);
            attributeInfo.read(in);
            attributes(index) = attributeInfo;
        }
    }
}

package com.ljt.practise

import com.ljt.practise.basicinfo.MemberInfo

/**
  *
  * @author lijuntao1 
  * @date 2017/2/17 15:08
  */
class ClassFile {
    var magic: Long = _;
    var minorVersion: Int = _;
    var majorVersion: Int = _;
    var constantPool: ConstantPool = _;
    var accessFlags: Int = _;
    var className: String = _;
    var superClass: String = _;
    var interfacesCount: Int = _;
    var interfaces: Array[String] = _;
    var fieldCount: Int = _;
    var fields: Array[MemberInfo] = _;
    var methodCount: Int = _;
    var methods: Array[MemberInfo] = _;

    override def toString = s"ClassFile(magic=$magic, minorVersion=$minorVersion, majorVersion=$majorVersion, constantPool=$constantPool, accessFlags=$accessFlags, className=$className, superClass=$superClass, interfacesCount=$interfacesCount, interfaces=$interfaces, fieldCount=$fieldCount, fields=$fields, methodCount=$methodCount, methods=$methods)"
}

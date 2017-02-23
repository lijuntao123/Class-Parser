package com.ljt.practise

import com.ljt.practise.basicinfo.MemberInfo

/**
  * *
  * ClassFile {
  * u4     magic;
  * u2     minor_version;
  * u2     major_version;
  * u2     constant_pool_count;
  * cp_info    contant_pool[constant_pool_count – 1];
  * u2     access_flags;
  * u2     this_class;
  * u2     super_class;
  * u2     interfaces_count;
  * u2     interfaces[interfaces_count];
  * u2     fields_count;
  * field_info     fields[fields_count];
  * u2     methods_count;
  * method_info    methods[methods_count];
  * u2      attributes_count;
  * attribute_info  attributes[attributes_count];
  *
  * 解析后class文件对象
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

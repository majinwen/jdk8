package org.omg.DynamicAny.DynAnyFactoryPackage;


/**
 * org/omg/DynamicAny/DynAnyFactoryPackage/InconsistentTypeCode.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
 * Monday, April 1, 2019 11:12:34 PM PDT
 */

public final class InconsistentTypeCode extends org.omg.CORBA.UserException {

    public InconsistentTypeCode() {
        super(InconsistentTypeCodeHelper.id());
    } // ctor


    public InconsistentTypeCode(String $reason) {
        super(InconsistentTypeCodeHelper.id() + "  " + $reason);
    } // ctor

} // class InconsistentTypeCode

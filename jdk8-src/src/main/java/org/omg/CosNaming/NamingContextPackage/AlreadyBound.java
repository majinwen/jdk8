package org.omg.CosNaming.NamingContextPackage;


/**
 * org/omg/CosNaming/NamingContextPackage/AlreadyBound.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
 * Monday, April 1, 2019 11:12:34 PM PDT
 */

public final class AlreadyBound extends org.omg.CORBA.UserException {

    public AlreadyBound() {
        super(AlreadyBoundHelper.id());
    } // ctor


    public AlreadyBound(String $reason) {
        super(AlreadyBoundHelper.id() + "  " + $reason);
    } // ctor

} // class AlreadyBound
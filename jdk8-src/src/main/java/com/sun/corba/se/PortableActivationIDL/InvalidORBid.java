package com.sun.corba.se.PortableActivationIDL;


/**
 * com/sun/corba/se/PortableActivationIDL/InvalidORBid.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
 * Monday, April 1, 2019 11:12:33 PM PDT
 */

public final class InvalidORBid extends org.omg.CORBA.UserException {

    public InvalidORBid() {
        super(InvalidORBidHelper.id());
    } // ctor


    public InvalidORBid(String $reason) {
        super(InvalidORBidHelper.id() + "  " + $reason);
    } // ctor

} // class InvalidORBid

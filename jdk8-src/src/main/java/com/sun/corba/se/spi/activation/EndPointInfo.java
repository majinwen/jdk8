package com.sun.corba.se.spi.activation;


/**
 * com/sun/corba/se/spi/activation/EndPointInfo.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
 * Monday, April 1, 2019 11:12:33 PM PDT
 */

public final class EndPointInfo implements org.omg.CORBA.portable.IDLEntity {
    public String endpointType = null;
    public int port = (int) 0;

    public EndPointInfo() {
    } // ctor

    public EndPointInfo(String _endpointType, int _port) {
        endpointType = _endpointType;
        port = _port;
    } // ctor

} // class EndPointInfo

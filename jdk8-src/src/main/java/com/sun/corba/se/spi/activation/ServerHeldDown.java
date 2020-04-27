package com.sun.corba.se.spi.activation;


/**
 * com/sun/corba/se/spi/activation/ServerHeldDown.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
 * Monday, April 1, 2019 11:12:33 PM PDT
 */

public final class ServerHeldDown extends org.omg.CORBA.UserException {
    public int serverId = (int) 0;

    public ServerHeldDown() {
        super(ServerHeldDownHelper.id());
    } // ctor

    public ServerHeldDown(int _serverId) {
        super(ServerHeldDownHelper.id());
        serverId = _serverId;
    } // ctor


    public ServerHeldDown(String $reason, int _serverId) {
        super(ServerHeldDownHelper.id() + "  " + $reason);
        serverId = _serverId;
    } // ctor

} // class ServerHeldDown

package com.sun.corba.se.PortableActivationIDL;


/**
 * com/sun/corba/se/PortableActivationIDL/ServerAlreadyRegistered.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
 * Monday, April 1, 2019 11:12:33 PM PDT
 */

public final class ServerAlreadyRegistered extends org.omg.CORBA.UserException {
    public String serverId = null;

    public ServerAlreadyRegistered() {
        super(ServerAlreadyRegisteredHelper.id());
    } // ctor

    public ServerAlreadyRegistered(String _serverId) {
        super(ServerAlreadyRegisteredHelper.id());
        serverId = _serverId;
    } // ctor


    public ServerAlreadyRegistered(String $reason, String _serverId) {
        super(ServerAlreadyRegisteredHelper.id() + "  " + $reason);
        serverId = _serverId;
    } // ctor

} // class ServerAlreadyRegistered

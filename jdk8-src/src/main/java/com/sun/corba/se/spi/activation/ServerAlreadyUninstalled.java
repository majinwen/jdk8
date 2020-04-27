package com.sun.corba.se.spi.activation;


/**
 * com/sun/corba/se/spi/activation/ServerAlreadyUninstalled.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
 * Monday, April 1, 2019 11:12:33 PM PDT
 */

public final class ServerAlreadyUninstalled extends org.omg.CORBA.UserException {
    public int serverId = (int) 0;

    public ServerAlreadyUninstalled() {
        super(ServerAlreadyUninstalledHelper.id());
    } // ctor

    public ServerAlreadyUninstalled(int _serverId) {
        super(ServerAlreadyUninstalledHelper.id());
        serverId = _serverId;
    } // ctor


    public ServerAlreadyUninstalled(String $reason, int _serverId) {
        super(ServerAlreadyUninstalledHelper.id() + "  " + $reason);
        serverId = _serverId;
    } // ctor

} // class ServerAlreadyUninstalled
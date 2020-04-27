package org.omg.IOP;


/**
 * org/omg/IOP/ServiceContextListHolder.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/org/omg/PortableInterceptor/IOP.idl
 * Monday, April 1, 2019 11:12:35 PM PDT
 */


/** An array of service contexts, forming a service context list. */
public final class ServiceContextListHolder implements org.omg.CORBA.portable.Streamable {
    public org.omg.IOP.ServiceContext value[] = null;

    public ServiceContextListHolder() {
    }

    public ServiceContextListHolder(org.omg.IOP.ServiceContext[] initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = org.omg.IOP.ServiceContextListHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        org.omg.IOP.ServiceContextListHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return org.omg.IOP.ServiceContextListHelper.type();
    }

}

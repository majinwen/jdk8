package org.omg.CosNaming;


/**
 * org/omg/CosNaming/Binding.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from /Users/java_re/workspace/8-2-build-macosx-x86_64/jdk8u212/12974/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
 * Monday, April 1, 2019 11:12:34 PM PDT
 */

public final class Binding implements org.omg.CORBA.portable.IDLEntity {
    public org.omg.CosNaming.NameComponent binding_name[] = null;

    // name
    public org.omg.CosNaming.BindingType binding_type = null;

    public Binding() {
    } // ctor

    public Binding(org.omg.CosNaming.NameComponent[] _binding_name, org.omg.CosNaming.BindingType _binding_type) {
        binding_name = _binding_name;
        binding_type = _binding_type;
    } // ctor

} // class Binding

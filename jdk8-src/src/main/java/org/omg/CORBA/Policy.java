/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package org.omg.CORBA;


/**
 * Interfaces derived from the <tt>Policy</tt> interface allow an
 * ORB or CORBA service  access to certain choices that affect
 * its operation. This information is accessed in a structured
 * manner using interfaces derived from the <tt>Policy</tt>
 * interface defined in the CORBA module. A CORBA service does not
 * have to use this method of accessing operating options, but
 * may choose to do so. The Security Service in particular uses
 * this technique for associating Security Policy with objects
 * in the system.
 * An interface generated by the IDL-to-Java compiler.
 * org/omg/CORBA/Policy.java
 * Generated by the IDL-to-Java compiler (portable), version "3.0"
 * from ../../../../../src/share/classes/org/omg/PortableServer/corba.idl
 * Saturday, July 17, 1999 12:26:20 AM PDT
 */

public interface Policy extends PolicyOperations, org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity {
} // interface Policy

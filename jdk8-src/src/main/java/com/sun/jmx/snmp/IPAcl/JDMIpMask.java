/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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


/* Generated By:JJTree: Do not edit this line. JDMIpMask.java */

package com.sun.jmx.snmp.IPAcl;

import java.net.UnknownHostException;

class JDMIpMask extends Host {
    private static final long serialVersionUID = -8211312690652331386L;

    protected StringBuffer address = new StringBuffer();

    JDMIpMask(int id) {
        super(id);
    }

    JDMIpMask(Parser p, int id) {
        super(p, id);
    }

    public static Node jjtCreate(int id) {
        return new JDMIpMask(id);
    }

    public static Node jjtCreate(Parser p, int id) {
        return new JDMIpMask(p, id);
    }

    protected String getHname() {
        return address.toString();
    }

    protected PrincipalImpl createAssociatedPrincipal()
            throws UnknownHostException {
        return new GroupImpl(address.toString());
    }
}

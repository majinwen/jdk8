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


/* Generated By:JJTree: Do not edit this line. JDMCommunities.java */

package com.sun.jmx.snmp.IPAcl;


class JDMCommunities extends SimpleNode {
    JDMCommunities(int id) {
        super(id);
    }

    JDMCommunities(Parser p, int id) {
        super(p, id);
    }

    public static Node jjtCreate(int id) {
        return new JDMCommunities(id);
    }

    public static Node jjtCreate(Parser p, int id) {
        return new JDMCommunities(p, id);
    }

    public void buildCommunities(AclEntryImpl entry) {
        for (int i = 0; i < children.length; i++)
            entry.addCommunity(((JDMCommunity) children[i]).getCommunity());
    }
}
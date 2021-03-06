/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

package javax.management.relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The RelationType interface has to be implemented by any class expected to
 * represent a relation type.
 *
 * @since 1.5
 */
public interface RelationType extends Serializable {

    //
    // Accessors
    //

    /**
     * Returns the relation type name.
     *
     * @return the relation type name.
     */
    public String getRelationTypeName();

    /**
     * Returns the list of role definitions (ArrayList of RoleInfo objects).
     *
     * @return an {@link ArrayList} of {@link RoleInfo}.
     */
    public List<RoleInfo> getRoleInfos();

    /**
     * Returns the role info (RoleInfo object) for the given role info name
     * (null if not found).
     *
     * @param roleInfoName role info name
     * @return RoleInfo object providing role definition
     * does not exist
     * @throws IllegalArgumentException  if null parameter
     * @throws RoleInfoNotFoundException if no role info with that name in
     *                                   relation type.
     */
    public RoleInfo getRoleInfo(String roleInfoName)
            throws IllegalArgumentException,
            RoleInfoNotFoundException;
}

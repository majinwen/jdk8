/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

/**
 * A tree node for a 'throw' statement.
 * <p>
 * For example:
 * <pre>
 *   throw <em>expression</em>;
 * </pre>
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @jls section 14.18
 * @since 1.6
 */
@jdk.Exported
public interface ThrowTree extends StatementTree {
    ExpressionTree getExpression();
}

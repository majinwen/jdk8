/*
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

/*
 * Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 */

package javax.xml.stream.events;

/**
 * An interface for comment events
 *
 * @author Copyright (c) 2009 by Oracle Corporation. All Rights Reserved.
 * @version 1.0
 * @since 1.6
 */
public interface Comment extends XMLEvent {

    /**
     * Return the string data of the comment, returns empty string if it
     * does not exist
     */
    public String getText();
}
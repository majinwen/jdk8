/*
 * Copyright (c) 1999, 2008, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.event;

import java.awt.*;

/**
 * An event which indicates a change to the <code>Component</code>
 * hierarchy to which <code>Component</code> belongs.
 * <ul>
 * <li>Hierarchy Change Events (HierarchyListener)
 *     <ul>
 *     <li> addition of an ancestor
 *     <li> removal of an ancestor
 *     <li> hierarchy made displayable
 *     <li> hierarchy made undisplayable
 *     <li> hierarchy shown on the screen (both visible and displayable)
 *     <li> hierarchy hidden on the screen (either invisible or undisplayable)
 *     </ul>
 * <li>Ancestor Reshape Events (HierarchyBoundsListener)
 *     <ul>
 *     <li> an ancestor was resized
 *     <li> an ancestor was moved
 *     </ul>
 * </ul>
 * <p>
 * Hierarchy events are provided for notification purposes ONLY.
 * The AWT will automatically handle changes to the hierarchy internally so
 * that GUI layout and displayability works properly regardless of whether a
 * program is receiving these events or not.
 * <p>
 * This event is generated by a Container object (such as a Panel) when the
 * Container is added, removed, moved, or resized, and passed down the
 * hierarchy. It is also generated by a Component object when that object's
 * <code>addNotify</code>, <code>removeNotify</code>, <code>show</code>, or
 * <code>hide</code> method is called. The {@code ANCESTOR_MOVED} and
 * {@code ANCESTOR_RESIZED}
 * events are dispatched to every <code>HierarchyBoundsListener</code> or
 * <code>HierarchyBoundsAdapter</code> object which registered to receive
 * such events using the Component's <code>addHierarchyBoundsListener</code>
 * method. (<code>HierarchyBoundsAdapter</code> objects implement the <code>
 * HierarchyBoundsListener</code> interface.) The {@code HIERARCHY_CHANGED} events are
 * dispatched to every <code>HierarchyListener</code> object which registered
 * to receive such events using the Component's <code>addHierarchyListener
 * </code> method. Each such listener object gets this <code>HierarchyEvent
 * </code> when the event occurs.
 * <p>
 * An unspecified behavior will be caused if the {@code id} parameter
 * of any particular {@code HierarchyEvent} instance is not
 * in the range from {@code HIERARCHY_FIRST} to {@code HIERARCHY_LAST}.
 * <br>
 * The {@code changeFlags} parameter of any {@code HierarchyEvent} instance takes one of the following
 * values:
 * <ul>
 * <li> {@code HierarchyEvent.PARENT_CHANGED}
 * <li> {@code HierarchyEvent.DISPLAYABILITY_CHANGED}
 * <li> {@code HierarchyEvent.SHOWING_CHANGED}
 * </ul>
 * Assigning the value different from listed above will cause unspecified behavior.
 *
 * @author David Mendenhall
 * @see HierarchyListener
 * @see HierarchyBoundsAdapter
 * @see HierarchyBoundsListener
 * @since 1.3
 */
public class HierarchyEvent extends AWTEvent {
    /*
     * serialVersionUID
     */
    private static final long serialVersionUID = -5337576970038043990L;

    /**
     * Marks the first integer id for the range of hierarchy event ids.
     */
    public static final int HIERARCHY_FIRST = 1400; // 1300 used by sun.awt.windows.ModalityEvent

    /**
     * The event id indicating that modification was made to the
     * entire hierarchy tree.
     */
    public static final int HIERARCHY_CHANGED = HIERARCHY_FIRST;

    /**
     * The event id indicating an ancestor-Container was moved.
     */
    public static final int ANCESTOR_MOVED = 1 + HIERARCHY_FIRST;

    /**
     * The event id indicating an ancestor-Container was resized.
     */
    public static final int ANCESTOR_RESIZED = 2 + HIERARCHY_FIRST;

    /**
     * Marks the last integer id for the range of ancestor event ids.
     */
    public static final int HIERARCHY_LAST = ANCESTOR_RESIZED;

    /**
     * A change flag indicates that the <code>HIERARCHY_CHANGED</code> event
     * was generated by a reparenting operation.
     */
    public static final int PARENT_CHANGED = 0x1;

    /**
     * A change flag indicates that the <code>HIERARCHY_CHANGED</code> event
     * was generated due to the changing of the hierarchy displayability.
     * To discern the
     * current displayability of the hierarchy, call the
     * <code>Component.isDisplayable</code> method. Displayability changes occur
     * in response to explicit or implicit calls of the
     * <code>Component.addNotify</code> and
     * <code>Component.removeNotify</code> methods.
     *
     * @see java.awt.Component#isDisplayable()
     * @see java.awt.Component#addNotify()
     * @see java.awt.Component#removeNotify()
     */
    public static final int DISPLAYABILITY_CHANGED = 0x2;

    /**
     * A change flag indicates that the <code>HIERARCHY_CHANGED</code> event
     * was generated due to the changing of the hierarchy showing state.
     * To discern the
     * current showing state of the hierarchy, call the
     * <code>Component.isShowing</code> method. Showing state changes occur
     * when either the displayability or visibility of the
     * hierarchy occurs. Visibility changes occur in response to explicit
     * or implicit calls of the <code>Component.show</code> and
     * <code>Component.hide</code> methods.
     *
     * @see java.awt.Component#isShowing()
     * @see java.awt.Component#addNotify()
     * @see java.awt.Component#removeNotify()
     * @see java.awt.Component#show()
     * @see java.awt.Component#hide()
     */
    public static final int SHOWING_CHANGED = 0x4;

    Component changed;
    Container changedParent;
    long changeFlags;

    /**
     * Constructs an <code>HierarchyEvent</code> object to identify a
     * change in the <code>Component</code> hierarchy.
     * <p>This method throws an
     * <code>IllegalArgumentException</code> if <code>source</code>
     * is <code>null</code>.
     *
     * @param source        The <code>Component</code> object that
     *                      originated the event
     * @param id            An integer indicating the type of event.
     *                      For information on allowable values, see
     *                      the class description for {@link HierarchyEvent}
     * @param changed       The <code>Component</code> at the top of
     *                      the hierarchy which was changed
     * @param changedParent The parent of the <code>changed</code> component.
     *                      This
     *                      may be the parent before or after the
     *                      change, depending on the type of change
     * @throws IllegalArgumentException if <code>source</code> is {@code null}
     * @see #getSource()
     * @see #getID()
     * @see #getChanged()
     * @see #getChangedParent()
     */
    public HierarchyEvent(Component source, int id, Component changed,
                          Container changedParent) {
        super(source, id);
        this.changed = changed;
        this.changedParent = changedParent;
    }

    /**
     * Constructs an <code>HierarchyEvent</code> object to identify
     * a change in the <code>Component</code> hierarchy.
     * <p> This method throws an
     * <code>IllegalArgumentException</code> if <code>source</code>
     * is <code>null</code>.
     *
     * @param source        The <code>Component</code> object that
     *                      originated the event
     * @param id            An integer indicating the type of event.
     *                      For information on allowable values, see
     *                      the class description for {@link HierarchyEvent}
     * @param changed       The <code>Component</code> at the top
     *                      of the hierarchy which was changed
     * @param changedParent The parent of the <code>changed</code> component.
     *                      This
     *                      may be the parent before or after the
     *                      change, depending on the type of change
     * @param changeFlags   A bitmask which indicates the type(s) of
     *                      the <code>HIERARCHY_CHANGED</code> events
     *                      represented in this event object.
     *                      For information on allowable values, see
     *                      the class description for {@link HierarchyEvent}
     * @throws IllegalArgumentException if <code>source</code> is null
     * @see #getSource()
     * @see #getID()
     * @see #getChanged()
     * @see #getChangedParent()
     * @see #getChangeFlags()
     */
    public HierarchyEvent(Component source, int id, Component changed,
                          Container changedParent, long changeFlags) {
        super(source, id);
        this.changed = changed;
        this.changedParent = changedParent;
        this.changeFlags = changeFlags;
    }

    /**
     * Returns the originator of the event.
     *
     * @return the <code>Component</code> object that originated
     * the event, or <code>null</code> if the object is not a
     * <code>Component</code>.
     */
    public Component getComponent() {
        return (source instanceof Component) ? (Component) source : null;
    }

    /**
     * Returns the Component at the top of the hierarchy which was
     * changed.
     *
     * @return the changed Component
     */
    public Component getChanged() {
        return changed;
    }

    /**
     * Returns the parent of the Component returned by <code>
     * getChanged()</code>. For a HIERARCHY_CHANGED event where the
     * change was of type PARENT_CHANGED via a call to <code>
     * Container.add</code>, the parent returned is the parent
     * after the add operation. For a HIERARCHY_CHANGED event where
     * the change was of type PARENT_CHANGED via a call to <code>
     * Container.remove</code>, the parent returned is the parent
     * before the remove operation. For all other events and types,
     * the parent returned is the parent during the operation.
     *
     * @return the parent of the changed Component
     */
    public Container getChangedParent() {
        return changedParent;
    }

    /**
     * Returns a bitmask which indicates the type(s) of
     * HIERARCHY_CHANGED events represented in this event object.
     * The bits have been bitwise-ored together.
     *
     * @return the bitmask, or 0 if this is not an HIERARCHY_CHANGED
     * event
     */
    public long getChangeFlags() {
        return changeFlags;
    }

    /**
     * Returns a parameter string identifying this event.
     * This method is useful for event-logging and for debugging.
     *
     * @return a string identifying the event and its attributes
     */
    public String paramString() {
        String typeStr;
        switch (id) {
            case ANCESTOR_MOVED:
                typeStr = "ANCESTOR_MOVED (" + changed + "," + changedParent + ")";
                break;
            case ANCESTOR_RESIZED:
                typeStr = "ANCESTOR_RESIZED (" + changed + "," + changedParent + ")";
                break;
            case HIERARCHY_CHANGED: {
                typeStr = "HIERARCHY_CHANGED (";
                boolean first = true;
                if ((changeFlags & PARENT_CHANGED) != 0) {
                    first = false;
                    typeStr += "PARENT_CHANGED";
                }
                if ((changeFlags & DISPLAYABILITY_CHANGED) != 0) {
                    if (first) {
                        first = false;
                    } else {
                        typeStr += ",";
                    }
                    typeStr += "DISPLAYABILITY_CHANGED";
                }
                if ((changeFlags & SHOWING_CHANGED) != 0) {
                    if (first) {
                        first = false;
                    } else {
                        typeStr += ",";
                    }
                    typeStr += "SHOWING_CHANGED";
                }
                if (!first) {
                    typeStr += ",";
                }
                typeStr += changed + "," + changedParent + ")";
                break;
            }
            default:
                typeStr = "unknown type";
        }
        return typeStr;
    }
}

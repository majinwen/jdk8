/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
package java.rmi.server;

import sun.rmi.server.UnicastServerRef;
import sun.rmi.server.UnicastServerRef2;

import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.StubNotFoundException;

/**
 * Used for exporting a remote object with JRMP and obtaining a stub
 * that communicates to the remote object. Stubs are either generated
 * at runtime using dynamic proxy objects, or they are generated statically
 * at build time, typically using the {@code rmic} tool.
 *
 * <p><strong>Deprecated: Static Stubs.</strong> <em>Support for statically
 * generated stubs is deprecated. This includes the API in this class that
 * requires the use of static stubs, as well as the runtime support for
 * loading static stubs.  Generating stubs dynamically is preferred, using one
 * of the five non-deprecated ways of exporting objects as listed below. Do
 * not run {@code rmic} to generate static stub classes. It is unnecessary, and
 * it is also deprecated.</em>
 *
 * <p>There are six ways to export remote objects:
 *
 * <ol>
 *
 * <li>Subclassing {@code UnicastRemoteObject} and calling the
 * {@link #UnicastRemoteObject()} constructor.
 *
 * <li>Subclassing {@code UnicastRemoteObject} and calling the
 * {@link #UnicastRemoteObject(int) UnicastRemoteObject(port)} constructor.
 *
 * <li>Subclassing {@code UnicastRemoteObject} and calling the
 * {@link #UnicastRemoteObject(int, RMIClientSocketFactory, RMIServerSocketFactory)
 * UnicastRemoteObject(port, csf, ssf)} constructor.
 *
 * <li>Calling the
 * {@link #exportObject(Remote) exportObject(Remote)} method.
 * <strong>Deprecated.</strong>
 *
 * <li>Calling the
 * {@link #exportObject(Remote, int) exportObject(Remote, port)} method.
 *
 * <li>Calling the
 * {@link #exportObject(Remote, int, RMIClientSocketFactory, RMIServerSocketFactory)
 * exportObject(Remote, port, csf, ssf)} method.
 *
 * </ol>
 *
 * <p>The fourth technique, {@link #exportObject(Remote)},
 * always uses statically generated stubs and is deprecated.
 *
 * <p>The other five techniques all use the following approach: if the
 * {@code java.rmi.server.ignoreStubClasses} property is {@code true}
 * (case insensitive) or if a static stub cannot be found, stubs are generated
 * dynamically using {@link java.lang.reflect.Proxy Proxy} objects. Otherwise,
 * static stubs are used.
 *
 * <p>The default value of the
 * {@code java.rmi.server.ignoreStubClasses} property is {@code false}.
 *
 * <p>Statically generated stubs are typically pregenerated from the
 * remote object's class using the {@code rmic} tool. A static stub is
 * loaded and an instance of that stub class is constructed as described
 * below.
 *
 * <ul>
 *
 * <li>A "root class" is determined as follows: if the remote object's
 * class directly implements an interface that extends {@link Remote}, then
 * the remote object's class is the root class; otherwise, the root class is
 * the most derived superclass of the remote object's class that directly
 * implements an interface that extends {@code Remote}.
 *
 * <li>The name of the stub class to load is determined by concatenating
 * the binary name of the root class with the suffix {@code _Stub}.
 *
 * <li>The stub class is loaded by name using the class loader of the root
 * class. The stub class must extend {@link RemoteStub} and must have a
 * public constructor that has one parameter of type {@link RemoteRef}.
 *
 * <li>Finally, an instance of the stub class is constructed with a
 * {@link RemoteRef}.
 *
 * <li>If the appropriate stub class could not be found, or if the stub class
 * could not be loaded, or if a problem occurs creating the stub instance, a
 * {@link StubNotFoundException} is thrown.
 *
 * </ul>
 *
 * <p>Stubs are dynamically generated by constructing an instance of
 * a {@link java.lang.reflect.Proxy Proxy} with the following characteristics:
 *
 * <ul>
 *
 * <li>The proxy's class is defined by the class loader of the remote
 * object's class.
 *
 * <li>The proxy implements all the remote interfaces implemented by the
 * remote object's class.
 *
 * <li>The proxy's invocation handler is a {@link
 * RemoteObjectInvocationHandler} instance constructed with a
 * {@link RemoteRef}.
 *
 * <li>If the proxy could not be created, a {@link StubNotFoundException}
 * will be thrown.
 *
 * </ul>
 *
 * @author Ann Wollrath
 * @author Peter Jones
 * @implNote Depending upon which constructor or static method is used for exporting an
 * object, {@link RMISocketFactory} may be used for creating sockets.
 * By default, server sockets created by {@link RMISocketFactory}
 * listen on all network interfaces. See the
 * {@link RMISocketFactory} class and the section
 * <a href="{@docRoot}/../platform/rmi/spec/rmi-server29.html">RMI Socket Factories</a>
 * in the
 * <a href="{@docRoot}/../platform/rmi/spec/rmiTOC.html">Java RMI Specification</a>.
 * @since JDK1.1
 **/
public class UnicastRemoteObject extends RemoteServer {

    /**
     * @serial port number on which to export object
     */
    private int port = 0;

    /**
     * @serial client-side socket factory (if any)
     */
    private RMIClientSocketFactory csf = null;

    /**
     * @serial server-side socket factory (if any) to use when
     * exporting object
     */
    private RMIServerSocketFactory ssf = null;

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = 4974527148936298033L;

    /**
     * Creates and exports a new UnicastRemoteObject object using an
     * anonymous port.
     *
     * <p>The object is exported with a server socket
     * created using the {@link RMISocketFactory} class.
     *
     * @throws RemoteException if failed to export object
     * @since JDK1.1
     */
    protected UnicastRemoteObject() throws RemoteException {
        this(0);
    }

    /**
     * Creates and exports a new UnicastRemoteObject object using the
     * particular supplied port.
     *
     * <p>The object is exported with a server socket
     * created using the {@link RMISocketFactory} class.
     *
     * @param port the port number on which the remote object receives calls
     *             (if <code>port</code> is zero, an anonymous port is chosen)
     * @throws RemoteException if failed to export object
     * @since 1.2
     */
    protected UnicastRemoteObject(int port) throws RemoteException {
        this.port = port;
        exportObject((Remote) this, port);
    }

    /**
     * Creates and exports a new UnicastRemoteObject object using the
     * particular supplied port and socket factories.
     *
     * <p>Either socket factory may be {@code null}, in which case
     * the corresponding client or server socket creation method of
     * {@link RMISocketFactory} is used instead.
     *
     * @param port the port number on which the remote object receives calls
     *             (if <code>port</code> is zero, an anonymous port is chosen)
     * @param csf  the client-side socket factory for making calls to the
     *             remote object
     * @param ssf  the server-side socket factory for receiving remote calls
     * @throws RemoteException if failed to export object
     * @since 1.2
     */
    protected UnicastRemoteObject(int port,
                                  RMIClientSocketFactory csf,
                                  RMIServerSocketFactory ssf)
            throws RemoteException {
        this.port = port;
        this.csf = csf;
        this.ssf = ssf;
        exportObject((Remote) this, port, csf, ssf);
    }

    /**
     * Re-export the remote object when it is deserialized.
     */
    private void readObject(java.io.ObjectInputStream in)
            throws java.io.IOException, java.lang.ClassNotFoundException {
        in.defaultReadObject();
        reexport();
    }

    /**
     * Returns a clone of the remote object that is distinct from
     * the original.
     *
     * @return the new remote object
     * @throws CloneNotSupportedException if clone failed due to
     *                                    a RemoteException.
     * @since JDK1.1
     */
    public Object clone() throws CloneNotSupportedException {
        try {
            UnicastRemoteObject cloned = (UnicastRemoteObject) super.clone();
            cloned.reexport();
            return cloned;
        } catch (RemoteException e) {
            throw new ServerCloneException("Clone failed", e);
        }
    }

    /*
     * Exports this UnicastRemoteObject using its initialized fields because
     * its creation bypassed running its constructors (via deserialization
     * or cloning, for example).
     */
    private void reexport() throws RemoteException {
        if (csf == null && ssf == null) {
            exportObject((Remote) this, port);
        } else {
            exportObject((Remote) this, port, csf, ssf);
        }
    }

    /**
     * Exports the remote object to make it available to receive incoming
     * calls using an anonymous port. This method will always return a
     * statically generated stub.
     *
     * <p>The object is exported with a server socket
     * created using the {@link RMISocketFactory} class.
     *
     * @param obj the remote object to be exported
     * @return remote object stub
     * @throws RemoteException if export fails
     * @since JDK1.1
     * @deprecated This method is deprecated because it supports only static stubs.
     * Use {@link #exportObject(Remote, int) exportObject(Remote, port)} or
     * {@link #exportObject(Remote, int, RMIClientSocketFactory, RMIServerSocketFactory)
     * exportObject(Remote, port, csf, ssf)}
     * instead.
     */
    @Deprecated
    public static RemoteStub exportObject(Remote obj)
            throws RemoteException {
        /*
         * Use UnicastServerRef constructor passing the boolean value true
         * to indicate that only a generated stub class should be used.  A
         * generated stub class must be used instead of a dynamic proxy
         * because the return value of this method is RemoteStub which a
         * dynamic proxy class cannot extend.
         */
        return (RemoteStub) exportObject(obj, new UnicastServerRef(true));
    }

    /**
     * Exports the remote object to make it available to receive incoming
     * calls, using the particular supplied port.
     *
     * <p>The object is exported with a server socket
     * created using the {@link RMISocketFactory} class.
     *
     * @param obj  the remote object to be exported
     * @param port the port to export the object on
     * @return remote object stub
     * @throws RemoteException if export fails
     * @since 1.2
     */
    public static Remote exportObject(Remote obj, int port)
            throws RemoteException {
        return exportObject(obj, new UnicastServerRef(port));
    }

    /**
     * Exports the remote object to make it available to receive incoming
     * calls, using a transport specified by the given socket factory.
     *
     * <p>Either socket factory may be {@code null}, in which case
     * the corresponding client or server socket creation method of
     * {@link RMISocketFactory} is used instead.
     *
     * @param obj  the remote object to be exported
     * @param port the port to export the object on
     * @param csf  the client-side socket factory for making calls to the
     *             remote object
     * @param ssf  the server-side socket factory for receiving remote calls
     * @return remote object stub
     * @throws RemoteException if export fails
     * @since 1.2
     */
    public static Remote exportObject(Remote obj, int port,
                                      RMIClientSocketFactory csf,
                                      RMIServerSocketFactory ssf)
            throws RemoteException {

        return exportObject(obj, new UnicastServerRef2(port, csf, ssf));
    }

    /**
     * Removes the remote object, obj, from the RMI runtime. If
     * successful, the object can no longer accept incoming RMI calls.
     * If the force parameter is true, the object is forcibly unexported
     * even if there are pending calls to the remote object or the
     * remote object still has calls in progress.  If the force
     * parameter is false, the object is only unexported if there are
     * no pending or in progress calls to the object.
     *
     * @param obj   the remote object to be unexported
     * @param force if true, unexports the object even if there are
     *              pending or in-progress calls; if false, only unexports the object
     *              if there are no pending or in-progress calls
     * @return true if operation is successful, false otherwise
     * @throws NoSuchObjectException if the remote object is not
     *                               currently exported
     * @since 1.2
     */
    public static boolean unexportObject(Remote obj, boolean force)
            throws java.rmi.NoSuchObjectException {
        return sun.rmi.transport.ObjectTable.unexportObject(obj, force);
    }

    /**
     * Exports the specified object using the specified server ref.
     */
    private static Remote exportObject(Remote obj, UnicastServerRef sref)
            throws RemoteException {
        // if obj extends UnicastRemoteObject, set its ref.
        if (obj instanceof UnicastRemoteObject) {
            ((UnicastRemoteObject) obj).ref = sref;
        }
        return sref.exportObject(obj, null, false);
    }
}

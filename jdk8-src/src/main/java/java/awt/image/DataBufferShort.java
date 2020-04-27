/*
 * Copyright (c) 1997, 2008, Oracle and/or its affiliates. All rights reserved.
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

/* ****************************************************************
 ******************************************************************
 ******************************************************************
 *** COPYRIGHT (c) Eastman Kodak Company, 1997
 *** As  an unpublished  work pursuant to Title 17 of the United
 *** States Code.  All rights reserved.
 ******************************************************************
 ******************************************************************
 ******************************************************************/

package java.awt.image;

import static sun.java2d.StateTrackable.State.STABLE;
import static sun.java2d.StateTrackable.State.UNTRACKABLE;

/**
 * This class extends <CODE>DataBuffer</CODE> and stores data internally as shorts.
 * <p>
 * <a name="optimizations">
 * Note that some implementations may function more efficiently
 * if they can maintain control over how the data for an image is
 * stored.
 * For example, optimizations such as caching an image in video
 * memory require that the implementation track all modifications
 * to that data.
 * Other implementations may operate better if they can store the
 * data in locations other than a Java array.
 * To maintain optimum compatibility with various optimizations
 * it is best to avoid constructors and methods which expose the
 * underlying storage as a Java array as noted below in the
 * documentation for those methods.
 * </a>
 */
public final class DataBufferShort extends DataBuffer {
    /**
     * The default data bank.
     */
    short data[];

    /**
     * All data banks
     */
    short bankdata[][];

    /**
     * Constructs a short-based <CODE>DataBuffer</CODE> with a single bank and the
     * specified size.
     *
     * @param size The size of the <CODE>DataBuffer</CODE>.
     */
    public DataBufferShort(int size) {
        super(STABLE, TYPE_SHORT, size);
        data = new short[size];
        bankdata = new short[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs a short-based <CODE>DataBuffer</CODE> with the specified number of
     * banks all of which are the specified size.
     *
     * @param size     The size of the banks in the <CODE>DataBuffer</CODE>.
     * @param numBanks The number of banks in the a<CODE>DataBuffer</CODE>.
     */
    public DataBufferShort(int size, int numBanks) {
        super(STABLE, TYPE_SHORT, size, numBanks);
        bankdata = new short[numBanks][];
        for (int i = 0; i < numBanks; i++) {
            bankdata[i] = new short[size];
        }
        data = bankdata[0];
    }

    /**
     * Constructs a short-based <CODE>DataBuffer</CODE> with a single bank using the
     * specified array.
     * Only the first <CODE>size</CODE> elements should be used by accessors of
     * this <CODE>DataBuffer</CODE>.  <CODE>dataArray</CODE> must be large enough to
     * hold <CODE>size</CODE> elements.
     * <p>
     * Note that {@code DataBuffer} objects created by this constructor
     * may be incompatible with <a href="#optimizations">performance
     * optimizations</a> used by some implementations (such as caching
     * an associated image in video memory).
     *
     * @param dataArray The short array for the <CODE>DataBuffer</CODE>.
     * @param size      The size of the <CODE>DataBuffer</CODE> bank.
     */
    public DataBufferShort(short dataArray[], int size) {
        super(UNTRACKABLE, TYPE_SHORT, size);
        data = dataArray;
        bankdata = new short[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs a short-based <CODE>DataBuffer</CODE> with a single bank using the
     * specified array, size, and offset.  <CODE>dataArray</CODE> must have at least
     * <CODE>offset</CODE> + <CODE>size</CODE> elements.  Only elements <CODE>offset</CODE>
     * through <CODE>offset</CODE> + <CODE>size</CODE> - 1
     * should be used by accessors of this <CODE>DataBuffer</CODE>.
     * <p>
     * Note that {@code DataBuffer} objects created by this constructor
     * may be incompatible with <a href="#optimizations">performance
     * optimizations</a> used by some implementations (such as caching
     * an associated image in video memory).
     *
     * @param dataArray The short array for the <CODE>DataBuffer</CODE>.
     * @param size      The size of the <CODE>DataBuffer</CODE> bank.
     * @param offset    The offset into the <CODE>dataArray</CODE>.
     */
    public DataBufferShort(short dataArray[], int size, int offset) {
        super(UNTRACKABLE, TYPE_SHORT, size, 1, offset);
        data = dataArray;
        bankdata = new short[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs a short-based <CODE>DataBuffer</CODE> with the specified arrays.
     * The number of banks will be equal to <CODE>dataArray.length</CODE>.
     * Only the first <CODE>size</CODE> elements of each array should be used by
     * accessors of this <CODE>DataBuffer</CODE>.
     * <p>
     * Note that {@code DataBuffer} objects created by this constructor
     * may be incompatible with <a href="#optimizations">performance
     * optimizations</a> used by some implementations (such as caching
     * an associated image in video memory).
     *
     * @param dataArray The short arrays for the <CODE>DataBuffer</CODE>.
     * @param size      The size of the banks in the <CODE>DataBuffer</CODE>.
     */
    public DataBufferShort(short dataArray[][], int size) {
        super(UNTRACKABLE, TYPE_SHORT, size, dataArray.length);
        bankdata = (short[][]) dataArray.clone();
        data = bankdata[0];
    }

    /**
     * Constructs a short-based <CODE>DataBuffer</CODE> with the specified arrays, size,
     * and offsets.
     * The number of banks is equal to <CODE>dataArray.length</CODE>.  Each array must
     * be at least as large as <CODE>size</CODE> + the corresponding offset.   There must
     * be an entry in the offset array for each <CODE>dataArray</CODE> entry.  For each
     * bank, only elements <CODE>offset</CODE> through
     * <CODE>offset</CODE> + <CODE>size</CODE> - 1 should be
     * used by accessors of this <CODE>DataBuffer</CODE>.
     * <p>
     * Note that {@code DataBuffer} objects created by this constructor
     * may be incompatible with <a href="#optimizations">performance
     * optimizations</a> used by some implementations (such as caching
     * an associated image in video memory).
     *
     * @param dataArray The short arrays for the <CODE>DataBuffer</CODE>.
     * @param size      The size of the banks in the <CODE>DataBuffer</CODE>.
     * @param offsets   The offsets into each array.
     */
    public DataBufferShort(short dataArray[][], int size, int offsets[]) {
        super(UNTRACKABLE, TYPE_SHORT, size, dataArray.length, offsets);
        bankdata = (short[][]) dataArray.clone();
        data = bankdata[0];
    }

    /**
     * Returns the default (first) byte data array.
     * <p>
     * Note that calling this method may cause this {@code DataBuffer}
     * object to be incompatible with <a href="#optimizations">performance
     * optimizations</a> used by some implementations (such as caching
     * an associated image in video memory).
     *
     * @return The first short data array.
     */
    public short[] getData() {
        theTrackable.setUntrackable();
        return data;
    }

    /**
     * Returns the data array for the specified bank.
     * <p>
     * Note that calling this method may cause this {@code DataBuffer}
     * object to be incompatible with <a href="#optimizations">performance
     * optimizations</a> used by some implementations (such as caching
     * an associated image in video memory).
     *
     * @param bank The bank whose data array you want to get.
     * @return The data array for the specified bank.
     */
    public short[] getData(int bank) {
        theTrackable.setUntrackable();
        return bankdata[bank];
    }

    /**
     * Returns the data arrays for all banks.
     * <p>
     * Note that calling this method may cause this {@code DataBuffer}
     * object to be incompatible with <a href="#optimizations">performance
     * optimizations</a> used by some implementations (such as caching
     * an associated image in video memory).
     *
     * @return All of the data arrays.
     */
    public short[][] getBankData() {
        theTrackable.setUntrackable();
        return (short[][]) bankdata.clone();
    }

    /**
     * Returns the requested data array element from the first (default) bank.
     *
     * @param i The data array element you want to get.
     * @return The requested data array element as an integer.
     * @see #setElem(int, int)
     * @see #setElem(int, int, int)
     */
    public int getElem(int i) {
        return (int) (data[i + offset]);
    }

    /**
     * Returns the requested data array element from the specified bank.
     *
     * @param bank The bank from which you want to get a data array element.
     * @param i    The data array element you want to get.
     * @return The requested data array element as an integer.
     * @see #setElem(int, int)
     * @see #setElem(int, int, int)
     */
    public int getElem(int bank, int i) {
        return (int) (bankdata[bank][i + offsets[bank]]);
    }

    /**
     * Sets the requested data array element in the first (default) bank
     * to the specified value.
     *
     * @param i   The data array element you want to set.
     * @param val The integer value to which you want to set the data array element.
     * @see #getElem(int)
     * @see #getElem(int, int)
     */
    public void setElem(int i, int val) {
        data[i + offset] = (short) val;
        theTrackable.markDirty();
    }

    /**
     * Sets the requested data array element in the specified bank
     * from the given integer.
     *
     * @param bank The bank in which you want to set the data array element.
     * @param i    The data array element you want to set.
     * @param val  The integer value to which you want to set the specified data array element.
     * @see #getElem(int)
     * @see #getElem(int, int)
     */
    public void setElem(int bank, int i, int val) {
        bankdata[bank][i + offsets[bank]] = (short) val;
        theTrackable.markDirty();
    }
}

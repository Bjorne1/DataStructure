package com.wcs.array;

import java.util.Arrays;

/**
 * @Description: 自定义数组Array
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/4 9:58
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 初始化容量为capacity的数组
     *
     * @param capacity 数组长度
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认初始化容量为10的数组
     */
    public Array() {
        this(10);
        size = 0;
    }

    /**
     * @return 数组中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 返回数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 给所有的元素后面添加一个新元素
     *
     * @param e 要添加的新元素
     */
    public void addLast(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("add fail, array is full");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * 给所有的元素前面添加一个新元素
     *
     * @param e 要添加的新元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向指定索引处增加元素e
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {

        if (size < 0 || size > data.length) {
            throw new IllegalArgumentException("add fail, size is not legal");
        }

        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 数组容量不够时，自动扩充为当前容量的2倍
     *
     * @param newCapacity 数组新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 删除指定索引处的元素，并返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("add fail, size is not legal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //改成泛型后，data[size]虽然用户访问不到，但是还存在着一个引用，无法被GC回收
        data[size] = null;
        //扩容的时候，是不够了，马上扩充为当前容量的两倍；
        //但是缩减容量的时候，不马上缩减为1/2；
        //因为当容量为8时，下一步操作为增加，删除，增加，删除，会频繁的触发扩容和缩容操作；
        //所以优化成，当持续进行删除操作时，才进行缩容，缩容后的空间依然多出来一半未使用。
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定元素，并返回其所在索引
     *
     * @param e
     * @return
     */
    public int removeElement(E e) {
        int index = find(e);
        if (index == -1) {
            return -1;
        }
        remove(index);
        return index;
    }

    /**
     * 获取指定索引的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("out of index");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 给指定索引设置值
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("out of index");
        }
        data[index] = e;
    }

    /**
     * 是否包含指定元素
     *
     * @param e
     * @return
     */
    public boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引,如果不存在元素e则返回-1
     *
     * @param e
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

}

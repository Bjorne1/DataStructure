package com.wcs.stack;

/**
 * @Description: 栈 数据结构
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/7 11:06
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}

package com.wcs.queue;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/11 9:38
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    boolean isEmpty();

    int getSize();
}

package com.wcs.array;

import com.wcs.array.Array;

public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array(20);
        for (int i = 0; i < 20; i++) {
            array.add(i, i);
        }
        System.out.println(array);
        array.remove(3);
        System.out.println(array);
        array.set(3, 99);
        System.out.println(array);
        int index = array.find(72);
        System.out.println(index);
        array.addLast(1);
        array.addLast(2);
        System.out.println(array);
    }
}

package com.wcs.stack;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/7 11:25
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println(stack.pop());
        System.out.println(stack);
        Integer peek = stack.peek();
        System.out.println(peek);
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
        System.out.println(stack.getCapacity());
    }
}

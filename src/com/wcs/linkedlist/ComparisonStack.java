package com.wcs.linkedlist;

import com.wcs.stack.ArrayStack;
import com.wcs.stack.Stack;

import java.util.Random;

/**
 * @Description: 耗时不会相差太多，因为时间复杂度都是O(1)级别的；
 * 结果：链表的耗时高些，其中一个原因是，其底层需要不断的new Node();
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/11 15:14
 */
public class ComparisonStack {

    private static double testStack(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

    }
}

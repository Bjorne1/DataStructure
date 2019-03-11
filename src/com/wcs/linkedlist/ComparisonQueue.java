package com.wcs.linkedlist;

import com.wcs.queue.ArrayQueue;
import com.wcs.queue.LoopQueue;
import com.wcs.queue.Queue;

import java.util.Random;

/**
 * @Description: 比较基于链表O(1)，数组O(N)，循环数组O(1)实现的队列的耗时
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/11 15:36
 */
public class ComparisonQueue {

    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }
}

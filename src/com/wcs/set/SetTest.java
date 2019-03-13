package com.wcs.set;

import java.util.ArrayList;

/**
 * @Description:
 *      LinkedListSet   BSTSet
 * 增    O(N)            O(H)
 * 查    O(N)            O(H)
 * 删    O(N)            O(H)
 *
 * H与树的深度有关，每一次都能排除一半的数据,N与节点的数量有关
 * 同样的数据量N，二叉树他的H=log₂(N+1)=O(log₂N)=O(logN)
 * 差异比较: 当N=16    log₂N=4      N=16     相差4倍
 *          N=1024    log₂N=10     N=1024   相差100倍
 *          N=100万   log₂N=20     N=100万   相差5万倍
 * Tip:二分搜索树存在一个极端，所有的节点都在右侧，即按1，2，3，4，5的顺序添加，这样二分搜索树就变成了一个链表
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/13 9:52
 */
public class SetTest {

    private static double testSet(Set<String> set, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("BST Set: " + time1 + " s");

        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("Linked List Set: " + time2 + " s");

    }
}

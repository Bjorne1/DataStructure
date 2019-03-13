package com.wcs.set;

import java.util.TreeSet;

/**
 * @Description: International Morse Code defines a standard encoding where each letter is
 * mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...",
 * "c" maps to "-.-.", and so on.
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/13 10:54
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }

            set.add(res.toString());
        }

        return set.size();
    }
}

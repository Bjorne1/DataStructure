package com.wcs.stack;

/**
 * @Description: 校验括号是否正确匹配
 * 正确:([])
 * 错误:([))
 * @Author: WenChangSheng
 * @Date: Created in 2019/3/7 11:45
 */
public class Solution {

    public static void main(String[] args) {
        String s = "{[]}";
        String s1 = "{[(]}";
        System.out.println(new Solution().isValid(s));
        System.out.println(new Solution().isValid(s1));
    }

    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

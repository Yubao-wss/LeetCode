import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: WSS
 * @Date: 2019/3/27 17:59
 * @Description: 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    //自己的思路
    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int  longestSize = 0;
            char[] inspector = s.toCharArray();
            int i = 0;
            while (i < inspector.length){
                int sameSize = 0;
                int j = i;
                HashSet<Character> helper = new HashSet<>();
                for (;j < inspector.length;j++){
                    if (helper.contains(inspector[j])){
                        break;
                    }
                    helper.add(inspector[j]);
                    sameSize++;
                }
                if (longestSize < sameSize){
                    longestSize = sameSize;
                }
                i++;
            }
            return longestSize;
        }
    }

    //暴力法
    /*
        假设我们有一个函数 boolean allUnique(String substring) ，
        如果子字符串中的字符都是唯一的，它会返回true，否则会返回false。
        我们可以遍历给定字符串 s 的所有可能的子字符串并调用函数 allUnique。
        如果事实证明返回值为true，那么我们将会更新无重复字符子串的最大长度的答案。
    */
    static class Solution2{
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j <= n; j++)
                    if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
            return ans;
        }

        public boolean allUnique(String s, int start, int end) {
            Set<Character> set = new HashSet<>();
            for (int i = start; i < end; i++) {
                Character ch = s.charAt(i);
                if (set.contains(ch)) return false;
                set.add(ch);
            }
            return true;
        }
    }

    //滑动窗口
    static public class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }
    }

    //滑动窗口的优化
    /*
        当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
        常用的表如下所示：
        int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
        int [128] 用于ASCII码
        int [256] 用于扩展ASCII码
    */
    static public class Solution4{
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }

    //假设字符集为 ASCII 128
    static public class Solution5 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        LengthOfLongestSubstring.Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLongestSubstring(test1));
        System.out.println(solution1.lengthOfLongestSubstring(test2));
        System.out.println(solution1.lengthOfLongestSubstring(test3));
        /*
         结果：
            3
            1
            3
        */
        String test4 = "ababac";
        LengthOfLongestSubstring.Solution5 solution5 = new Solution5();
        System.out.println(solution5.lengthOfLongestSubstring(test4));
        /*
         结果：
            3
        */
    }
}

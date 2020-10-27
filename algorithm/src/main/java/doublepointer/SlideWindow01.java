package doublepointer;

import java.util.HashMap;

public class SlideWindow01 {

    static HashMap<Character, Integer> need = new HashMap<>();
    static HashMap<Character, Integer> window = new HashMap<>();

    public static String minWindow(String s, String t) {
       int tlen = t.length(), slen = s.length();
       if (tlen == 0 || slen == 0) return "";

        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE, start = 0;
        int valid = 0;

        while (right < slen) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}

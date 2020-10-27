package doublepointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlideWindow02 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c :
                p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = p.length();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) valid--;
            }
            while (valid == 0) {
                if (right - left + 1 == p.length()) res.add(left);
                if (map.containsKey(s.charAt(left))) {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < map.get(s.charAt(left))) valid++;
                }
                left++;
            }
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.printf(findAnagrams(s,p).toString());
    }

}

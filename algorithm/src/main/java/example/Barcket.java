package example;

import netscape.security.UserTarget;

import java.util.HashMap;
import java.util.Stack;

public class Barcket {
    static boolean isvalud(String s) {
        HashMap pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Object> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (left.isEmpty() || left.peek() != pairs.get(c)) {
                    return false;
                }
                left.pop();
            } else {
                left.push(c);
            }
        }
        return left.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isvalud(s));
    }
}

package doublepointer;

import netscape.security.UserTarget;

import java.util.HashMap;

public class SlideWindow03 {
    public static int lengthOfLongestSubstring(String s) {
        // 异常输入排查
        if(s==null||s.length()==0){
            return 0;
        }
        int ans=0;
        int len=s.length();
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        // 右指针不断向前，直到字符串尾部
        while(end<len){
            ans = Math.max(ans,end-start);
            // 当遇到重复值，说明左指针需要跳转，跳转的位置是该重复值的下标+1
            // 比如字符串abcdecf，到遇到第二个c，即便从bcde任意一个开始，长度都无法超过a，只有从decf开始计算才是新一轮查找
            // 值得注意的是，如果碰到了重复值的下标比左指针还小的情况，不应该跳转，因为左指针左边的元素不再窗口内，比如abba
            if(map.containsKey(s.charAt(end))&&map.get(s.charAt(end))>=start){
                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end),end);		// 无论重不重复都需要更新，该元素最近的下标
            end++;
        }
        ans = Math.max(ans,end-start);
        return ans;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

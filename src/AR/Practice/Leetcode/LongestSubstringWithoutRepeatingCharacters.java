package AR.Practice.Leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters(" "));
    }
    public static int longestSubstringWithoutRepeatingCharacters(String S){
        if (S.length() == 0 ){
            return 0;
        }
        char[] ch = S.toCharArray();
        int ans = 0,left = 0,n = ch.length;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < n; right++) {

            char c = ch[right];
            if (right == 0){
                set.add(c);
                ans = Math.max(ans,right - left + 1);
                continue;
            }
            while (!set.add(c)){
                set.remove(ch[left++]);
            }
            ans = Math.max(ans,right - left + 1);


        }
        return ans;
    }
}

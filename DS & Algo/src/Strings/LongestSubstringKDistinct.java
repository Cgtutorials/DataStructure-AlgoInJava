package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public int findLength(String s1, int k){
        Map<Character,Integer> hm= new HashMap<>();
        int j=0,maxLength=0;

        for(int i=0;i<s1.length();i++){
            hm.put(s1.charAt(i),hm.getOrDefault(s1.charAt(i),0)+1);
            while(hm.size()>k){

                if(hm.get(s1.charAt(j))==1)
                    hm.remove(s1.charAt(j));
                else
                    hm.put(s1.charAt(j),hm.get(s1.charAt(j))-1);

                j++;
            }
            maxLength=Math.max(maxLength,i-j+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringKDistinct lc=new LongestSubstringKDistinct();
        System.out.println("Length of the longest substring: " + lc.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + lc.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + lc.findLength("cbbebi", 3));

    }
}

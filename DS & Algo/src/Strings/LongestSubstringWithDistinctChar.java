package Strings;

public class LongestSubstringWithDistinctChar {
    public static int findLength(String str) {
        int count=0,windowStart=0;
        int char1[]=  new int[26];
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);

            // if the array already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if(char1[c-'a']!=0){
                windowStart=Math.max(count,char1[c-'a']);
            }
            char1[c-'a']= i;
            count= Math.max(count,i-windowStart+1);
        }

        return count;
    }




    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctChar.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctChar.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + LongestSubstringWithDistinctChar.findLength("abccde"));

    }
}

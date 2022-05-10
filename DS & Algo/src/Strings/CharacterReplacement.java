package Strings;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int windowStart=0,maxLength=0,maxRepeatLetterCount=0;
        Map<Character,Integer> letterFrequencyMap= new HashMap<>();


        for(int windowEnd=0;windowEnd<str.length();windowEnd++){
            char rightChar=str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar,letterFrequencyMap.getOrDefault(rightChar,0)+1);
            maxRepeatLetterCount=Math.max(maxRepeatLetterCount,letterFrequencyMap.get(rightChar));

            if(windowEnd-windowStart+1 - maxRepeatLetterCount >k){
                char leftChar= str.charAt(windowStart);
                letterFrequencyMap.put(leftChar,letterFrequencyMap.get(leftChar)-1);
                windowStart++;
            }

            maxLength=Math.max(maxLength,windowEnd-windowStart+1);

        }
        return maxLength;
    }

    public static int findLength2(String str, int k) {
        int windowStart=0,maxLength=0,maxRepeatLetterCount=0;
        int[] letterFrequencyMap= new int[26];
        str=str.toLowerCase(Locale.ROOT);

        for(int windowEnd=0;windowEnd<str.length();windowEnd++){
            char rightChar=str.charAt(windowEnd);
            letterFrequencyMap[rightChar-'a']= letterFrequencyMap[rightChar-'a']+1;
            maxRepeatLetterCount=Math.max(maxRepeatLetterCount,letterFrequencyMap[rightChar-'a']);

            if(windowEnd-windowStart+1 - maxRepeatLetterCount >k){
                char leftChar= str.charAt(windowStart);
                letterFrequencyMap[leftChar-'a']= letterFrequencyMap[leftChar-'a']-1;
                windowStart++;
            }

            maxLength=Math.max(maxLength,windowEnd-windowStart+1);

        }
        return maxLength;
    }


    public static void main(String[] args) {
       System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));

        System.out.println(CharacterReplacement.findLength2("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength2("abbcb", 1));
       System.out.println(CharacterReplacement.findLength2("abccde", 1));
    }
}

package Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromeStrings {







    public static void main(String[] args) {
        String[] inputStr = {"aabbbaa", "321230990", "educative"};
        for (int i = 0; i < inputStr.length; i++) {
            List<String> result = findAllPalindromeSubstrings(inputStr[i]);
            System.out.println((i + 1) + ". Input string: " + inputStr[i]);
            System.out.println("   Palindromes: " + result.toString());
            System.out.println("   Total palindrome substrings: " + result.size());
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }

    private static List<String> findAllPalindromeSubstrings(String s) {

        List<String> l1= new ArrayList<>();

        for(int i=0;i<s.length();i++){

            //for Right
            findAllPalindromeHelper(s,i-1,i+1,l1);

            //forLeft
            findAllPalindromeHelper(s,i,i+1,l1);

        }

        return l1;
    }

    private static void findAllPalindromeHelper(String s, int left, int right, List<String> l1) {

        while(left>=0 && right < s.length()){
            if(s.charAt(left)!=s.charAt(right))
                break;

            l1.add(s.substring(left,right+1));
            left--;
            right++;
        }
    }
}

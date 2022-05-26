package Strings;

public class LongestPalindromicSubstring {

    private static String longestPalindromicSubstring(String input) {

        if(input==null || input.isEmpty()){
            return "";

        }

        int start=0,end=0;
        for(int i=0;i<input.length();i++){
            int len1= returnPalindromeLength(input,i,i);
            int len2= returnPalindromeLength(input,i,i+1);

            int len= Math.max(len1,len2);
            //ab hume new longest palindrome mil hai toh start aur end change karna hoga
            if(len>end-start){

                //start ko apne ko index k peeche lejana hoga , aur similarly index k agey end ko
                // QUestion len/2 kyn nahi kiye-- kynki ho sakte hai len mey index out of bound ajaye isilye len-1/2
                // neeche dekhna wo end +1 kar rahe hain
                start= i - (len-1)/2;
                end=i+len/2;
            }
        }

        return input.substring(start,end+1);
    }

    private static int returnPalindromeLength(String input, int left, int right) {
        while (left>=0 && right<input.length() && input.charAt(left)==input.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;

    }


    public static void main(String args[]) {
        // Driver code
        String[] inputs = {"", "abc", "1010", "aaccbababcbc", null};

        int index = 0;
        for (String input : inputs) {
            String inputStr = (input == null) ? "null" : "\"" + input + "\"";
            System.out.println((++index) + ". Input string: " + inputStr);
            System.out.println("   Longest Palindromic Substring: \""
                    + longestPalindromicSubstring(input) + "\"");
            System.out.println(
                    "-------------------------------------------------------------------------------------------------\n");
        }
    }


}

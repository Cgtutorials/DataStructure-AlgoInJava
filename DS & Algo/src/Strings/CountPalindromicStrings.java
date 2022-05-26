package Strings;

import java.util.ArrayList;
import java.util.List;

public class CountPalindromicStrings {

    public static void main(String[] args) {
        CountPalindromicStrings cps = new CountPalindromicStrings();
        System.out.println(cps.findCPS("abdbca"));
        System.out.println(cps.findCPS("cdpdd"));
        System.out.println(cps.findCPS("pqr"));
    }
    private int findCPS(String s) {
        boolean[][] isPalindrome= new boolean[s.length()][s.length()];
        int count=0;
        for(int i=0;i<s.length();i++){
            isPalindrome[i][i]=true;
            count++;
        }

        for(int start= s.length()-1;start>=0;start--){
            for(int end= start+1;end<s.length();end++){
                if(s.charAt(start)==s.charAt(end)){
                    if(end-start==1 || isPalindrome[start+1][end-1]){
                        isPalindrome[start][end]=true;
                        count++;
                    }
                }
            }
        }

        return count;
    }


}

package Strings;

import java.util.Arrays;

public class MinCutForPalindromeStrings {


    public static void main(String[] args) {
        MinCutForPalindromeStrings mpp = new MinCutForPalindromeStrings();
        System.out.println("findMPPCutsSimple");
        System.out.println(mpp.findMPPCutsSimple("abdbca"));
        System.out.println(mpp.findMPPCutsSimple("cdpdd"));
        System.out.println(mpp.findMPPCutsSimple("pqr"));
        System.out.println(mpp.findMPPCutsSimple("pp"));
        System.out.println(mpp.findMPPCutsSimple("madam"));

        System.out.println("findMPPCutsTopDown");
        System.out.println(mpp.findMPPCutsTopDown("abdbca"));
        System.out.println(mpp.findMPPCutsTopDown("cdpdd"));
        System.out.println(mpp.findMPPCutsTopDown("pqr"));
        System.out.println(mpp.findMPPCutsTopDown("pp"));
        System.out.println(mpp.findMPPCutsTopDown("madam"));

        System.out.println("findMPPCutsBottomUp");
        System.out.println(mpp.findMPPCutsBottomUp("abdbca"));
        System.out.println(mpp.findMPPCutsBottomUp("cdpdd"));
        System.out.println(mpp.findMPPCutsBottomUp("pqr"));
        System.out.println(mpp.findMPPCutsBottomUp("pp"));
        System.out.println(mpp.findMPPCutsBottomUp("madam"));
    }



    private int findMPPCutsSimple(String s1) {
        //Space 0n Time 2^n
        return findMPPCutsSimpleHelper(s1, 0, s1.length()-1);

    }

    private int findMPPCutsSimpleHelper(String s1, int start, int end) {

        if(start>=end || isPalindrome(s1,start,end)){
            return 0;
        }
        int minLength= end-start;
        for(int i=start;i<=end;i++){
            if(isPalindrome(s1,start,i)){
                minLength= Math.min(minLength,1+ findMPPCutsSimpleHelper(s1,i+1,end));
            }

        }

        return minLength;

    }

    private boolean isPalindrome(String s1, int start, int end) {
        while(start<end){
            if(s1.charAt(start++)!=s1.charAt(end--)){
                return false;
            }
        }

        return true;

    }


    /*Method 2 top down approach */

    private int findMPPCutsTopDown(String s1) {
        int[][] dp= new int[s1.length()][s1.length()];
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        boolean isPalindrome[][] = new boolean[s1.length()][s1.length()];
        return findMPPCutsTopDownHelper(s1,dp,isPalindrome,0,s1.length()-1);
    }

    private int findMPPCutsTopDownHelper(String s1, int[][] dp, boolean[][] isPalindrome, int start, int end) {
        if(start>=end || isPalindromeTopDown(isPalindrome,s1,start,end)){
            return 0;
        }

        int minCut=end-start;
        if(dp[start][end]==-1){
            for(int i=start;i<=end;i++){
                if(isPalindromeTopDown(isPalindrome,s1,start,i)){
                    minCut=Math.min(minCut,1 + findMPPCutsTopDownHelper(s1,dp,isPalindrome,i+1,end));
                }
            }
        }

        dp[start][end]=minCut;

        return dp[start][end];
    }

    private boolean isPalindromeTopDown(boolean[][] isPalindrome, String s1, int start, int end) {
        if(isPalindrome[start][end] == false){
            isPalindrome[start][end]=true;

            int x=start,y=end;
            while(x<y){
                if(s1.charAt(x++)!=s1.charAt(y--)){
                    isPalindrome[start][end]=false;
                    break;
                }
                if(x<y && isPalindrome[x][y]){
                    isPalindrome[start][end]=true;
                    break;
                }
            }

        }
        return isPalindrome[start][end];
    }


    /*Bottom up*/

    private int findMPPCutsBottomUp(String s1) {
        boolean isPalindrome[][] = new boolean[s1.length()][s1.length()];

        for(int i=0;i<s1.length();i++){
            isPalindrome[i][i]=true;
        }

        for(int start=s1.length()-1;start>=0;start--){
            for(int end=start+1;end<s1.length();end++){
                if(s1.charAt(start)==s1.charAt(end)){
                    if(end-start==1 || isPalindrome[start+1][end-1]){
                        isPalindrome[start][end]=true;
                    }
                }
            }
        }


        int[] cuts = new int[s1.length()];
        // now lets populate the second table, every index in 'cuts' stores the minimum cuts needed
        // for the substring from that index till the end
        for(int start=s1.length()-1;start>=0;start--){
            int minCut=s1.length();
            for (int end=s1.length()-1;end>=0;end--){
                if(isPalindrome[start][end]){
                    // we can cut here as we got a palindrome
                    // also we dont need any cut if the whole substring is a palindrome
                    minCut=end==s1.length()-1 ? 0 : Math.min(minCut,1+cuts[end+1]);
                }
            }

            cuts[start]=minCut;
        }

        return cuts[0];
    }

}

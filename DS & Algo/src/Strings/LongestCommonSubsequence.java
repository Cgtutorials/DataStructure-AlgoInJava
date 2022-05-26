package Strings;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("findLCSLengthBottomUp");
        System.out.println(lcs.findLCSLengthBottomUp("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthBottomUp("passport", "ppsspt"));



        System.out.println("findLCSLengthNormal");
        System.out.println(lcs.findLCSLengthNormal("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthNormal("passport", "ppsspt"));


        System.out.println("findLCSLengthTopDown");
        System.out.println(lcs.findLCSLengthTopDown("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthTopDown("passport", "ppsspt"));
    }

    private int findLCSLengthTopDown(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        int[][] dp= new int[m][n];
        return findLCSLengthTopDownHelper(s1,s2,dp,0,0);
    }

    private int findLCSLengthTopDownHelper(String s1, String s2, int[][] dp, int i, int j) {
        if(s1.length()==i || s2.length()==j){
            return 0;
        }
        if(dp[i][j]==0){
            if(s1.charAt(i)==s2.charAt(j)){
                dp[i][j]=1+ findLCSLengthTopDownHelper(s1,s2,dp,i+1,j+1);
            }
            else {
                // TODO:: ye i aur j ki value mey bhi locha hai i, j+1 aur i+1,j
                int c1 = findLCSLengthTopDownHelper(s1, s2, dp, i , j+1);
                int c2 = findLCSLengthTopDownHelper(s2, s2, dp, i+1, j);

            dp[i][j]=Math.max(c1,c2);
            }
        }

        return dp[i][j];
    }

    private int findLCSLengthNormal(String s1, String s2) {
        return findLCSLengthNormalHelper(s1,s2,0,0);
    }

    private int findLCSLengthNormalHelper(String s1, String s2, int i1, int i2) {
        if(s1.length()==i1 ||s2.length()==i2){
            return 0;
        }

        if(s1.charAt(i1)==s2.charAt(i2)){
            return 1+ findLCSLengthNormalHelper(s1,s2,i1+1,i2+1);
        }
        int c1= findLCSLengthNormalHelper(s1,s2,i1+1,i2);
        int c2= findLCSLengthNormalHelper(s1,s2,i1,i2+1);

        return Math.max(c1,c2);
    }

    private int findLCSLengthBottomUp(String s1, String s2) {

        int n=s1.length(),m=s2.length();
        int[][] dp= new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}

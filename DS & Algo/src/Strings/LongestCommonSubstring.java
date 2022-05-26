package Strings;

import sun.nio.cs.ext.MacHebrew;

public class LongestCommonSubstring {

//TODO:: Can we further improve our bottom-up DP solution? Can you find an algorithm that has O(n)
//O(n)
// space complexity?

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();

        System.out.println("findLCSLengthBottomUp  o(m*n)");
        System.out.println(lcs.findLCSLengthBottomUp("abdca", "cbda"));
        System.out.println(lcs.findLCSLengthBottomUp("passport", "ppsspt"));

        System.out.println("findLCSlengthNormal O(3^m+n) space is (m+n)");
        System.out.println(lcs.findLCSlengthNormal("abdca", "cbda"));
        System.out.println(lcs.findLCSlengthNormal("passport", "ppsspt"));


    }

    private int findLCSlengthNormal(String s1,String s2){
        return findLCSlengthNormalHelper(s1,s2,0,0,0);
    }

    private int findLCSlengthNormalHelper(String s1, String s2, int count, int i1, int i2) {

        if(i1==s1.length() || i2==s2.length() ){
            return count;
        }

        if(s1.charAt(i1)==s2.charAt(i2)){
            count= findLCSlengthNormalHelper(s1,s2,count+1,i1+1,i2+1);
        }

        int c1= findLCSlengthNormalHelper(s1,s2,0,i1+1,i2);
        int c2= findLCSlengthNormalHelper(s1,s2,0,i1,i2+1);

        return Math.max(count,Math.max(c1,c2));
    }

    private int findLCSLengthBottomUp(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        int dp[][]= new int[n+1][m+1];

        int max=Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(dp[i][j],max);
                }
            }
        }

        return max;
    }
}

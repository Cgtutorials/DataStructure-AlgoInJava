package DP;

public class LPS {

    public static void main(String[] args) {
        LPS lps = new LPS();
        System.out.println(lps.findLPSLengthBasic("abdbca"));
        System.out.println(lps.findLPSLengthBasic("cddpd"));
        System.out.println(lps.findLPSLengthBasic("pqr"));
        System.out.println(lps.findLPSLengthTopDown("abdbca"));
        System.out.println(lps.findLPSLengthTopDown("cddpd"));
        System.out.println(lps.findLPSLengthTopDown("pqr"));
        System.out.println(lps.findLPSLengthBottomUp("abdbca"));
        System.out.println(lps.findLPSLengthBottomUp("cddpd"));
        System.out.println(lps.findLPSLengthBottomUp("pqr"));
    }

    private int findLPSLengthBottomUp(String str) {
        int dp[][]= new int[str.length()][str.length()];
        return  1;
    }

    private int findLPSLengthTopDown(String str) {
        //no need to populate 0th Value
        int dp[][]= new int[str.length()][str.length()];

        return this.findLPSLengthTopDownHelper(str,0,str.length()-1,dp);
    }

    private int findLPSLengthTopDownHelper(String str, int start, int end, int[][] dp) {
        if(start>end){
            return 0;
        }
        if(start==end){
            return 1;
        }
        if(dp[start][end]!=0){
            return dp[start][end];
        }

        if(str.charAt(start)==str.charAt(end)){
            dp[start][end]= 2+ findLPSLengthTopDownHelper(str,start+1,end-1,dp);
        }
        else {
            int c1= findLPSLengthTopDownHelper(str,start+1,end,dp);
            int c2= findLPSLengthTopDownHelper(str,start,end-1,dp);

            dp[start][end]= Math.max(c1,c2);
        }

        return dp[start][end];

    }

    private int findLPSLengthBasic(String str) {
        return this.findLPSLengthBasicHelper(str,0,str.length()-1);

    }

    private int findLPSLengthBasicHelper(String str, int start, int end) {
        if(start>end){
            return 0;
        }
        //every sequence with 1 element is a palindrome
        if(start==end){
            return 1;
        }
        // elements at the begining and ending are the same
        if(str.charAt(start)==str.charAt(end))
            return 2 + findLPSLengthBasicHelper(str,start+1,end-1);

        int c1= findLPSLengthBasicHelper(str,start+1,end);
        int c2= findLPSLengthBasicHelper(str,start,end-1);

        return Math.max(c1,c2);

    }
}

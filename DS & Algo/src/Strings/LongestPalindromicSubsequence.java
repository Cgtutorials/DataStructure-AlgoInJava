package Strings;

public class LongestPalindromicSubsequence {




    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }

    private int findLPSLength(String input) {
        StringBuilder sb= new StringBuilder(input);
         sb.reverse();
        String inputReverse=sb.toString();
        System.out.println(inputReverse);

        int n= input.length();
        int m= inputReverse.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if(input.charAt(i-1)==inputReverse.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }

                else
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];



    }
}

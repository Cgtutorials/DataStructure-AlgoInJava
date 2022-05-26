package Strings;

public class MinDeletionToMakeStringPalindrome {


    public static void main(String[] args) {
        MinDeletionToMakeStringPalindrome mdsp = new MinDeletionToMakeStringPalindrome();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
    }

    private int findMinimumDeletions(String s1) {

        StringBuilder sb= new StringBuilder(s1.toString());
        sb.reverse();
        String s2= sb.toString();

        int[][] dp= new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<s1.length()+1;i++){
          dp[0][i]=0;
          dp[i][0]=0;
        }

        for(int i=1;i<s1.length()+1;i++){
            for (int j=1;j<s2.length()+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }

                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return s1.length()-dp[s1.length()][s2.length()];

    }
}

package Strings;

public class MinInsertAndDelete {


    public static void main(String[] args) {
        MinInsertAndDelete mdi = new MinInsertAndDelete();
        // We will take subString approach here
        //Minimum Deletions & Insertions to Transform a String into another
        mdi.findMDI("abc", "fbc");
        mdi.findMDI("abdca", "cbda");
        mdi.findMDI("passport", "ppsspt");
    }

    private void findMDI(String a1, String a2) {
        int[][] dp= new int[a1.length()+1][a2.length()+1];
        int maxLength= Integer.MIN_VALUE;
        for(int i=1;i<=a1.length();i++){
            for(int k=1;k<=a2.length();k++){
                if(a1.charAt(i-1)==a2.charAt(k-1)){
                    dp[i][k]= 1+ dp[i-1][k-1];
                }
                else {
                    dp[i][k]=Math.max(dp[i][k-1],dp[i-1][k]);
                }

                maxLength=Math.max(maxLength,dp[i][k]);
            }
        }

        System.out.println("Minimum deletions needed: " + (a1.length() - maxLength));
        System.out.println("Minimum insertions needed: " + (a2.length() - maxLength));

    }
}

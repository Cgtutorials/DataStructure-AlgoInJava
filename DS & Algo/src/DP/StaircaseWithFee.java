package DP;

public class StaircaseWithFee {
    public int findMinFeeBasic(int[] fee) {
        // TODO: Write your code here
        return findMinFeeBasicRec(fee, 0);
    }

    private int findMinFeeBasicRec(int[] fee, int currentIndex) {
        if(currentIndex>fee.length-1){
            return 0;
        }
        int take1Step= findMinFeeBasicRec(fee,currentIndex+1);
        int take2Step= findMinFeeBasicRec(fee,currentIndex+2);
        int take3Step= findMinFeeBasicRec(fee,currentIndex+3);

        int min= Math.min(Math.min(take3Step,take1Step),take2Step);

        return min + fee[currentIndex];
    }


    public int findMinTopDown(int[] fee) {
        int dp[] = new int[fee.length];
        return findMinTopDownRec(fee, 0,dp);

    }

    private int findMinTopDownRec(int[] fee, int currentIndex,int[] dp) {
        if(currentIndex>fee.length-1){
            return 0;
        }

        if(dp[currentIndex]!=0){
            return dp[currentIndex];
        }

        int take1Step= findMinTopDownRec(fee,currentIndex+1,dp);
        int take2Step= findMinTopDownRec(fee,currentIndex+2,dp);
        int take3Step= findMinTopDownRec(fee,currentIndex+3,dp);

        int min= Math.min(Math.min(take3Step,take1Step),take2Step);

        dp[currentIndex]= min + fee[currentIndex];

        return dp[currentIndex];
    }

    public int findMinfeeBottomUp(int[] fee) {
        int dp[] = new int[fee.length+1];  //0th step dekhne k liye , pichle wale mey 1 se karta tha isilye

        dp[0]= 0; // if no step then don't pay any fee
        dp[1]= fee[0]; // only 1 step so pay its fee;
        // for 2 or 3 steps staircase, since we start from the first step so we have to pay its fee
        // and from the first step we can reach the top by taking two or three steps, so we don't
        // have to pay any other fee.
        dp[2] = dp[3] = fee[0];

        for(int i=3;i<fee.length;i++){
            dp[i+1]= Math.min(fee[i] +dp[i],Math.min(fee[i-1] + dp[i-1] ,fee[i-2] + dp[i-2] ));
        }

        return dp[fee.length];
    }

    public static void main(String[] args) {
        StaircaseWithFee sc = new StaircaseWithFee();
        int[] fee = {1,2,5,2,1,2};
        int[] fee2 = new int[]{2,3,4,5};
        System.out.println(sc.findMinFeeBasic(fee));

        System.out.println(sc.findMinFeeBasic(fee2));

        System.out.println(sc.findMinTopDown(fee));

        System.out.println(sc.findMinTopDown(fee2));

        System.out.println(sc.findMinfeeBottomUp(fee));

        System.out.println(sc.findMinfeeBottomUp(fee2));
    }

}


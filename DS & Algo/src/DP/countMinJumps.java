package DP;

public class countMinJumps {

    public int countMinJumpsBasic(int[] jumps) {
        return this.countMinJumpsBasicRec(jumps,0);
    }

    //O(2^n)
    private int countMinJumpsBasicRec(int[] jumps, int currentIndex) {
        if(currentIndex==jumps.length-1){
            return 0;
        }
        if(jumps[currentIndex]==0)
            return Integer.MAX_VALUE;

        int totalJumps= Integer.MAX_VALUE;
        int start= currentIndex+ 1;
        int end= currentIndex + jumps[currentIndex];
        while (start<jumps.length && start<=end) {
            // jump one step and recurse for the remaining array
            int minJumps = countMinJumpsBasicRec(jumps, start++); //yaha pe yaad rakh agar tu start+1 bhejega toh while wala start incr nahihoga
            if (minJumps != Integer.MAX_VALUE) {
                totalJumps = Math.min(totalJumps, minJumps + 1);
            }
        }

        return totalJumps;

    }

    public int countMinJumpsTopDown(int[] jumps) {

        int[] dp= new int[jumps.length+1];
        return this.countMinJumpsTopDownRec(dp,jumps,0);

    }

    private int countMinJumpsTopDownRec(int[] dp, int[] jumps, int currentIndex) {
        if(currentIndex==jumps.length-1)
            return 0;
        if(jumps[currentIndex]==0)
            return Integer.MAX_VALUE;
        if(dp[currentIndex]!=0)
            return dp[currentIndex];

        int totalJumps= Integer.MAX_VALUE;
        int start= currentIndex+1;
        int end= currentIndex + jumps[currentIndex];

        while (start<jumps.length && start <= end){
            int minJumps= countMinJumpsTopDownRec(dp,jumps,start++);
            if(minJumps!=Integer.MAX_VALUE)
                totalJumps=Math.min(totalJumps,minJumps+1);
        }

        dp[currentIndex]=totalJumps;


        return dp[currentIndex];
    }

    public int countMinJumpsBottomUo(int[] jumps) {
         int dp[]= new int[jumps.length];

         //leave 0th index rest all should be set to MaxValue
         for(int i=1;i<jumps.length;i++){
             dp[i]= Integer.MAX_VALUE;
         }

         for(int start=0;start<jumps.length-1;start++){
             for(int end=start+1;end <= start+ jumps[start] && end<jumps.length ;end++){
                 dp[end]= Math.min(dp[end],dp[start]+1);
             }

        }

         return dp[jumps.length-1];



    }

    public static void main(String[] args) {
        countMinJumps aj = new countMinJumps();
        int[] jumps = {2, 1, 1, 1, 4};
        int[] jumps2 = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumpsBasic(jumps));

        System.out.println(aj.countMinJumpsBasic(jumps2));

        //O[n]
        System.out.println(aj.countMinJumpsTopDown(jumps));

        System.out.println(aj.countMinJumpsTopDown(jumps2));

        //O[n^2]
        System.out.println(aj.countMinJumpsBottomUo(jumps));

        System.out.println(aj.countMinJumpsBottomUo(jumps2));
    }
}

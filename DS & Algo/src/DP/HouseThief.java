package DP;

public class HouseThief {


    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        int[] wealth2 = new int[]{2, 10, 14, 8, 1};
        //o(2^n) factorial , o(n) space
        System.out.println(ht.findMaxStealbasic(wealth));
        System.out.println(ht.findMaxStealbasic(wealth2));

        //o(n)
        System.out.println(ht.findMaxStealTopDown(wealth));
        System.out.println(ht.findMaxStealTopDown(wealth2));

        //o(n)
        System.out.println(ht.findMaxStealBottonUp(wealth));
        System.out.println(ht.findMaxStealBottonUp(wealth2));

        //o(n) time and o(1) space
        System.out.println(ht.lessMemory(wealth));
        System.out.println(ht.lessMemory(wealth2));

    }

    private int lessMemory(int[] wealth) {
        int n1=0;
        int n2=wealth[0];
        int temp=0;
        for(int i=1;i<wealth.length;i++){
            temp=Math.max(n1+wealth[i],n2);
            n1=n2;
            n2=temp;
        }

        return temp;
    }

    private int findMaxStealBottonUp(int[] wealth) {
        int dp[]= new int[wealth.length+1];
        dp[0]=0;
        dp[1]=wealth[0];
        for(int i=1;i<wealth.length;i++){
            dp[i+1]= Math.max(dp[i-1]+wealth[i],dp[i]);
        }
        return dp[wealth.length];
    }

    private int findMaxStealTopDown(int[] wealth) {
        int dp[] = new int[wealth.length+1];
        return this.findMaxStealTopDownHelper(wealth,0,dp);

    }

    private int findMaxStealTopDownHelper(int[] wealth, int currentHouseIndex, int[] dp) {
        if(currentHouseIndex>= wealth.length){
            return 0;
        }
        if(dp[currentHouseIndex]!=0){
            return dp[currentHouseIndex];
        }
        int stealCurrent= wealth[currentHouseIndex] + findMaxStealTopDownHelper(wealth,currentHouseIndex+2,dp);
        int doNotStealCurrent= findMaxStealTopDownHelper(wealth,currentHouseIndex+1,dp);

        dp[currentHouseIndex]= Math.max(stealCurrent,doNotStealCurrent);

        return dp[currentHouseIndex];
    }


    private int findMaxStealbasic(int[] wealth) {
        return this.findMaxStealbasicHelper(wealth,0);
    }

    private int findMaxStealbasicHelper(int[] wealth, int currentHouseIndex) {
        if(currentHouseIndex>= wealth.length){
            return 0;
        }

        int stealCurrent= wealth[currentHouseIndex] + findMaxStealbasicHelper(wealth,currentHouseIndex+2);
        int doNotStealCurrent= findMaxStealbasicHelper(wealth,currentHouseIndex+1);

        return Math.max(stealCurrent,doNotStealCurrent);
    }
}

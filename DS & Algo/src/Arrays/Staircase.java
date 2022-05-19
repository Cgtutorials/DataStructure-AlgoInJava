package Arrays;

public class Staircase {

    public int CountWaysBasic(int n) {
       if(n==0){
           return 1;
       }
       if(n==1){
           return 1;
       }
       if(n==2){
           return 1;
       }

       int take1Step= CountWaysBasic(n-1);
       int take2Step= CountWaysBasic(n-2);
       int take3Step= CountWaysBasic(n-3);

        return take1Step+take2Step+take3Step;
    }

    public int CountWaysTopDown(int n) {
       int dp[] = new int[n+1];

       return CountWaysTopDownRecursive(dp,n);

    }

    private int CountWaysTopDownRecursive(int[] dp, int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dp[n]==0){
            int take1Step= CountWaysTopDownRecursive(dp,n-1);
            int take2Step= CountWaysTopDownRecursive(dp,n-2);
            int take3Step= CountWaysTopDownRecursive(dp,n-3);
            dp[n]= take1Step+take2Step+take3Step;
        }


        return dp[n];

    }


    //
    public int CountWaysBottomUp(int n) {
        int dp[] = new int[n+1];

       if(n<2) return 1;
       if(n==2) return 2;
       dp[0]=1;
       dp[1]=1;
       dp[2]=2;

       for(int i=3;i<=n;i++){
           dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
       }
       return dp[n];

    }

    //Memory optimization#
    public int CountWaysLessMemory(int n) {

        if(n<2) return 1;
        if(n==2) return 2;
      int n0=1,n1=1,n2=2,temp=0;

        for(int i=3;i<=n;i++){
           temp= n1+n2+n0;
           n0=n1;
           n1=n2;
           n2=temp;
        }
        return temp;

    }

    public static void main(String[] args) {
        Staircase sc = new Staircase();
       System.out.println(sc.CountWaysBasic(3));
        System.out.println(sc.CountWaysBasic(4));
        System.out.println(sc.CountWaysBasic(5));

       System.out.println(sc.CountWaysTopDown(3));
        System.out.println(sc.CountWaysTopDown(4));
        System.out.println(sc.CountWaysTopDown(5));

        System.out.println(sc.CountWaysBottomUp(3));
        System.out.println(sc.CountWaysBottomUp(4));
        System.out.println(sc.CountWaysBottomUp(5));

        System.out.println(sc.CountWaysLessMemory(3));
        System.out.println(sc.CountWaysLessMemory(4));
        System.out.println(sc.CountWaysLessMemory(5));
    }
}

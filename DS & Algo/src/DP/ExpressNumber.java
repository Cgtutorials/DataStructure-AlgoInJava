package DP;

public class ExpressNumber {

    public static void main(String[] args) {
        ExpressNumber sc = new ExpressNumber();

        System.out.println(sc.CountWaysBasic(4));
        System.out.println(sc.CountWaysBasic(5));
        System.out.println(sc.CountWaysBasic(6));

        System.out.println(sc.CountWaysTopDown(3));
        System.out.println(sc.CountWaysTopDown(4));
        System.out.println(sc.CountWaysTopDown(5));

        System.out.println(sc.CountWaysBottomUp(3));
        System.out.println(sc.CountWaysBottomUp(4));
        System.out.println(sc.CountWaysBottomUp(5));

    }

    private int CountWaysTopDown(int n) {

        return 1;
    }



    private int CountWaysBottomUp(int n) {
        return 1;
    }

    private int CountWaysBasic(int n) {
        if (n == 0)
            return 1; // base case, we don't need to subtract any thing, so there is only one way

        if (n == 1)
            return 1; // we can take subtract 1 to be left with zero, and that is the only way

        if (n == 2)
            return 1; // we can subtract 1 twice to get zero and that is the only way

        if (n == 3)
            return 2; // '3' can be expressed as {1,1,1}, {3}


        return CountWaysBasic(n-1) +CountWaysBasic(n-3) + CountWaysBasic(n-4);

    }
}

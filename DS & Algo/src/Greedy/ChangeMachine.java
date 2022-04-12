package Greedy;

import java.util.ArrayList;

class ChangeMachine
{
    // a public collection of available coins
    public static int [] coins = {25, 10, 5, 1};

    public static ArrayList<Integer> getMinCoins(int amount)  // function to recieve change in the form of coins
    {
        ArrayList<Integer> change = new ArrayList<Integer>();
        int coinIndex=0;
        while(amount>0){
            if(amount/coins[coinIndex]==0) {
                coinIndex++;
            }
            else{
              int i=  amount/coins[coinIndex];
              amount-=coins[coinIndex]*i;
              for(int k=0;k<i;k++){
                  change.add(coins[coinIndex] );
              }
            }

        }

        return change;
    }
    public static void main(String args[])
    {
        // Play around with this amount to see how many coins you get!
        int amount = 1;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 17;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 33;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 99;
        System.out.println(amount + " --> " + getMinCoins(amount));
    }
}
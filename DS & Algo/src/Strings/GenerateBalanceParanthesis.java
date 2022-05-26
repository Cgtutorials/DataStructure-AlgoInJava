package Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBalanceParanthesis {

    //Funda
    // Open and close pointers,have output list and a string (can use string builder too
    // if open and close are 0 add it to the list
    // if(open is not equal to 0) then take empty string op1= the string and add open to it
    // if (open<close) then add c also

    public static void main(String[] args) {
        GenerateBalanceParanthesis gbp = new GenerateBalanceParanthesis();
        System.out.println(gbp.generateParanthesis(3));

        System.out.println(gbp.generateParanthesisViaQueue(6));

    }
    class ParenthesesString{
        String str;
        int openCount;
        int closeCount;

        public ParenthesesString(String str, int openCount, int closeCount) {
            this.str = str;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    private  List<String> generateParanthesisViaQueue(int i) {
        List<String> l1= new ArrayList<>();
        Queue<ParenthesesString> queue= new LinkedList<>();
        queue.add(new ParenthesesString("",i,i));
        while (!queue.isEmpty()){
            ParenthesesString ps= queue.poll();
            if(ps.openCount==0 && ps.closeCount==0){
                l1.add(ps.str);
            }
            else{
                if(ps.openCount!=0){
                    queue.add(new ParenthesesString(ps.str+"(" , ps.openCount-1,ps.closeCount ));
                }
                if(ps.openCount< ps.closeCount){
                    queue.add(new ParenthesesString(ps.str+")",ps.openCount,ps.closeCount-1));
                }
            }

        }

        return l1;
    }

    private List<String> generateParanthesis(int i) {
        List<String> l1 = new ArrayList<>();
        generateParanthesisHelper(i, i, "", l1);
        return l1;

    }

    private void generateParanthesisHelper(int open, int close, String s, List<String> l1) {
        if (open == 0 && close == 0) {

            l1.add(s);

        } else {
            if (open != 0) {
                String op = s;
                op = s + "{";
                generateParanthesisHelper(open - 1, close, op, l1);
            }
            if (open<close) {
                String op2 = s;
                op2 = s + "}";
                generateParanthesisHelper(open, close - 1, op2, l1);
            }
        }
    }
}

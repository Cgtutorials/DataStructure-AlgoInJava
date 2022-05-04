package Strings;

import java.util.ArrayList;
import java.util.List;

public class PermutationChangingCase {

    public static void main(String[] args) {
        //0(N*2^n)
        List<String> result = PermutationChangingCase.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = PermutationChangingCase.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }

    private static List<String> findLetterCaseStringPermutations(String s1) {
        List<String> permutations= new ArrayList<>();
        if(s1==null){
            return permutations;
        }
        permutations.add(s1);
        for(int i=0;i<s1.length();i++){
            if(Character.isDigit(s1.charAt(i)))
                continue;
            int n= permutations.size();
            for(int j=0;j<n;j++){
                char[] chr= permutations.get(j).toCharArray();
                if(Character.isUpperCase(chr[i])){
                    chr[i]=Character.toLowerCase(chr[i]);
                }
                else
                    chr[i]=Character.toUpperCase(chr[i]);
                permutations.add(String.valueOf(chr));
            }
        }
            return permutations;
    }
}

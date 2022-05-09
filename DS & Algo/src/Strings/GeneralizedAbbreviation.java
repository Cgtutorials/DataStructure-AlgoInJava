package Strings;

import java.beans.PropertyEditorSupport;
import java.util.*;

public class GeneralizedAbbreviation {

   static class AbbreviateWord{
        StringBuilder str;
        int start;
        int count;

        public AbbreviateWord(StringBuilder str, int start, int count) {
            this.str = str;
            this.start = start;
            this.count = count;
        }
    }

    public static List<String> generateGeneralizedAbbreviation(String str) {
        int length= str.length();
        List<String> result= new ArrayList<>();
        Queue<AbbreviateWord> queue= new LinkedList<>();
        queue.add(new AbbreviateWord(new StringBuilder(),0,0));
        while (!queue.isEmpty()){
            AbbreviateWord currStr= queue.poll();
            if(currStr.start==length){
                if(currStr.count!=0){
                    currStr.str.append(currStr.count);
                }
                result.add(currStr.str.toString());
            }
            else{
                queue.add(new AbbreviateWord(new StringBuilder(currStr.str), currStr.start+1, currStr.count+1));

                if(currStr.count!=0){
                    currStr.str.append(currStr.count);
                }
                //The only problem is remembering when you are adding a new word from STRING
                queue.add(new AbbreviateWord(new StringBuilder(currStr.str).append(str.charAt(currStr.start)), currStr.start+1,0 ));
            }
        }
        return result;

     }



    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}


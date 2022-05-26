package Strings;

public class RegexMatching {

    public static boolean regxMatchMethod1(String s, String p) {
        return regxMatchRec(s, p);
    }

    private static boolean regxMatchRec(String text, String pattern) {

        //Recusrion k samay String aur pattern dono consume hogaye ho agar
        if(text.isEmpty() && pattern.isEmpty()){
            return true;
        }

        //pattern toh khmt hogya hai but text bacha hai
        if(pattern.isEmpty() && !text.isEmpty()){
            return false;
        }

        if(text.isEmpty() || pattern.isEmpty()){
            return false;
        }

        //ab * wildcard se baat karenge iska ye bolna hai ki ya toh ek se jyada ho sakte hain ya ek bhi nahi
        if(pattern.length()>1 && pattern.charAt(1)=='*'){
            //delho bhai 1 isilye liya hai ki mey pahle ye check kar raha hun ki * prefix kare kisi word ko
            //  toh isily do lena pad raha hai
            String remainingPattern= pattern.substring(2);
            String remainingText= text;


            for(int i=0;i<text.length()+1;i++){
                // Yaha pe trick hai thoda, like pahle text.length+1 kyn chal raha
                // yaha pe same text ko check karne se ye fayda hoga ki jo pattern[0] pe text hoga wo agar nahi bhi
                //hai toh chal jayega
                if(regxMatchRec(remainingText,remainingPattern)){
                    return true;
                }

                if(remainingText.isEmpty()){
                    return false;
                }

                //ab agar current pattern at 0 dot nahi ahi,,aur wo different hai remaing text at 0 k toh remport karo
                if(pattern.charAt(0)!='.' && pattern.charAt(0)!=remainingText.charAt(0)){
                    return false;
                }

                //sab kuch thik raha current tax ka character match kar liya
                remainingText= remainingText.substring(1);
            }
        }



        // ab toh pattern aur character agar same hai aur ya toh dot wild card hai tb ka kaam

        if(pattern.charAt(0)=='.' || pattern.charAt(0) == text.charAt(0)){
            String remainingText="";
            if(text.length()>=2){
                remainingText=text.substring(1);
            }
            String remainingPattern="";
            if(pattern.length()>=2){
                remainingPattern=pattern.substring(1);
            }

            return regxMatchRec(remainingText,remainingPattern);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("regxMatch(\"aa\", \"a\"): " + regxMatchMethod1("aa", "a"));
        System.out.println("regxMatch(\"aa\", \"a*\"): " + regxMatchMethod1("aa", "a*"));
        System.out.println("regxMatch(\"ab\", \".*\"): " + regxMatchMethod1("ab", ".*"));
        System.out.println("regxMatch(\"aab\", \"c*a*b\"): " + regxMatchMethod1("aab", "c*a*b"));
        System.out.println(
                "regxMatch(\"mississippi\", \"mis*is*p*.\"): " + regxMatchMethod1("mississippi", "mis*is*p*."));
    }
}

package Strings;

import java.util.HashMap;

public class RegexMatchingMemoization {
    static HashMap<String, Boolean> cache = new HashMap<String, Boolean>();

    public static boolean regxMatch(String text, String pattern) {
        cache.clear();
        return  false;
    }


    public static void main(String[] args) {
        System.out.println("regxMatch(\"aa\", \"a\"): " + regxMatch("aa", "a"));
        System.out.println("regxMatch(\"aa\", \"a*\"): " + regxMatch("aa", "a*"));
        System.out.println("regxMatch(\"ab\", \".*\"): " + regxMatch("ab", ".*"));
        System.out.println("regxMatch(\"aab\", \"c*a*b\"): " + regxMatch("aab", "c*a*b"));
        System.out.println(
                "regxMatch(\"mississippi\", \"mis*is*p*.\"): " + regxMatch("mississippi", "mis*is*p*."));
    }
}

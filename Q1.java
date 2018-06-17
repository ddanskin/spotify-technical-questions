/*------------------------------------------------------------------------------
 *  By: Danielle Danskin
 *  Created: 06/17/2018
 *
 *  Compilation: javac Q1.java
 *  Execution: java Q1
 *
 *  Question 1 -- sortByStrings(s,t): Sort the letters in the string s by the 
 *  order they occur in the string t. You can assume t will not have repetitive 
 *  characters. For s = "weather" and t = "therapyw", the output should be 
 *  sortByString(s, t) = "theeraw". For s = "good" and t = "odg", the output 
 *  should be sortByString(s, t) = "oodg".
 *----------------------------------------------------------------------------*/
import static java.lang.System.out;
import java.util.HashMap;

public class Q1 {

    // sorts characters in s by the order of the characters in t
    public static String sortByStrings(String s, String t) {
        String sortedS = new String();

        HashMap<Character,Integer> mapS = new HashMap<>();

        // save letters and their frequency counts to mapS
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if(!mapS.containsKey(letter)) {
                mapS.put(letter, 1);
            } else {
                Integer count = mapS.get(letter);
                mapS.put(letter, ++count);
            }
        }

        // iterate through t (the sorted array) and add characters from s to 
        // sortedS
        for (int j = 0; j < t.length(); j++) {
            while (mapS.containsKey(t.charAt(j)) && mapS.get(t.charAt(j)) > 0) {
                sortedS += t.charAt(j);
                Integer count = mapS.get(t.charAt(j));
                mapS.put(t.charAt(j), --count);
            }
        }
        
        return sortedS;
    }

    // test cases for sortByStrings
    public static void main(String[] args) {
    
        String s = "weather";
        String t = "therapyw";

        System.out.println(sortByStrings(s, t));

        String a = "good";
        String b = "odg";
        System.out.println(sortByStrings(a, b));
    }
}

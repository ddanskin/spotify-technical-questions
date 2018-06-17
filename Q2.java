/*------------------------------------------------------------------------------
 *  By: Danielle Danskin
 *  Created: 06/17/2018
 *
 *  Compilation: javac Q2.java
 *  Execution: java Q2
 *
 *  Question 2 -- decodeString(s): Given an encoded string, return its 
 *  corresponding decoded string. 
 *
 *  The encoding rule is: k[encoded_string], where the encoded_string inside the 
 *  square brackets is repeated exactly k times. Note: k is guaranteed to be a 
 *  positive integer.
 *  For s = "4[ab]", the output should be decodeString(s) = "abababab"
 *  For s = "2[b3[a]]", the output should be decodeString(s) = "baaabaaa"
 *---------------------------------------------------------------------------*/
import static java.lang.System.out;
import java.util.Stack;

public class Q2 {

    // decodes string by parsing out encoded string and integer k
    // returns new string that repeats encoded string k times
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();
        String result = new String();

        // iterate through the string
        for (int i = 0; i < s.length(); i++) {
            // if not closing bracket, push on to stack
            if (s.charAt(i) != ']'){
                stack.push(s.charAt(i));
            } else {
                String temp = new String();
                
                // create string to be repeated
                while (stack.peek() != '['){
                    temp = stack.pop() + temp;
                }
                stack.pop(); // removes '[' from stack
                
                // sets k to the integer value of the next stack character
                int k = Character.getNumericValue(stack.pop());

                // saves the repeated string to result
                result = multiplyString(k, temp + result);
            }
        }
        return result;
    }

    // repeats a given string n times and saves as new string
    private static String multiplyString(int n, String str) {
        String multipliedS = new String();
        for (int i = 0; i < n; i++) {
            multipliedS += str;
        }
        return multipliedS;
    }

    // test cases for decodeString
    public static void main(String[] args) {
        String s = "4[ab]";
        System.out.println(decodeString(s));

        String a = "2[b3[a]]";
        System.out.println(decodeString(a));

    }
}

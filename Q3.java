/*------------------------------------------------------------------------------
 *  By: Danielle Danskin
 *  Created: 06/17/2018
 *
 *  Compilation: javac Q3.java
 *  Execution: java Q3
 *
 *  Question 3 -- changePossibilities(amount,amount): Your quirky boss collects 
 *  rare, old coins. They found out you're a programmer and asked you to solve 
 *  something they've been wondering for a long time.
 *  
 *  Write a function that, given an amount of money and an array of coin 
 *  denominations, computes the number of ways to make the amount of money with 
 *  coins of the available denominations.
 *
 *  Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢), your 
 *  program would output 4—the number of ways to make 4¢ with those denominations:
 *
 *  1¢, 1¢, 1¢, 1¢
 *  1¢, 1¢, 2¢
 *  1¢, 3¢
 *  2¢, 2¢
 *----------------------------------------------------------------------------*/
import static java.lang.System.out;
import java.util.Arrays;

public class Q3 {

    // returns count of ways given denominations can add up to given amount
    public static int changePossibilities (int amt, int[] denom){
        //if amt is zero or denom is empty, return 0
        if (amt == 0 || denom.length == 0) {
            return 0;
        }

        Arrays.sort(denom); // makes sure denominations are in ascending order
        return count(amt, denom);
    }

    // recursively subtracts denominations from amount and counts how many
    // ways it evenly subtracts to reach zero  
    private static int count (int amt, int[] denom) { 
        // if amt equals zero, goal has been reached, add one to count
        if (amt == 0) {
            return 1;
        }
        
        int n = denom.length;

        // if amt is greater than zero and denominations to subtract
        if (amt > 0 && n > 0) {
            int[] subArray = Arrays.copyOf(denom, n-1);
            return count(amt, subArray) + count(amt - denom[n-1], denom);
        }

        return 0;
    }
    
    // test cases for changePossibilities
    public static void main (String[] args) {
        int amt = 4;
        int[] denoms = {1,2,3};
        System.out.println(changePossibilities(amt, denoms));
    }
}


package org.fska.projects.problems1_99.prob_1_9;

import java.util.List;

public class Problem4 {
    /**
     * Create the largest palindrome made from the product of two numbers within the upper limit
     * @param limit
     *  Upper Limit
     * @return
     *  Palindrome of the product of two numbers under the defined upper limit
     */
    public static long largestPalindrome(long limit){

        long a = limit - 1, b = a;
        long largestPalidrome = 0;
        long val = 0;
        for(; a > 1; a--){
            for(b = a; b > 1; b--){
                val = a * b;
                if(testPalindrome(val) && val > largestPalidrome){
                    largestPalidrome = val;
                }
            }
        }

        return largestPalidrome;
    }

    private static boolean testPalindrome(long input){
        String strInput = Long.toString(input);
        StringBuffer sb = new StringBuffer(strInput);
        return new StringBuffer(strInput).reverse().toString().equals(sb.toString());
    }
}

package org.fska.projects.problems1_99.prob_1_9;

public class Problem2 {
    public static long fibonacciSumOfEvenValueTerms(long limit){
        long a = 1, b = 2, c = a + b;
        long result = 2;
        while(c < limit){
            if((c % 2) == 0) result += c;
            a = b;
            b = c;
            c = a + b;
        }
        return result;
    }
}

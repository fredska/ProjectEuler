package org.fska.projects.problems1_99.prob_1_9;

public class Problem1 {
    public static long findMultiplesOf3Or5(long limit){
        long result = 0;
        for(long i = 0; i < limit; i++){
            if((i % 3) == 0 || (i % 5) == 0)
                result += i;
        }
        return result;
    }
}

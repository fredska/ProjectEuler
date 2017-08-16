package org.fska.projects.problems1_99.prob_1_9;

public class Problem6 {
    public static long sumSquareDifference(long limit){
        long a = 0, b = 0;
        for(long idx = 1; idx <= limit; idx++){
            a += (idx * idx);
            b += idx;
        }
        return (b * b) - a;
    }
}

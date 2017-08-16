package org.fska.projects.problems1_99.prob_1_9;

public class Problem9 {
    /**
     * There exists exactly one Pythagorean triplet where a + b + c = 1000
     * @param limit
     * @return The product of a*b*c
     */
    public static long specialPythagoreanTriplet(long limit){

        for(long c = limit; c > 3; c--){
            for(long b = c-1; b > 2; b--){
                for(long a = b - 1; a > 1; a--){
                    if(a + b + c == limit) {
                        if ((a * a + b * b) == (c * c)) {
                            return a * b * c;
                        }
                    }
                }
            }
        }
        return 0l;
    }
}

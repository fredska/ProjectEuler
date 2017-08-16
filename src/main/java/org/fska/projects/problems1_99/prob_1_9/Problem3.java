package org.fska.projects.problems1_99.prob_1_9;


import utils.common.SieveOfEratosthenes;

public class Problem3 {
    public static long largestPrimeFactor(long input){
        int sqrt = (int)Math.sqrt((double) input);

        SieveOfEratosthenes soe = new SieveOfEratosthenes();
        boolean[] soeResults = soe.getPrimesToLimit(sqrt);
        sqrt--;
        while(sqrt > 1) {
            if (soeResults[sqrt] && ((input % sqrt) == 0)) return sqrt;
            sqrt--;
        }

        return sqrt;
    }
}

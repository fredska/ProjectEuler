package org.fska.projects.problems1_99.prob_10_19;

import utils.common.SieveOfEratosthenes;

public class Problem10 {
    public static long summationOfPrimes(int limit){
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        boolean[] primes = sieveOfEratosthenes.getPrimesToLimit(limit + 10);
        long result = 0;
        for(int i = 0; i < limit; i++){
            if(primes[i]){
                result += i;
            }
        }

        return result;
    }
}

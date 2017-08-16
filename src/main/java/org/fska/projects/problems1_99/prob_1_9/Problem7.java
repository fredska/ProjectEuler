package org.fska.projects.problems1_99.prob_1_9;

import utils.common.SieveOfEratosthenes;

public class Problem7 {
    public static long findPrimeNumber(int position){
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        boolean[] primes = sieveOfEratosthenes.getPrimesToLimit(10000000);
        int primeCount = 0;
        for(int idx = 2; idx < Integer.MAX_VALUE; idx++){
            if(primes[idx]){
                primeCount++;
            }

            if(primeCount == position)
                return idx;
        }
        return -1l;
    }
}

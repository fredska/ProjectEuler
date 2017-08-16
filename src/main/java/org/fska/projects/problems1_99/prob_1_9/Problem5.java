package org.fska.projects.problems1_99.prob_1_9;

import utils.common.SieveOfEratosthenes;

import java.util.HashSet;
import java.util.Set;

public class Problem5 {
    private static boolean[] primes;
    public static long findSmallestMultiple(long limit){

        /** This section isn't necessary per-say, but it is within the confines that is 'long' length **/
        initializePrimes(limit);
        long result = 1;
        for(long i = 3; i < limit; i++){
            long multiple = getSmallestPrimeFactor(i);
            result *= getSmallestPrimeFactor(i);
        }

        /* Reduce the result from above by effectively each prime factor until it can no longer be reduced */

            for (int div = 2; div < limit; div++) {
                while (validateResult(result / div, limit)) {
                    result /= div;
                }
            }


        return result;
    }

    private static void initializePrimes(long limit){
            SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
            primes = sieveOfEratosthenes.getPrimesToLimit((int)limit);
    }

    private static long getSmallestPrimeFactor(long val){
        for(int i = 2; i < val; i++){
            if((val % i) == 0)
                return i;
        }
        return val;
    }

    private static boolean validateResult(long input, long limit ){
        for(int chk = 2; chk < limit; chk++){
            if((input % chk) != 0)
                return false;
        }
        return true;
    }
}

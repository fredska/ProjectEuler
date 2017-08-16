package org.fska.projects.test;

import org.fska.projects.problems1_99.prob_10_19.Problem10;
import org.fska.projects.problems1_99.prob_1_9.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProjectEulerTests {

    @Test
    public void problem1_test() throws Exception {
        long testResult = Problem1.findMultiplesOf3Or5(10);
        assertEquals(23, testResult);

        //If test holds true, sout final answer
        System.out.println("Problem 1 Solution: " + Problem1.findMultiplesOf3Or5(1000));
    }

    @Test
    public void problem2_test() throws Exception {
        long testResult = Problem2.fibonacciSumOfEvenValueTerms(100);
        assertEquals(44, testResult);

        System.out.println("Problem 2 Solution: " + Problem2.fibonacciSumOfEvenValueTerms(4000000));
    }

    @Test
    public void problem3_test() throws Exception {
        long testResult = Problem3.largestPrimeFactor(13195);
        assertEquals(29l, testResult);

        System.out.println("Problem 3 Solution: " + Problem3.largestPrimeFactor(600851475143l));
    }

    @Test
    public void problem4_test() throws Exception {
        long testResult = Problem4.largestPalindrome(100);
        assertEquals(9009, testResult);

        System.out.println("Problem 4 Solution: " + Problem4.largestPalindrome(1000));
    }

    @Test
    public void problem5_test() throws Exception {
        long testResult = Problem5.findSmallestMultiple(10);
        assertEquals(2520l, testResult);

        System.out.println("Problem 5 Solution: " + Problem5.findSmallestMultiple(20));
    }

    @Test
    public void problem6_test() throws Exception {
        long testResult = Problem6.sumSquareDifference(10);
        assertEquals(2640, testResult);

        System.out.println("Problem 6 Solution: " + Problem6.sumSquareDifference(100));
    }

    @Test
    public void problem7_test() throws Exception {
        long testResult = Problem7.findPrimeNumber(6);
        assertEquals(13, testResult);

        System.out.println("Problem 7 Solution: " + Problem7.findPrimeNumber(10001));
    }

    @Test
    public void problem8_test() throws Exception {
        long testResult = Problem8.largestProductInSeries(4);
        assertEquals(5832l, testResult);

        System.out.println("Problem 8 Solution: " + Problem8.largestProductInSeries(13));
    }

    @Test
    public void problem9_test() throws Exception {
        long testResult = Problem9.specialPythagoreanTriplet(12);
        assertEquals(3*4*5, testResult);

        System.out.println("Problem 9 Solution: " + Problem9.specialPythagoreanTriplet(1000));
    }

    @Test
    public void problem10_test() throws Exception {
        long testResult = Problem10.summationOfPrimes(10);
        assertEquals(17l, testResult);

        System.out.println("Problem 10 Solution: " + Problem10.summationOfPrimes(2000000));
    }
}

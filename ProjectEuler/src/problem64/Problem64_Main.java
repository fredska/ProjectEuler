package problem64;

import java.math.BigDecimal;

public class Problem64_Main {

	public static void main(String[] args) {
		Problem64_Main problem = new  Problem64_Main();
		problem.run();
	}
	
	public void run(){
		BigDecimal bd = new BigDecimal(1.0);
		int[] period;
		int result = 0;
		for(int i = 2; i <= 10000; i++){
			//If the value is a perfect square root,
			// no need to go further
			if((int)Math.sqrt(i) == (Math.sqrt(i)))
				continue;
			System.out.print("sqrt: " + i + "=[");
			period = getSquareRootPeriod(i);
			int periodSize = findPeriodRepeatingLength(period);
			boolean isOddPeriod = (periodSize % 2) == 1;
			if(isOddPeriod) result++;
			System.out.println("Square Root: " + i + " :: Repeating Periods: " + findPeriodRepeatingLength(period));
		}
		System.out.println("Final Answer: " + result);
	}
	
	/**
	 * I'm a big dummy for taking the easy route :P
	 * 
	 * The code should compute each iteration like the following steps:
	 * 
	 * a0 = 1 / (sqrt(23) - 4)
	 * Multiply out the square root from the denominator
	 * -> 1 * (sqrt(23) + 4) / ((sqrt(23) - 4) * (sqrt(23) + 4))
	 * -> (sqrt(23) + 4) / (23 - 16)
	 * -> (sqrt(23) + 4) / 7
	 * -> get the int value from the provided fraction (in this case, 1
	 * a1 = 1, (sqrt(23) - 3) / 7
	 * @param value
	 * @return
	 */
	public int[] getSquareRootPeriod(int squareRoot){
		int numerator = 1, denominator = 1;
		final double squareRootValue = Math.sqrt(squareRoot);
		int[] result = new int[1000];
		double tmpValue = squareRootValue;
		
		//Initial pass:
		int base = (int) tmpValue;
		result[0] = base;
		numerator = 1;
		denominator = -base;
		for(int i = 1; i < result.length; i++){
			//New, awesome, CORRECT way
			int tmpNumerator = numerator;
			int tmpDenominator = denominator;
			numerator = (squareRoot - (tmpDenominator * tmpDenominator)) / tmpNumerator;
			base = (int)((squareRootValue - (double)tmpDenominator) / (double)numerator);
			denominator = -tmpDenominator - (numerator * base);
			result[i] = base;
		}
		return result;
	}
	
	public int findPeriodRepeatingLength(int[] period){
		int periodLength = 1;
		boolean isRepeating;
		while(periodLength < (period.length / 2) - 1){
			isRepeating = true;
			for(int i = 1; i < periodLength+1; i++){
				if(period[i] != period[i+periodLength])
					isRepeating = false;
			}
			if(isRepeating && verifyRepeatingLength(period, periodLength)) break;
			periodLength++;
		}
		
		return periodLength;
	}
	
	public boolean verifyRepeatingLength(int[] period, int periodLength){
		int[] newPeriod = new int[period.length];
		newPeriod[0] = period[0];
		int arrayIndexCount = 1;
		while(arrayIndexCount < period.length){
			newPeriod[arrayIndexCount] = period[((arrayIndexCount - 1) % periodLength) + 1];
			arrayIndexCount++;
		}
		for(int i = 0; i < period.length; i++){
			if(period[i] != newPeriod[i]) return false;
		}	
		return true;
	}
}
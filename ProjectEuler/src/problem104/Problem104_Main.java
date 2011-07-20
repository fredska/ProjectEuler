package problem104;

import java.math.BigInteger;

public class Problem104_Main {

	public static int COUNT = 0;
	public static void main(String args[])
	{
		Fibonacci fib = new Fibonacci();
		fib.run();
		
	}
}

class Fibonacci
{
	private static int COUNTER = 0;
	private long result = 0l;
	
	public Fibonacci()
	{
		;
	}
	
	public void run()
	{
		BigInteger f1 = BigInteger.valueOf(1l);
		BigInteger f2 = BigInteger.valueOf(2l);
//		BigInteger test = BigInteger.valueOf(2131860806816816816l);
//		System.out.println("Get Top Digits: " + getTopDigits(test));
//		System.out.println("Get Bottom Digits: " + getBottomDigits(test));
		computeFibonacci(f1,f2, 3);
		System.out.println("Done! COUNTER: " + COUNTER);
	}
	
	public void computeFibonacci(BigInteger prev, BigInteger current, int fCount)
	{ COUNTER++;
	int temp = 0;
		if(fCount > 5000)
		{
			return;
		}
		else
		{
			if((temp = findLength(current)) > 10)
			{
				if(checkPandigital(Integer.toString(getTopDigits(current, temp))) && checkPandigital(Integer.toString(getBottomDigits(current))))
				{
					return;
				}
			}
			if((fCount % 250) == 0)
			{
				System.out.println("Step #: " + fCount);
			}
			computeFibonacci(current, prev.add(current), fCount+1);
		}
	}
	
	private boolean checkPandigital(String nums)
	{
		boolean[] checkValue = new boolean[9];
		boolean result = true;
		for(Character value : nums.toCharArray())
		{
			switch(value)
			{
			case '0': // Cannot have any zeros, only 1 - 9 digits
				return false;
				default:
					checkValue[Character.getNumericValue(value) -1] = true;
					
			}
		}
		
		for(int count = 0; count < checkValue.length; count++)
		{
			result = result && checkValue[count];
		}
		
		return result;
	}
	
	private boolean checkPandigital(int value)
	{
		boolean[] checkValue = new boolean[9];
		boolean result = true;
		
		//Use the integer value to determine the boolean values
		
		for(int count = 0; count < checkValue.length; count++)
		{
			result = result && checkValue[count];
		}
		
		return result;
	}
	
	private int findLength(BigInteger value)
	{
		int count = 2;
		BigInteger temp = value;
		while((temp = temp.divide(BigInteger.TEN)).compareTo(BigInteger.TEN) == 1)
		{
			count++;
		}
		
		return count;
	}
	
	private int getTopDigits(BigInteger value, int length)
	{
		int result = 0;
		
		BigInteger temp = value;
		if(COUNTER > 2500)
		{
			BigInteger d1 = BigInteger.valueOf(10l).pow((length-9)/2);
			BigInteger d2 = BigInteger.valueOf(10l).pow((length-9)/2);
			if((length % 2) == 0)
			{
				d1 = BigInteger.valueOf(10l).pow((length-7)/2);
				d2 = BigInteger.valueOf(10l).pow((length-9)/2);
			}
			temp = temp.divide(d1);
			result = temp.divide(d2).intValue();
		}
		else
		{
			BigInteger divide = BigInteger.valueOf(10l).pow(length-9);
			result = temp.divide(divide).intValue();
		}
	
		
		return result;
	}
	
	private int getBottomDigits(BigInteger value)
	{
		int result = 0;
		
		BigInteger temp = value.mod(BigInteger.valueOf(1000000000));
		
		result = temp.intValue();
		return result;
	}
}

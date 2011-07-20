package problem206;

import java.util.Date;
import java.util.Calendar;
import java.util.Timer;

public class Problem206_Main {

	final static int TOTAL_RECORDS = 1000000000;
	final static int numOfRecordsProcessed = 50000;
	/**
	 * Should have at MOST 1 bil combinations to utilize.  With luck, it won't be nearly that many.
	 * Brute force attempt to be used at first
	 * @param args
	 */
	public static void main(String[] args) {
		AlternateMethod am = new AlternateMethod();
		am.alternate();
		/*
		String[] nums = new String[]{"0","0","0","0","0","0","0","0","0"};
		final String[] constant = new String[]{"1","2","3","4","5","6","7","8","9","0"};
		Calendar startTime = Calendar.getInstance();
		startTime.get(Calendar.MILLISECOND);
		Calendar currentTime = startTime;
		Calendar markTime = startTime;
		int numOfRecordCheck = 50000;
		for(int a=0; a < TOTAL_RECORDS; a++)
		{
			if(checkSquareRoot(nums, constant))
				{
					System.out.println("We have a winner!");
					System.out.println(toString(nums, constant));
					break;
				}
			nums = returnArray(nums, 1l);
			if((a % numOfRecordsProcessed) == 0)
			{
				currentTime = Calendar.getInstance();
				long milliseconds = currentTime.getTimeInMillis() - markTime.getTimeInMillis();
				checkTimeLeft(markTime, currentTime, a);
				markTime = currentTime;
				
			}
			//System.out.println(toString(nums));
		}
		*/
	}
	
	public static void checkTimeLeft(Calendar markTime, Calendar currentTime, int numOfRecordsProcessed)
	{
		String salutation = "Est. Time Left (in seconds): ";
		int recordsLeft = TOTAL_RECORDS - numOfRecordsProcessed;
		long milliseconds = currentTime.getTimeInMillis() - markTime.getTimeInMillis();
		
		long estimateTimeLeft = (long)recordsLeft / milliseconds;
		System.out.println(salutation + (estimateTimeLeft/ 1000) + " -- Total Processed: " + numOfRecordsProcessed);
		
	}
	
	public static boolean checkSquareRoot(String[] nums, String[] constant)
	{
		//Build the two strings together
		StringBuilder sb = new StringBuilder();
		for(int a = 0; a < nums.length; a++)
		{
			sb.append(constant[a]);
			sb.append(nums[a]);
		}
		//Tack on the last number from the constant's array
		sb.append(constant[9]);
		String combined = sb.toString();
		Double dblCombined = Double.parseDouble(combined);
		//System.out.println(dblCombined);
		double sqrtCombined = Math.sqrt(dblCombined);
		if(Double.toString(dblCombined/100000000).length() < 5)
			return true;
		//System.out.println(sqrtCombined/100000000);
		return false;
	}
	
	/**
	 * Returns the next iteration in the "numerical" string array
	 * @param input
	 * @return
	 */
	private static String[] returnArray(String[] input, Long increaseAmount)
	{
		String[] output = input;
		
		Long calcResult = 0l;
		Double temp = 0d;
		int a,b;
		//convert the String[] to a double
		for(a = 0, b = (input.length-1); b >= 0; a++, b--)
		{
			temp += Double.parseDouble(input[a]) * Math.pow(10,b);
		}
		
		calcResult = Math.round(temp);
		//Add by 1
		calcResult += increaseAmount;
		
		String temp2 = calcResult.toString();
		//Convert Long back to String[]

		for(a = 0, b = (input.length); b > 0; a++, b--)
		{
			if(temp2.length() < b)
			{
				output[a] = "0";
			}
			else
			{
				Long lngTemp = calcResult;
				lngTemp -= (long)(lngTemp % (Math.pow(10, b-1)));
				lngTemp = lngTemp / (long)Math.pow(10,b-1);
				//System.out.println("Place: " + (a+1) + " -- Value: " + lngTemp);
				output[a] = Long.toString(lngTemp);
				calcResult = calcResult - (long)(lngTemp * (Math.pow(10, b-1)));
			}
		}
		
		
		return output;
	}
	
	private static String toString(String[] input)
	{
		StringBuilder sb = new StringBuilder();
		for(String str : input)
		{
			sb.append(str);
		}
		
		return sb.toString();
	}
	
	private static String toString(String[] nums, String[] constant)
	{
		StringBuilder sb = new StringBuilder();
		for(int a = 0; a < nums.length; a++)
		{
			sb.append(constant[a]);
			sb.append(nums[a]);
		}
		//Tack on the last number from the constant's array
		sb.append(constant[9]);
		return sb.toString();
	}

}

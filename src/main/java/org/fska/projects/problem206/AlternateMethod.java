package org.fska.projects.problem206;

import java.util.Calendar;

public class AlternateMethod {
	final static Long startNum = 1010101010l;
	final static Long endNum = 1389026623l;
	public void alternate()
	{

		Long checkRecordCount = 1000000l;
		Calendar startTime = Calendar.getInstance();
		Calendar currentTime = startTime;
		Calendar markTime = startTime;
		/* TEST */
		Long testValue = 1020304050607080900l;
		if(checkDouble(testValue))
			System.out.println("Test Success!");
		else
			System.out.println("Test Failed!");
		
		for(Long count = startNum; count <= endNum; count++)
		{
			if(checkDouble(count*count))
			{
				System.out.println("Final Value found! : " + count);
				break;
			}
			
			if((count%checkRecordCount) == 0)
			{
				//currentTime = Calendar.getInstance();
				//long milliseconds = currentTime.getTimeInMillis() - markTime.getTimeInMillis();
				//checkTimeLeft(markTime, currentTime, count);
				//markTime = currentTime;
				System.out.println("Records Left: " + (endNum - count));
			}
		}
		System.out.println("Trick didn't work!");
	}
	
	public static void checkTimeLeft(Calendar markTime, Calendar currentTime, long numOfRecordsProcessed)
	{
		String salutation = "Est. Time Left (in seconds): ";
		long recordsLeft = endNum - numOfRecordsProcessed;
		long milliseconds = currentTime.getTimeInMillis() - markTime.getTimeInMillis();
		
		long estimateTimeLeft = (long)recordsLeft / milliseconds;
		System.out.println(salutation + (estimateTimeLeft/ 1000) + " -- Total Processed: " + numOfRecordsProcessed);
		
	}

	private boolean checkDouble(Long value)
	{

		char[] numValues = Long.toString(value).toCharArray();

		for(int a = 0; a < 9; a++)
		{
			if(Character.getNumericValue(numValues[a*2]) != (a+1))
				return false;
		}
		if(Character.getNumericValue(numValues[18]) != 0)
			return false;
		
		return true;
	}
}

package problem55;
/**
 * Problem states to find all Lychel numbers below 10,000
 * Restrictions;
 * 	must be palindromic by the end
 * 	if after 50 iterations, no palindromic number is found, it is considered Lychrel
 * @author c1dev
 *
 */
public class Main {

	/**
	 * @param args
	 */
	
	private static final int ITERATION_LIMIT = 50;
	public static void main(String[] args) {
		long value = 1;
		int lychrelCount = 0;
		confirmLychrel(349l,0);
		while(value <= 1500)
		{
			if(confirmLychrel(value, 0))
			{
				System.out.println("Value of Lychrel: " + value);
				lychrelCount++;
			}
			
			value++;
		}
		
		System.out.println("All Done: # of Lychrel Nums: " + lychrelCount);
	}
	
	public static boolean confirmLychrel(long value, int count)
	{
		boolean result = true;
		long tempValue = value;
		while(count < ITERATION_LIMIT)
		{
			if(palindromeCheck(tempValue))
			{
				result = false;
				break;
			}
			else
			{
				tempValue = getNextIteration(tempValue);
			}
			count++;
		}
		
		return result;
	}
	
	public static long getNextIteration(long value)
	{
		StringBuilder sb;
		if(value < 0)
		sb = new StringBuilder(Long.toString(value).substring(1));
		else
			sb = new StringBuilder(Long.toString(value));
		
		if(value < 0)
		{
			return value + -Long.parseLong(sb.reverse().toString());
		}
		else
			return value + Long.parseLong(sb.reverse().toString());
	}
	
	public static boolean palindromeCheck(long value)
	{
		StringBuilder sb = new StringBuilder();
		
		if(value < 0)
		{
			sb.append(Long.toString(value).substring(1));
		}
		else
		{
			sb.append(Long.toString(value));
		}
		
		String original = sb.toString();
		String reverse = sb.reverse().toString();
		
		boolean test = original.equals(reverse);
		return test;
	}

}

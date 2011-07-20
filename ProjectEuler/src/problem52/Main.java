package problem52;

/**
 * Utilizing Brute force method!
 * @author c1dev
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		int result = 2;
		while(!checkValue(result))
		{
			result++;
		}
		System.out.println("Game over! Result: " + result);
	}
	
	public static boolean checkValue(int x)
	{
		//Confirm that the length of the two numbers are equal
		if(getLength(2*x) != getLength(6*x))
			return false;
		else
		{
			//System.out.println("Check check");
			int[] checkValue = getNumber(2*x);
			if(compareIntArray(checkValue, getNumber(3*x))
					&& compareIntArray(checkValue, getNumber(4*x))
					&& compareIntArray(checkValue, getNumber(5*x)) 
					&& compareIntArray(checkValue, getNumber(6*x)))
			{
				return true;
			}
		}
		
		if(x > 100000000)
			return true;
		
		return false;
	}
	
	public static int getLength(int input)
	{
		return Integer.toString(input).length();
	}
	
	public static int[] getNumber(int input)
	{
		//Contains the number of times each digit is accounted for
		int[] result = new int[10];
		
		for(char number : Integer.toString(input).toCharArray())
		{
			result[Character.getNumericValue(number)]++;
		}
		return result;
	}
	
	public static boolean compareIntArray(int[] arr1, int[] arr2)
	{
		boolean result = true;
		
		for(int count = 0; count < arr1.length; count++)
		{
			if(arr1[count] != arr2[count])
			{
				result = false;
				break;
			}
		}
		
		return result;
	}

}

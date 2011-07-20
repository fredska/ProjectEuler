package problem43;

import java.util.HashSet;
import java.util.Set;

public class Problem43_Main {

	private static Set<String> result;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		result = new HashSet<String>();
		permuteString(result,"", "0123456789");
		System.out.println("Recursive Function Done! Size is: " + result.size());
		
		long finalAnswer = 0;
		for(String str : result)
		{
			finalAnswer += Long.parseLong(str);
		}
		
		System.out.println("Sum of all Numbers found: " + finalAnswer);
	}
	
	  public static void permuteString(Set<String> input, String beginningString, String endingString) {
		    //if (endingString.length() <= 1)
		    //  System.out.println(beginningString + endingString);
		    //else
		      for (int i = 0; i < endingString.length(); i++) {
		        try {
		          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
		          if(checkStr(beginningString + endingString))
		          {
		        	  input.add(beginningString + endingString);
		          }
		          permuteString(input, beginningString + endingString.charAt(i), newString);
		        } catch (StringIndexOutOfBoundsException exception) {
		          exception.printStackTrace();
		        }
		      }
		  }

	  
	  private static boolean checkStr(String input)
	  {
		  char[] splitArr = input.toCharArray();
		  int[] numbers = new int[10];
		  int[] primes = new int[]{2,3,5,7,11,13,17};
//		 return false;
		 
		  for(int count = 0; count < 10; count++)
		  {
			  numbers[count] = Character.getNumericValue(splitArr[count]);
		  }
		  
		  for(int count = 0; count < primes.length; count++)
		  {
			  int checkNum = 
				  (numbers[count+1] * 100) + 
				  (numbers[count+2] * 10) + 
				  (numbers[count+3]);
			  
			  if((checkNum % primes[count]) != 0)
			  {
				return false;  
			  }
		  }
		  
		  return true;
		  
	  }

}

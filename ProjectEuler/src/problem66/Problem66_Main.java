package problem66;

public class Problem66_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int D = 75;
		int y = 2;
		int count = 0;
		long answer = 0; //final answer result
		
		//Test good!
		//System.out.println("Test validate Method: Value = 9 : " + validate(9d));
		//System.out.println("Test validate Method: Value = 14 : " + validate(14d));
		while(D <= 1000)
		{
			if(!validate(D))
			{
				//Loop until the first sqrt result is natural
				for(y = 2; !validate(formula(D,y)); y++){;}
				
				//Compare against the answer value and replace with larger value
				double sqrtAnswer = Math.sqrt(formula(D,y));
				long newAnswer = Long.parseLong(Double.toString(sqrtAnswer).split("\\.")[0]);
				answer = Math.max(answer, newAnswer);
				System.out.println("New answer: " + answer);
				System.out.println("Count number: " + count + " -- D: " + D);
				count++;
			}
			D++;
		}
		
		System.out.println("Final Answer: " + answer);
		System.out.println("Number of loops: " + count);
	
	}
	
	/**
	 * Validates the result of the formula and checks number for sqrt.
	 * IF sqrt is an integer, return true
	 * else, false
	 * @return
	 */
	private static boolean validate(double value)
	{
		boolean result = false;
		double sqrt = Math.sqrt(value);
		String check = Double.toString(sqrt);
		String[] arrCheck = check.split("\\.");
		if(arrCheck[1].length() > 1)
			return false;
		else
			return true;
	}
	
	private static double formula(int D, int y)
	{
		return 1+ (D * Math.pow(y, 2d));
	}

}

package problem51;

public class Problem51Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = null;
		
		if(test != null)
		{
			if(!test.equals(""))
				System.out.println("String is not empty and not null");
			else
				System.out.println("String is empty and not null");
		}
		else
		{
			System.out.println("String is null");
		}
	}

}

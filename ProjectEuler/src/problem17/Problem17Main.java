package problem17;

public class Problem17Main {

	final static String[] abbr_Single = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
	final static String[] tens_SPECIAL = new String[]{"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	final static String[] abbr_Tens = new String[]{"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	final static String HUNDRED = "hundred";
	public static void main(String args[])
	{
		int count = 1;
		StringBuilder sb = new StringBuilder();

		for(; count < 1000; count++)
		{
			sb.append(getWord(count, valueBreakdown(count)));
		}
		sb.append("onethousand");
		System.out.println(sb.toString());
		
		System.out.println("Total Size: "+sb.length());
	}
	public static int[] valueBreakdown(int value)
	{
		int[] result;
		if((value / 100) > 0)
		{
			result = new int[]{value / 100, (value % 100) / 10, (value % 10)};
		}
		else if((value / 10) > 0)
		{
			result = new int[]{value / 10, value % 10};
		}
		else
		{
			result = new int[]{value % 10};
		}
		
		return result;
	}
	
	public static String getWord(int value, int[] breakdown)
	{
		String result = "";

		switch(breakdown.length)
		{
		case 1: //1 - 9
			result = abbr_Single[breakdown[0]];
			break;
		case 2: //10 - 99 
			if(breakdown[0] == 1)
			{
				result = tens_SPECIAL[breakdown[1]];
			}
			else
			{
				if(breakdown[1] == 0)
					result = abbr_Tens[breakdown[0]-2];
				else
				result = abbr_Tens[breakdown[0]-2] + abbr_Single[breakdown[1]];
			}
			break;
		case 3: //100 - 999
			if(breakdown[1] == 0 && breakdown[2] == 0)
			{
				result = abbr_Single[breakdown[0]] + "hundred";
				break;
			}
			result = abbr_Single[breakdown[0]] + "hundredand";
			
			switch(breakdown[1])
			{
			case 0:
				result += abbr_Single[breakdown[2]];
				break;
			case 1:
				result += tens_SPECIAL[breakdown[2]];
				break;
				default:
					if(breakdown[2] == 0)
						result += abbr_Tens[breakdown[1]-2];
					else
						result += abbr_Tens[breakdown[1]-2] + abbr_Single[breakdown[2]];
					break;
			}
		default:
			
			break;
		}
		return result;
	}
}

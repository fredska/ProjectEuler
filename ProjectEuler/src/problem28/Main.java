package problem28;

/**
 * This is a sprial problem.  The idea is to add up all the
 * diagonals together
 * 
 * Here is the problem
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

NOTES:
	This problem is actually a lot easier that it seems.  To do it the brute force way, you would run into a memory overflow, and would just plain take forever :P
		(hehe not really, 1001 x 1001 would fit into roughly 1MB of space, plenty of legroom :P)
		
	However, here's a better solution;
	
	Notice that on the 2nd circle, the top right is 9, and in the 3rd row, it's 25... familiar?  
	1st circle = 1^2 = 1
	2nd circle = 3^2 = 9
	3rd circle = 5^2 = 25
	
	With that in mind, each diagonal edge value will be Sidelength - 1
	e.g.  for the 3rd circle;
	top right = 25
	top left = 25 - (sidelength - 1) = 25 - (5 - 1) = 21
	bot. left =25 - (sidelength - 1)*2 = 25 - (5 - 1)*2 = 17
	bot. right =25 - (sidelength - 1)*3 = 25 - (5 - 1)*3 = 13
	
	Now that we have the 4 numbers, it's just a matter of totaling up all the layers!
 * @author darkpool
 *
 */
public class Main {

	public static final int SPIRAL_LENGTH_LIMIT = 1001;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Final Answer will hold the result we need!
		int finalAnswer = 0;
		//Sidelength will keep track of how long each layer is
		int sideLength = 1;
		
		//Run the loop until the spiral limit is surpassed
		while(sideLength <= SPIRAL_LENGTH_LIMIT)
		{
			//Call the method to retrieve the total sum of each diagonal
			finalAnswer += getDiagonalValues(sideLength);
			//increase by 2 because that's the number of "numbers" added to each side
			sideLength = sideLength + 2;
		}
		
		//Output the final result to the user;
		System.out.println("Final Answer: " + finalAnswer);
	}
	
	/**
	 * Sidelength is for the length of numbers per side
	 * @param sideLength
	 * @return the total of each diagonal
	 */
	public static int getDiagonalValues(int sideLength)
	{
		//If the length is 1, this defines the center of the circle, and only return 1
		if(sideLength == 1)
		{
			return 1;
		}
		int result = 0;
		//The top right corner will always be the sidelength squared!
		int startNumber = sideLength * sideLength;
		
		//Since we've already calculated the first diagonal, start the result with that number;
		result = startNumber;
		//Now, find the last 3 diagonals
		for(int count = 1; count < 4; count++)
		{
			result += startNumber - ((sideLength-1) * count);
		}
		
		//Return the final result
		return result;
	}

}

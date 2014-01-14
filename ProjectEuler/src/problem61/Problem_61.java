package problem61;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers
 * are all figurate (polygonal) numbers and are generated by the following
 * formulae: 
 * 
Triangle 	  	P3,n=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
Square 	  		P4,n=n2 	  		1, 4, 9, 16, 25, ...
Pentagonal 	  	P5,n=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
Hexagonal 	  	P6,n=n(2n−1) 	  	1, 6, 15, 28, 45, ...
Heptagonal 	  	P7,n=n(5n−3)/2 	  	1, 7, 18, 34, 55, ...
Octagonal 	  	P8,n=n(3n−2) 	  	1, 8, 21, 40, 65, ...
 * 
 * The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three
 * interesting properties.
 * 
 * The set is cyclic, in that the last two digits of each number is the first
 * two digits of the next number (including the last number with the first).
 * Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and
 * pentagonal (P5,44=2882), is represented by a different number in the set.
 * This is the only set of 4-digit numbers with this property.
 * 
 * Find the sum of the only ordered set of six cyclic 4-digit numbers for which
 * each polygonal type: triangle, square, pentagonal, hexagonal, heptagonal, and
 * octagonal, is represented by a different number in the set.
 * 
 * @author fskallos
 * 
 */
public class Problem_61 {

	private List<Long> triangles, squares, pentagonals, hexagonals,
			heptagonals, octagonals;

	public static void main(String[] args) {
		new Problem_61().run();
	}

	public void run(){
		triangles = new LinkedList<Long>();
		squares = new LinkedList<Long>();
		pentagonals = new LinkedList<Long>();
		hexagonals = new LinkedList<Long>();
		heptagonals = new LinkedList<Long>();
		octagonals = new LinkedList<Long>();
		
		//Move all the values into their own List
		for(int a = 0; a < 6; a++){		
			int i = 1;
			long value = 0;
			switch(a){
			case 0:
				while ((value = triangle(i)) < 10000) {
					if (value >= 1000)
						triangles.add(value);
					i++;
				}
				break;
			case 1:
				while ((value = square(i)) < 10000) {
					if (value >= 1000)
						squares.add(value);
					i++;
				}
				break;
			case 2:
				while ((value = pentagonal(i)) < 10000) {
					if (value >= 1000)
						pentagonals.add(value);
					i++;
				}
				break;
			case 3:
				while ((value = hexagonal(i)) < 10000) {
					if (value >= 1000)
						hexagonals.add(value);
					i++;
				}
				break;
			case 4:
				while ((value = heptagonal(i)) < 10000) {
					if (value >= 1000)
						heptagonals.add(value);
					i++;
				}
				break;
			default:
				while ((value = octagonal(i)) < 10000) {
					if (value >= 1000)
						octagonals.add(value);
					i++;
				}
				break;
			}
		}
		
		//Now begin the iterating through everything, trickle down fashion
		List<Long> firstRoundCombo = compareGroups(triangles, squares);
		List<Long> secondRoundCombo = compareGroups(firstRoundCombo, pentagonals);
		List<Long> thirdRound = compareGroups(secondRoundCombo, hexagonals);
		List<Long> fourthRound = compareGroups(thirdRound, heptagonals);
		List<Long> fifthRound = compareGroups(fourthRound, octagonals);
		
		if(fifthRound.size() != 1){
			System.out.println("Something went wrong!!!  Size is incorrect ( != 1");
			System.exit(1);
		}
		
		//With the correct result, reverse the process!
		fourthRound = reverseCompareGroups(fifthRound, fourthRound);
		thirdRound = reverseCompareGroups(fourthRound, thirdRound);
		secondRoundCombo = reverseCompareGroups(thirdRound, secondRoundCombo);
		firstRoundCombo = reverseCompareGroups(secondRoundCombo, firstRoundCombo);
		triangles = reverseCompareGroups(firstRoundCombo, triangles);
		System.out.println("Done!  The sum is: "
				+ (triangles.get(0) + firstRoundCombo.get(0)
						+ secondRoundCombo.get(0) + thirdRound.get(0)
						+ fourthRound.get(0) + fifthRound.get(0)));
	}
	
	private List<Long> compareGroups(List<Long> groupA, List<Long> groupB){
		List<Long> roundCombo = new LinkedList<Long>();
		for(int a = 0; a < groupA.size(); a++){
			for(int b = 0; b < groupB.size(); b++){
				if(compareValue(groupA.get(a), groupB.get(b))){
					if(!roundCombo.contains(groupB.get(b)))
						roundCombo.add(groupB.get(b));
				}
			}
		}
		return roundCombo;
	}
	
	private List<Long> reverseCompareGroups(List<Long> groupA, List<Long> groupB){
		List<Long> roundCombo = new LinkedList<Long>();
		for(int a = 0; a < groupA.size(); a++){
			for(int b = 0; b < groupB.size(); b++){
				if(reverseCompareValue(groupA.get(a), groupB.get(b))){
					roundCombo.add(groupB.get(b));
				}
			}
		}
		return roundCombo;
	}
	
	private boolean compareValue(long a, long b){
		return (a % 100) == (b / 100);
	}
	
	private boolean reverseCompareValue(long a, long b){
		return (a / 100) == (b % 100);
	}

	private long triangle(long input) {
		return (input * (input + 1)) / 2;
	}

	private long square(long input) {
		return input * input;
	}

	private long pentagonal(long input) {
		return (input * (3 * input - 1)) / 2;
	}

	private long hexagonal(long input) {
		return input * (2 * input - 1);
	}

	private long heptagonal(long input) {
		return (input * (5 * input - 1)) / 2;
	}

	private long octagonal(long input) {
		return input * (3 * input - 2);
	}
}

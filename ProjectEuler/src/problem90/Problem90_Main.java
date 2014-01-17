package problem90;

import java.io.InputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Problem90_Main {
	// Generated on
	// http://www.mathsisfun.com/combinatorics/combinations-permutations-calculator.html
	private String distinctCombinations = 
			  "abcdef abcdeg abcdeh abcdei abcdej abcdfg abcdfh abcdfi "
			+ "abcdfj abcdgh abcdgi abcdgj abcdhi abcdhj abcdij abcefg "
			+ "abcefh abcefi abcefj abcegh abcegi abcegj abcehi abcehj "
			+ "abceij abcfgh abcfgi abcfgj abcfhi abcfhj abcfij abcghi "
			+ "abcghj abcgij abchij abdefg abdefh abdefi abdefj abdegh "
			+ "abdegi abdegj abdehi abdehj abdeij abdfgh abdfgi abdfgj "
			+ "abdfhi abdfhj abdfij abdghi abdghj abdgij abdhij abefgh "
			+ "abefgi abefgj abefhi abefhj abefij abeghi abeghj abegij "
			+ "abehij abfghi abfghj abfgij abfhij abghij acdefg acdefh "
			+ "acdefi acdefj acdegh acdegi acdegj acdehi acdehj acdeij "
			+ "acdfgh acdfgi acdfgj acdfhi acdfhj acdfij acdghi acdghj "
			+ "acdgij acdhij acefgh acefgi acefgj acefhi acefhj acefij "
			+ "aceghi aceghj acegij acehij acfghi acfghj acfgij acfhij "
			+ "acghij adefgh adefgi adefgj adefhi adefhj adefij adeghi "
			+ "adeghj adegij adehij adfghi adfghj adfgij adfhij adghij "
			+ "aefghi aefghj aefgij aefhij aeghij afghij bcdefg bcdefh "
			+ "bcdefi bcdefj bcdegh bcdegi bcdegj bcdehi bcdehj bcdeij "
			+ "bcdfgh bcdfgi bcdfgj bcdfhi bcdfhj bcdfij bcdghi bcdghj "
			+ "bcdgij bcdhij bcefgh bcefgi bcefgj bcefhi bcefhj bcefij "
			+ "bceghi bceghj bcegij bcehij bcfghi bcfghj bcfgij bcfhij "
			+ "bcghij bdefgh bdefgi bdefgj bdefhi bdefhj bdefij bdeghi "
			+ "bdeghj bdegij bdehij bdfghi bdfghj bdfgij bdfhij bdghij "
			+ "befghi befghj befgij befhij beghij bfghij cdefgh cdefgi "
			+ "cdefgj cdefhi cdefhj cdefij cdeghi cdeghj cdegij cdehij "
			+ "cdfghi cdfghj cdfgij cdfhij cdghij cefghi cefghj cefgij "
			+ "cefhij ceghij cfghij defghi defghj defgij defhij deghij "
			+ "dfghij efghij";

	public static void main(String[] args) {
		Problem90_Main problem = new Problem90_Main();
		problem.run();
	}

	public void run() {
		int numberOfDistinctCombos = 0;
		List<SixSidedDie> distinctDice = new LinkedList<SixSidedDie>();
		for (String input : distinctCombinations.split(" ")) {
			distinctDice.add(new SixSidedDie(input));
		}
		List<TwoSixSidedDie> distinctDiceSets = new LinkedList<TwoSixSidedDie>();
		for (int a = 0; a < distinctDice.size(); a++) {
			for (int b = 0; b < distinctDice.size(); b++) {
				if (distinctDice.get(a).isDistinct(distinctDice.get(b))) {
					distinctDiceSets.add(new TwoSixSidedDie(
							distinctDice.get(a), distinctDice.get(b)));
				}
			}
		}
		distinctDice = new LinkedList<Problem90_Main.SixSidedDie>();
		for (TwoSixSidedDie diceSet : distinctDiceSets) {
			
			if (diceSet.coversSquaredValues()){
//				System.out.println(diceSet.toString());
				distinctDice.add(diceSet.die1);
				distinctDice.add(diceSet.die2);
				numberOfDistinctCombos++;
			}
		}
		
//		List<SixSidedDie> finalList = new LinkedList<Problem90_Main.SixSidedDie>();
//		for(SixSidedDie die : distinctDice){
//			if(isDistinctInList(finalList, die)) finalList.add(die);
//		}
		
		System.out.println("All Done!  Answer is: " + numberOfDistinctCombos);
	}
	
	private boolean isDistinctInList(List<SixSidedDie> dice, SixSidedDie die){
		if(dice.isEmpty()) return true;
		
		for(int i = 0; i < dice.size(); i++){
			if(dice.get(i).isDistinct(die))
				return true;
		}
		return false;
	}

	private class TwoSixSidedDie {
		private SixSidedDie die1, die2;

		public TwoSixSidedDie(SixSidedDie die1, SixSidedDie die2) {
			this.die1 = die1;
			this.die2 = die2;
		}

		/**
		 * This method returns true or false based on if the two dice combined
		 * will produce all the squared values (01, 04, 09, 16, 25, 36, 49, 64,
		 * 81)
		 * 
		 * @return
		 */
		public boolean coversSquaredValues() {
			if (!checkCombo(0, 1))
				return false;
			if (!checkCombo(0, 4))
				return false;
			if (!checkCombo(0, 9))
				return false;
			if (!checkCombo(1, 6))
				return false;
			if (!checkCombo(2, 5))
				return false;
			if (!checkCombo(3, 6))
				return false;
			if (!checkCombo(4, 9))
				return false;
			if (!checkCombo(6, 4))
				return false;
			if (!checkCombo(8, 1))
				return false;
			return true;
		}

		/**
		 * For instance, inputs would be 0 and 1, checking to make sure the dice
		 * can fufill the requirement of 01
		 * 
		 * @param sideA
		 * @param sideB
		 * @return
		 */
		private boolean checkCombo(int sideA, int sideB) {
			return (this.die1.hasSideValue(sideA) && this.die2
					.hasSideValue(sideB))
					|| (this.die1.hasSideValue(sideB) && this.die2
							.hasSideValue(sideA));
		}
		public String toString(){
			return "(" + this.die1.toString() + "),(" + this.die2.toString() + ")";
		}
	}

	private class SixSidedDie {
		private int a, b, c, d, e, f;

		public SixSidedDie(int a, int b, int c, int d, int e, int f) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
		}

		public SixSidedDie(String input) {
			// Requires a string of 6 characters
			if (input.length() != 6)
				return;
			this.a = ((char) input.charAt(0)) - 97;
			this.b = ((char) input.charAt(1)) - 97;
			this.c = ((char) input.charAt(2)) - 97;
			this.d = ((char) input.charAt(3)) - 97;
			this.e = ((char) input.charAt(4)) - 97;
			this.f = ((char) input.charAt(5)) - 97;
		}

		public boolean hasSideValue(int inputValue) {
			int value = inputValue;
			if (value == 6 || value == 9) {
				return (this.a == 6 || this.a == 9)
						|| (this.b == 6 || this.b == 9)
						|| (this.c == 6 || this.c == 9)
						|| (this.d == 6 || this.d == 9)
						|| (this.e == 6 || this.e == 9)
						|| (this.f == 6 || this.f == 9);
			} else {
				return this.a == value || this.b == value || this.c == value
						|| this.d == value || this.e == value
						|| this.f == value;
			}
		}

		public boolean isDistinct(SixSidedDie compare) {
			if (!compareFaceValue(this.a, compare))
				return true;
			if (!compareFaceValue(this.b, compare))
				return true;
			if (!compareFaceValue(this.c, compare))
				return true;
			if (!compareFaceValue(this.d, compare))
				return true;
			if (!compareFaceValue(this.e, compare))
				return true;
			if (!compareFaceValue(this.f, compare))
				return true;
			return false;
		}

		private boolean compareFaceValue(int value, SixSidedDie compare) {
			return value == compare.getA() || value == compare.getB()
					|| value == compare.getC() || value == compare.getD()
					|| value == compare.getE() || value == compare.getF();
		}

		public int getA() {
			return this.a;
		}

		public int getB() {
			return this.b;
		}

		public int getC() {
			return this.c;
		}

		public int getD() {
			return this.d;
		}

		public int getE() {
			return this.e;
		}

		public int getF() {
			return this.f;
		}

		public String toString() {
			return "" + this.a + "," + this.b + "," + this.c + "," + this.d
					+ "," + this.e + "," + this.f;
		}
	}
}

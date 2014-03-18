package problem75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * It turns out that 12 cm is the smallest length of wire that can be bent to
 * form an integer sided right angle triangle in exactly one way, but there are
 * many more examples.
 * 
 * 12 cm: (3,4,5) 
 * 24 cm: (6,8,10) 
 * 30 cm: (5,12,13) 
 * 36 cm: (9,12,15) 
 * 40 cm: (8,15,17) 
 * 48 cm: (12,16,20)
 * 
 * In contrast, some lengths of wire, like 20 cm, cannot be bent to form an
 * integer sided right angle triangle, and other lengths allow more than one
 * solution to be found; for example, using 120 cm it is possible to form
 * exactly three different integer sided right angle triangles.
 * 
 * 120 cm: (30,40,50), (20,48,52), (24,45,51)
 * 
 * Given that L is the length of the wire, for how many values of L ≤ 1,500,000
 * can exactly one integer sided right angle triangle be formed?
 * 
 * @author fskallos
 * 
 */
public class Problem75_Main {

	/**
	 * Notes:
	 * 
	 * L is a maximum of 1,500,000
	 * The length of a triangle is a + b + c
	 * A right triangle abides by the equation c^2 = a^2 + b^2
	 * a cannot be larger than b (otherwise there are duplicates)
	 * Therefore, we can presume that a(max) = b(max) - 1
	 * Algebra gives the following:
	 * 
	 *  L = a + b + c
	 *  L = a + b + sqrt(a^2 + b^2)
	 *  (inputing a = b-1)
	 *  L = (b - 1) + b + sqrt((b - 1)^2 + b^2)
	 *  L = 2*b - 1 + sqrt(2*b^2 -2*b + 1)
	 * @param args
	 */
	public static void main(String[] args) {
		Problem75_Main problem = new Problem75_Main();
		problem.run();
	}

	private final int MAX_WIRE_LENGTH = 1500000;
	public void run(){
		
		int bMax = getLargestSide(MAX_WIRE_LENGTH);
		//c^2 = a^2 + b^2;
		int result = 0;
		//Key: Length of wire
		//Value: Number of triangles the length of wire can make
		List<RightSidedTriangle> allRightTriangles = new ArrayList<RightSidedTriangle>();
		//sqrt(1500000) =~ 1225
		Set<Long> hypotenuseValues = new HashSet<Long>();
		for(long i = 1; i < bMax*2; i++){
			hypotenuseValues.add(i * i);
		}
		int c;
		for(int b = 1; b < bMax; b++){
			for(int a = 1; a <= b; a++){
				long cSquare = (a * a) + (b * b);
				if(hypotenuseValues.contains(cSquare)){
					allRightTriangles.add(new RightSidedTriangle(a, b, (int)Math.sqrt(cSquare)));
				}
			}
			if((b % 100) == 0)
				System.out.println("Check: " + b);
		}
		Set<Integer> results = new HashSet<Integer>();
		Set<Integer> duplicates = new HashSet<Integer>();
		for(RightSidedTriangle triangle : allRightTriangles){
			int length = triangle.getLength();
			if(results.contains(length))
				duplicates.add(length);
			else
				results.add(length);
		}
		results.removeAll(duplicates);
		System.out.println("Final Answer: " + results.size());
	}
	
	public int getLargestSide(int maxLength){
		return (int)(maxLength / (2.0 * (1 + 1 / Math.sqrt(2)))) + 1;
	}
}

class RightSidedTriangle{
	public int a, b, c;
	public RightSidedTriangle(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int getLength(){ return this.a + this.b + this.c;}
}

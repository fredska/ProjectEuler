package problem65;

import java.math.BigInteger;

/**
 * 
 * Consider quadratic Diophantine equations of the form:
 * 
 * x^2 – D*y^2 = 1
 * 
 * For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.
 * 
 * It can be assumed that there are no solutions in positive integers when D is
 * square.
 * 
 * By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the
 * following:
 * 
 * 3^2 – 2×2^2 = 1 2^2 – 3×1^2 = 1 9^2 – 5×4^2 = 1 5^2 – 6×2^2 = 1 8^2 – 7×3^2 =
 * 1
 * 
 * Hence, by considering minimal solutions in x for D ≤ 7, the largest x is
 * obtained when D=5.
 * 
 * Find the value of D ≤ 1000 in minimal solutions of x for which the largest
 * value of x is obtained.
 * 
 * @author fskallos
 * 
 */
public class Problem65_Main implements Runnable {

	public static void main(String[] args) {
		Problem65_Main problem = new Problem65_Main(1,1000);
		problem.run();
//		try {
//			problem.initializeAndRun();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	private BigInteger startPosition, endPosition;
	public void initializeAndRun() throws InterruptedException{
		Thread[] problemThreads = new Thread[4];
		problemThreads[0] = new Thread(new Problem65_Main(0, 250));
		problemThreads[1] = new Thread(new Problem65_Main(251, 500));
		problemThreads[2] = new Thread(new Problem65_Main(501, 750));
		problemThreads[3] = new Thread(new Problem65_Main(751, 1001));
		
		problemThreads[0].join();
		problemThreads[1].join();
		problemThreads[2].join();
		problemThreads[3].join();
		
		problemThreads[0].start();
		problemThreads[1].start();
		problemThreads[2].start();
		problemThreads[3].start();
	}
	public Problem65_Main(){ this.startPosition = BigInteger.ZERO; this.endPosition = BigInteger.ZERO;}
	public Problem65_Main(int start, int end){
		startPosition = new BigInteger(Integer.toString(start));
		endPosition = new BigInteger(Integer.toString(end));
	}

	@Override
	public void run() {
		long largestX = 1;
		BigInteger x = BigInteger.ONE, y = BigInteger.ONE;
		for (BigInteger D = startPosition; D.compareTo(endPosition) == -1; D = D.add(BigInteger.ONE)) {
			int integerD = D.intValue();
			if ((int) Math.sqrt(integerD) == Math.sqrt(integerD))
				continue;
			x = BigInteger.ONE;
			y = BigInteger.ONE;
			BigInteger tmpValue;
			while ((tmpValue = (x.multiply(x).subtract((y.multiply(y)
					.multiply(D))))).compareTo(BigInteger.ONE) != 0) {
				if (tmpValue.compareTo(BigInteger.ONE) == 1)
					y = y.add(BigInteger.ONE);
				else
					x = x.add(BigInteger.ONE);
			}
			System.out.println(x.toString() + " :: " + y.toString()
					+ " :: D = " + D.toString());
			updateResult(D, x);
		}
	}

	BigInteger D = BigInteger.ZERO;
	BigInteger finalX = BigInteger.ONE;

	public synchronized void updateResult(BigInteger D, BigInteger x) {
		if(this.finalX.compareTo(x) == -1){
			this.D = D;
			this.finalX = x;
		}
	}

}

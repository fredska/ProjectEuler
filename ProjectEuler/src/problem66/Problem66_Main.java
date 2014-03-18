package problem66;

import java.math.BigInteger;

public class Problem66_Main implements Runnable{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Problem66_Main problem = new Problem66_Main(1,1000);
		problem.run();
	}
	
	private BigInteger startPosition, endPosition;
	public void initializeAndRun() throws InterruptedException{
		Thread[] problemThreads = new Thread[4];
		problemThreads[0] = new Thread(new Problem66_Main(0, 250));
		problemThreads[1] = new Thread(new Problem66_Main(251, 500));
		problemThreads[2] = new Thread(new Problem66_Main(501, 750));
		problemThreads[3] = new Thread(new Problem66_Main(751, 1001));
		
		problemThreads[0].join();
		problemThreads[1].join();
		problemThreads[2].join();
		problemThreads[3].join();
		
		problemThreads[0].start();
		problemThreads[1].start();
		problemThreads[2].start();
		problemThreads[3].start();
	}
	public Problem66_Main(){ this.startPosition = BigInteger.ZERO; this.endPosition = BigInteger.ZERO;}
	public Problem66_Main(int start, int end){
		startPosition = new BigInteger(Integer.toString(start));
		endPosition = new BigInteger(Integer.toString(end));
	}

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

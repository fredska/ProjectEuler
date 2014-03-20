package problem70;

public class TotientPermutation {

	public static void main(String[] args) {
		TotientPermutation problem = new TotientPermutation();
		problem.run();
	}

	public void run(){
		int bestN = 999999999;
		double record = 55;
		int count = 0;
		for(int i = 9999999; i >= 2; i--){
			int phi = findPhiFunction(i);
			if(isPermutation(phi, i)){
				if(record > ((double)i / (double)phi)){
					bestN = i;
					record = ((double)i / (double)phi);
					System.out.println("New Record: " + i + " :: " + record + " :: " + phi);
				}
			}
//				System.out.println(i);
		}
	}
	
	public int findPhiFunction(int n){
		if(n <= 1) return -1;
		//Any remaining false values in this array
		// are considered non-relative primes
		boolean[] relativePrimes = new boolean[n];
		relativePrimes[0] = false;
		for(int i = 1; i < relativePrimes.length; i++){
			if(!relativePrimes[i]){
				if((n % (i + 1)) == 0){
					int a = i;
					for(int b = 0; b * (i + 1) < relativePrimes.length; b++){
						relativePrimes[i + (b * (i+1))] = true;
					}
				}
			}
		}
		int finalCount = 0;
		for(int i = 0; i < relativePrimes.length; i++){
			if(!relativePrimes[i]) finalCount++;
		}
		return finalCount;
	}
	
	public boolean isPermutation(int a, int b){
		if(a < 10 || b < 10) return a == b;
		int modifier = 10;
		int[] aDigits = new int[10];
		int[] bDigits = new int[10];
		
		while((a / modifier) != 0){
			aDigits[(a / modifier) % 10]++;
			modifier *= 10;
		}
		modifier = 10;
		while((b / modifier) != 0){
			bDigits[(b / modifier) % 10]++;
			modifier *= 10;
		}
		
		for(int i = 0; i < 10; i++){
			if(aDigits[i] != bDigits[i]) return false;
		}
		return true;
	}
}

package problem58;

import utils.common.Sieve_of_Eratosthenes;

public class Problem58_Main {

	public static void main(String[] args){
		Problem58_Main problem = new Problem58_Main();
		problem.run();
	}
	
	private final static int PRIMES_LIMIT = 700000000;
	private final static int NUMBER_OF_LAYERS = 100000;
	public void run(){
		//First, get a ton of prime values;
		boolean[] primes = Sieve_of_Eratosthenes.getPrimesToLimit(PRIMES_LIMIT);
		
		//Designate 4 diagonals
		//Up and Right (UR)
		//Up and Left (UL)
		//Down and Left (DL)
		//Down and Right (DR)
		int[] UR = new int[NUMBER_OF_LAYERS];
		int[] UL = new int[NUMBER_OF_LAYERS];
		int[] DL = new int[NUMBER_OF_LAYERS];
		
		UR[0] = 1; UL[0] = 1; DL[0] = 1;
		int ur_modifier = 2;
		int ul_modifier = 4;
		int dl_modifier = 6;
		
		for(int layer = 1; layer < NUMBER_OF_LAYERS; layer++){
			UR[layer] = UR[layer-1] + ur_modifier;
			ur_modifier += 8;
			
			UL[layer] = UL[layer-1] + ul_modifier;
			ul_modifier += 8;
			
			DL[layer] = DL[layer-1] + dl_modifier;
			dl_modifier += 8;
			
			if(getPrimeDifferent(layer, primes, UR, UL, DL)){
				System.out.println("Side Length: " + (1 + layer * 2));
				break;
			}
		}
	}
	
	private boolean getPrimeDifferent(int numOfLayers, boolean[] primes,
			int[] UR, int[] UL, int[] DL){
		
		int primeCount = 0;
		for(int layerCount = 1; layerCount <= numOfLayers; layerCount++){
			if(primes[UR[layerCount]]) primeCount++;
			if(primes[UL[layerCount]]) primeCount++;
			if(primes[DL[layerCount]]) primeCount++;
		}
		double percentDifference = ((double)primeCount / (double)(1 + numOfLayers * 4));
		return percentDifference <= 0.1d;
	}
}

package utils.common;

import java.util.Arrays;

public class PermutedNumber{
	private int[] permutedValues;
	private long value;
	public PermutedNumber(long input){
		this.value = input;
		permutedValues = new int[10];
		long modifier = 1;
		//Get each digit mathematically;
		//array will always be a number between 0 and 9;
		while((input / modifier) != 0){
			permutedValues[(int)((input % (modifier * 10)) / modifier)]++;
			modifier *= 10;
		}
	}
	
	public long getValue(){ return this.value;}
	
	public boolean isMatch(PermutedNumber other){
		if(other.permutedValues.length != this.permutedValues.length) return false;
		if(other.permutedValues.length != 10) return false;
		
		for(int i = 0; i < 10; i++){
			if(other.permutedValues[i] != this.permutedValues[i])
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(permutedValues);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PermutedNumber){
			return isMatch((PermutedNumber)obj);
		} else
			return false;
	}
}

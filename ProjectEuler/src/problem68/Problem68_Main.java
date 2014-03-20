package problem68;

/**
 * Turns out that the last result printed is the highest in the group
 * @author fskallos
 *
 */
public class Problem68_Main {

	public static void main(String[] args) {
		Problem68_Main problem = new Problem68_Main();
		problem.run();
	}
	private int n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
	public void run() {
		
		n1 = 10;
		n2 = n3 = n4 = n5 = n6 = n7 = n8 = n9 = n10 = 1;
		int count=0;
		for(n2=2; n2 < 10; n2++){
			for(n3=1; n3 < 10; n3++){
				for(n4=1; n4 < 10; n4++){
					for(n5=1; n5 < 10; n5++){
						for(n6=1; n6 < 8; n6++){
							for(n7=1; n7 < 8; n7++){
								for(n8=2; n8 < 10; n8++){
									for(n9=1; n9 < 10; n9++){
										for(n10=1; n10 < 10; n10++){
											if(isValidSet())
											count++;
										}	
									}	
								}	
							}
						}	
					}	
				}	
			}
		}
		System.out.println("Fininshed: " + count);
	}
	
	public boolean isValidSet(){
		int[] results = new int[10];
		results[n1-1]++;
		if(results[n2-1] != 0) return false;
		results[n2-1] = 1;
		if(results[n3-1] != 0) return false;
		results[n3-1] = 1;
		if(results[n4-1] != 0) return false;
		results[n4-1] = 1;
		if(results[n5-1] != 0) return false;
		results[n5-1] = 1;
		if(results[n6-1] != 0) return false;
		results[n6-1] = 1;
		if(results[n7-1] != 0) return false;
		results[n7-1] = 1;
		if(results[n8-1] != 0) return false;
		results[n8-1] = 1;
		if(results[n9-1] != 0) return false;
		results[n9-1] = 1;
		if(results[n10-1] != 0) return false;
		results[n10-1] = 1;
		
		//Each number is unique;now time for math!
		if(n1 != (n2 + n8 - n6)) return false;
		if(n1 != (n3 + n8 + n9 - n6 - n7)) return false;
		if(n1 != (n4 + n9 + n10 - n6 - n7)) return false;
		if(n1 != (n5 + n10 - n7)) return false;
		System.out.print(n1 + "," + n6 + "," + n7 +" ; ");
		System.out.print(n2 + "," + n7 + "," + n8 +" ; ");
		System.out.print(n3 + "," + n8 + "," + n9 +" ; ");
		System.out.print(n4 + "," + n9 + "," + n10 +" ; ");
		System.out.println(n5 + "," + n10 + "," + n6 +" ; ");
		return true;
	}
}

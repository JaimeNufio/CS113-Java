public class Primes{												//tab width 4											

	public static int primeCNT = 0; 								//I needed a way to communicate
																	//a cnt between methods
	
	public static void main(String[] schwifty){
		
		int[] list = new int[100000];
		for(int i = 0;i<list.length;i++){
			list[i] = i+1;											 //initialize as 1 to X, not 0 to  X-1
		}
		//sieve(list);
		goldbach(list);	
	}

	public static void sieve(int[] list){
	
		String primeLS = "Primes from 1 to "+list.length+":";		

		int start = 0, scanNum, lastScanNum;		
		
		primeCNT = 1; 												//reset global variable 
		list[0] = 0;										 		//1 is not a prime number
																	//and if it were, counting it would set everything to 0
		scanNum = findNextNonZero(list);	
		lastScanNum = -1;
		
		while(scanNum != -1){										//the findNextZero method throws -1 when no new primes are found
			
			for (int j = (scanNum*2)-1; j<list.length;j+=scanNum){	//start zeroing from the second multiple of the num for this loop 
				
					if( list[j] != 0){								//the -1 is b/c of how we shifted the loop in init
							
						//System.out.println(list[j]+" is not prime");	
						list[j] = 0;
					}
	
			}
			lastScanNum = scanNum;
			scanNum = findNextNonZero(list);
		}
		
		for (int num: list){ 										//collect the numbers as a string to be printed
				if (num != 0)
					primeLS+=" "+num;
		}

		System.out.println(primeLS);
	}

	public static void goldbach(int[] list){						//Sigh. b/c Sieve cannot return a value (as per instruction)
																	//I have to copy the method from above, or create another that they can share...	
		
		String toPrint = "";	
		int[]  primeList = list;
		int start = 0, scanNum, lastScanNum;		
		boolean pass = false;		
	
		primeCNT = 0; 												//reset global variable 
		list[0] = 0;										 		//1 is not a prime number
																	//and if it were, counting it would set everything to 0
		scanNum = findNextNonZero(list);	
		lastScanNum = -1;
		
		while(scanNum != -1){										//the findNextZero method throws -1 when no new primes are found
	
			for (int j = (scanNum*2)-1; j<list.length;j+=scanNum){	//start zeroing from the second multiple of the num for this loop 
				
					if( list[j] != 0){								//the -1 is b/c of how we shifted the loop in init
						primeCNT++;
						list[j] = 0;
					}
	
			}
			lastScanNum = scanNum;
			scanNum = findNextNonZero(list);
		}	

		primeList = new int[primeCNT];
		primeCNT = 0; 												//whenever I intend to loop findNextNonZero I need to first 0 primeCNT

		for (int i = 0; i<primeList.length; i++){
			primeList[i] = findNextNonZero(list);
		}
																	//ok, over here we should have a MUCH smaller list to step through

		for (int i = 4; i < list.length; i+=2){
			pass = false;
			for(int firstPrime:primeList){
				if (isPrime(i - firstPrime,primeList) && !pass) {
					System.out.println(firstPrime+" + "+(i - firstPrime)+" = "+i);
					break;
				}
			}	 							

		}

				System.out.println("Done");
	}
	
	public static int findNextNonZero(int[] list){
		int cnt = 0; 												//#of non-zeros we have seen each loop
		for (int i = 0; i<list.length; i++){						//step through list
			if (list[i] !=0){ 										
				cnt++;												//1 more non-zero spotted	
				if (cnt > primeCNT){								//exceeds expected amount of non-zero's seen
					primeCNT++;
					return list[i];									//increase the non-zero count (Primes)
				}
			}
		}
		return -1;													//no new primes found
	}

	public static boolean isPrime(int myNum,int[] primes){
		for (int num: primes){
			if (num == myNum)
				return true;
		}
		return false;
	}

}

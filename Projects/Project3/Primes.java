public class Primes{		

	/*
		Jaime Nufio, CS113 Section 2
		31393971
	*/

	//tab width 4										
	
	/*
		COMMAND LINE EXCECUTION:
		java Primes [Size of array]

		The array is set to the numbers [1,[Size of array]]
		[Size of array] defaults to 100.

		NOTE: Pretty slow for large values ~1,000,000, but it works.

	*/

	public static int primeCNT = 0;									//I needed a way to communicate a count between methods
	public static int[] masterPrimeList = new int[0];				//going to try to store primes so I don't have to re-get them.


	public static void main(String[] schwifty){				
		
		if (schwifty.length < 1){
			schwifty = new String[1];
			schwifty[0] = "100";									//It works quickly  for small numbers :^
		}

		int[] list = new int[Integer.parseInt(schwifty[0])];
	
		for(int i = 0;i<list.length;i++){
			list[i] = i+1;											 //initialize as 1 to X, not 0 to  X-1
		}
	
		sieve(list);
		goldbach(list);	
	}

	public static void sieve(int[] list){
	
		String primeLS = "Primes got from 1 to "+list.length+":";		
		int primes = list.length, scanNum, lastScanNum;		
		

		primeCNT = 1; 												//reset global variable just incase 
		list[0] = 0;										 		//1 is not a prime number
																	//and if it were, counting it would set everything to 0
		scanNum = findNextNonZero(list);	
		lastScanNum = -1;
	
		warning(list);		
 
		while(scanNum != -1){										//"Is there another prime in the sieve"
			for (int j = (scanNum*2)-1; j<list.length;j+=scanNum){	//start zeroing from the second multiple of the num for this loop 
					if( list[j] != 0){	
						primes--;									//lets keep a tally of primes found
						list[j] = 0;								//ZERO THE IMPURE NONPRIME!
					}
			}
			lastScanNum = scanNum;
			scanNum = findNextNonZero(list);						//scan method controls loop
		}
		
		primeCNT = 0;												//repurpose the variable b/c why not, its just a count
		masterPrimeList = new int[primes];	
		
		for (int num: list){ 										//collect the numbers as a string to be printed
				if (num != 0){
					primeLS+=" "+num;
					masterPrimeList[primeCNT] = num;
					primeCNT++;
				}
		}

		System.out.println(primeLS+"\nFound "+primeCNT+" primes.");//output.
	}

	public static void goldbach(int[] list){						//Sigh. b/c Sieve cannot return a value (as per instruction)
																	//I essentially rewrote the sieve in the following lines
		
		String toPrint = "";	
		int[]  primeList = list;
		int primes = list.length, scanNum, lastScanNum;		
	
		primeCNT = 1; 												
		list[0] = 0;										 		
																	
		scanNum = findNextNonZero(list);	
		lastScanNum = -1;

	
		if (masterPrimeList.length == 0 ){							//essentially, "have we run the sieve first"?	

			warning(list);	
		
			while(scanNum != -1){			
				for (int j = (scanNum*2)-1; j<list.length;j+=scanNum){	
						if( list[j] != 0){		
							list[j] = 0;
							primes--;
						}
	
				}
				lastScanNum = scanNum;
				scanNum = findNextNonZero(list);
			}
		
			primeList = new int[primes];
		
			primeCNT = 0; 											

			for (int i = 0; i<primeList.length; i++){
				primeList[i] = findNextNonZero(list);
			}

		}else{
			primeList = masterPrimeList;							//WOOHOO saved time!
		}
	
		System.out.println("Got Primes. Applying Goldbach conjecture.");

		//ok, over here we should have a MUCH smaller list to step through
		//but we are going through a sub loop, so this won't be a small opperation
		//that being said, the bulk of the work has been done at this point

		for (int i = 4; i < list.length; i+=2){
			for(int firstPrime:primeList){
				if (isPrime(i - firstPrime,primeList)){
					System.out.println(firstPrime+" + "+(i - firstPrime)+" = "+i);
					break;
				}
			}	 							

		}

		System.out.println("Done.");
		
	}
	
	public static int findNextNonZero(int[] list){
		int cnt = 0;											//#of non-zeros we have seen each loop
		for (int i = 0; i<list.length; i++){					//step through list
			if (list[i] !=0){ 										
				cnt++;											//1 more non-zero spotted	
				if (cnt > primeCNT){							//exceeds expected amount of non-zero's seen
					primeCNT++;
					return list[i];								//increase the non-zero count (Primes)
				}
			}
		}
		return -1;												//no new primes found
	}

	public static boolean isPrime(int myNum,int[] primes){		//Should really say "isInList" but eh.
		for (int num: primes){
			if (num == myNum)
				return true;
		}
		return false;
	}

	public static void warning(int[] list){ 					//Sometimes it likes to take its sweet time.
		
		if (list.length > (Math.pow(10,5))){
				System.out.println("\nWarning: list is very large. Prime search may take a while.\nThe program is not hung.");
			}
	}

}

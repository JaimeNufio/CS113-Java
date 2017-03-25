public class Primes{
	
	public static int primesCnt = 0; //We're working with static functions, so a static variable seems useful.

	public static void main(String[] schwifty){

		int[] list = new int[100];
		for(int i = 0; i<list.length; i++){list[i]=i;}//Initialize the list

		//sieve(list);
	
		goldbach(list);
	
	}


	public static void sieve(int[] list){

		int  start = 0, cap = (int) Math.ceil(Math.sqrt(list.length)); //largest number we care to check for
		int[] newList = list;
		
		String primesFound = "";

		newList[1] = 0; //one is not prime, lets avoid that problem
 
		for (int i = 0; i<cap; i++){
			start = findNextPrime(newList);
			for (int j = start*2; j<list.length;j+=start){
			//	if (newList[j] != 0)					 //Debug Purposes
			//		System.out.println(newList[j]+" is not prime");
				newList[j] = 0;
			}
		}
		
		primesCnt = 0; //Repurpose the variable used as a stepper as a final count of primes.
		for (int num: newList){
			if (num != 0)
				primesFound+=", "+num;
		}
		System.out.println(primesFound);	
	}

	public static void goldbach(int[] list){
		int[] primes = getPrimeList(list);
		for (int i = 0; i<list.length; i+=2){
			for (int firstPrime:primes){
				for (int secondPrime:primes){
					if (firstPrime+secondPrime==list[i] && list[i]>=4){
						System.out.println(list[i]+" = "+firstPrime+" + "+secondPrime);
					}
				}
			}
		}	
	}

	
	public static int[]  getPrimeList(int[] list){

		//it was specified that I have a function sieve that doesn't return any values. I COULD have easily
		//had made it so sieve returns a list of primes, but instead, to meet criteria, I'm just going to make this new method do that.

		int  start = 0, cap = (int) Math.ceil(Math.sqrt(list.length)); //largest number we care to check for
		int[] newList = list;
		
		String primesFound = "";

		newList[1] = 0; //one is not prime, lets avoid that problem
 
		for (int i = 0; i<cap; i++){
			start = findNextPrime(newList);
			for (int j = start*2; j<list.length;j+=start){
			//	if (newList[j] != 0)					 //Debug Purposes
			//		System.out.println(newList[j]+" is not prime");
				newList[j] = 0;
			}
		}
		
		primesCnt = 0; //Repurpose the variable used as a stepper as a final count of primes.
		
		for (int num: newList){ //Count Primes
			if (num != 0)	
				primesCnt++;
		}

		int[] primeArray = new int[primesCnt];
		int pos = 0;
		for (int i = 0; i<newList.length; i++){
			if (newList[i] != 0){
				primeArray[pos]=newList[i];
				pos++; //does this count as a hack? I mean there has GOT to be a better way to do this.
			}
		}

		return primeArray;

	}

	public static int findNextPrime(int[] list){ //Seperate function b/c it helps me organize myself
		int nextPrime = -1, cnt = 0;
		for (int num:list){
			if (num !=0){
				cnt++;
				if (cnt >= primesCnt){
					nextPrime = num;
					primesCnt++;
					//System.out.println("Next int sweep: "+num); //Debug Purposes
					//So this sweeps 2 twice, maybe b/c I skip 1?	
					//quite honestly, I don't care, b/c it works.
					break;
				}
			}
		}
		return nextPrime;
	}

}

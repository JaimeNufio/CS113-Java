public class Primes{
	
	public static int primesCnt = 0; //We're working with static functions, so a static variable seems useful.

	public static void main(String[] schwifty){

		int[] list = new int[1000000];
		for(int i = 0; i<list.length; i++){list[i]=i;}//Initialize the list

		sieve(list);
		//goldbach(list);
	
	}


	public static void sieve(int[] list){

		int  start = 0, cap = (int) Math.ceil(Math.sqrt(list.length)); //largest number we care to check for
		int[] newList = list;
		
		String primesFound = "Primes found between 0 and "+list.length+": ";//Tell the user what the list size is

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
				primesCnt++; 
				primesFound+=num+" ";
		}
		System.out.println(primesFound+". There were "+primesCnt+" found."); //Barf numbers.
	}

	public static void goldbach(int[] list){
		int[] numList = list, primes = getPrimeList(list);
		boolean pass = false;
		for (int i = 4; i<numList.length; i+=2){ //start at 4, b/c even though 1+1 = 2 and 1+2 = 3, 1 is not prime
			pass = false;
			for (int firstPrime:primes){ //compare a set of primes to the number we are on, starting with 4
				for (int secondPrime:primes){ //Code quality sucks :( Takes forever for numbers like 1,000,000
					if (firstPrime+secondPrime==i && !pass){ //But Im not in an algorithim class yet so eh.
						System.out.println(i+" = "+firstPrime+" + "+secondPrime); 
						pass = true;
						//worth noting, there are multiple solutions to MANY even numbers
						//the pseudo-continue allows for only the first solution to pass	
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
				primeArray[pos]=i;
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

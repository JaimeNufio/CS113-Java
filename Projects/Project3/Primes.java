public class Primes{
	
	public static int primesCnt = 0;

	public static void main(String[] schwifty){

		int[] list = new int[1000000];
		for(int i = 0; i<list.length; i++){list[i]=i;}

		sieve(list);
		
	}


	public static void sieve(int[] list){

		int  start = 0, cap = (int) Math.ceil(Math.sqrt(list.length)); //largest number we care to check for
		int[] newList = list;
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
		}
		System.out.print("Number of Primes from 0 to "+list.length+": "+primesCnt);
		
	}

	public static int findNextPrime(int[] list){
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

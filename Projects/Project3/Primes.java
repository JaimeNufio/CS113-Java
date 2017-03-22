public class Primes{
	
	public static void main(String[] schwifty){

		int[] list = new int[100];
		for(int i = 0; i<list.length; i++){list[i]=i;}

		sieve(list);
		
	}


	public static void sieve(int[] list){

		int nextInt=2, primeCount = 0, lastPrimeCount = 0;
		int[] newList = list; //either I'm an idiot, or I can't edit the old list.
		newList[1]=0; //1 is not Prime

		while(primeCount != lastPrimeCount){
			for (int i = nextInt*2; i<newList.length; i+=nextInt){//PrimeSearch
				newList[i] = 0;	
			}
			lastPrimeCount = primeCount;
			primeCount = primeCheck(newList);
		}
		
		for (int i = 0; i<newList.length; i++){
			if (i !=0){
				System.out.println(i);
			}
		}

	}

	public static int primeCheck(int list){ //well, most of the numbers counted wont be prime, but they will be possible primes
		int cnt=0;
		for(int i = 0; i<list.length; i++){
			if (i != 0){
				cnt++;
			}
		}	
		return cnt;
	}
}

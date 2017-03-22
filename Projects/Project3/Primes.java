public class Primes{
	
	public static void main(String[] schwifty){

		int[] list = new int[100];
		for(int i = 0; i<list.length; i++){list[i]=i;}

		sieve(list);
		
	}


	public static void sieve(int[] list){

		int nextInt=2,lastInt = -1;
		int[] newList = list; //either I'm an idiot, or I can't edit the old list.
		newList[1]=0;

		while(lastInt != nextInt){
			for (int i = nextInt*2; i<list.length; i+=nextInt){ //reassign everything thats a multiple of nextInt
				newList[i]  = 0;
			}
			for (int num:newList){
				if (num != 0){
					System.out.println("New Prime found to be "+num);
					lastInt = nextInt;
					nextInt = num;
					break;
				}
			}
		}

		double count = 0;
		for (int num:newList){
			if (num != 0)	
				System.out.println(num);
		}
		System.out.println(count);
	}

}

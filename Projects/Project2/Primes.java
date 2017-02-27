class Primes{

	public static void main(String[] args){
		
		int[] nums = new int[100];
		sieve(nums);
		
	}

	public static void sieve(int[] array){

		int[] theSieve = {2,3,5,7};
			
		for (int i = 0;i<array.length;i++){
			array[i]=i;	
			for (int k: theSieve){
				char[] digits = array[i].toCharArray();
				switch (k):
				
				case 2:
					
					break;
				case 3:
					break;
				case 5:
					break;
				case 7:	
					break;
			}
		}		

		for (int num:array){
			if (true){
				System.out.println(num);
			}
		}

	}

}

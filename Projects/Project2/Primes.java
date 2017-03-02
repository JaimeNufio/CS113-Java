class Primes{
	public static void main(String[] args){

		int[] nums = new int[100];
		sieve(nums);

	}

	public static void sieve(int[] array){

		int[] theSieve = {1,2,3,5,7};

		for(int i = 0;i<array.length;i++){
			array[i] = i; //assign value
			char[] digitList = (array[i]+"").toCharArray();
			int[] digits = new int[digitList.length];
			for (int j = 0;j<digits.length;j++){
				digits[j] = Character.getNumericValue(digitList[j]);
			}
			int lastDigit = digits[digits.length-1];

			//System.out.println(lastDigit);

			for (int k:theSieve){
				
				switch(k){
				ca
		}

	}
}

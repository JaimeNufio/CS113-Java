class Primes{

	public static void main(String[] args){
		
		int[] nums = new int[100];
		sieve(nums);
		
	}

	public static void sieve(int[] array){

		int[] theSieve = {2,3,5,7};
			
		for (int i = 0;i<array.length;i++){

			array[i]=i; //asign number

			for (int j: theSieve){ //loop assigned number thru the Sieve

				char[] digitList = (array[i]+"").toCharArray(); //convert number into a series of char
				int[] digits = new int[digitList.length];
				
				for (int k = 0; k<digitList.length;k++){
					digits[k] = Character.getNumericValue(digitList[k]);
				}					

				int lastDigit = (digits[digits.length-1]); //get the last number

				switch (j){
				
				case 2:
					if (lastDigit % 2 == 0 && array[i] != 2){
						array[i] = 0;
					}
					break;
				case 3:
					int total = 0;

					for (int dig:digits){
						total+=(dig);
					}

					if(total % 3 == 0 && array[i] != 3){
						array[i] = 0;
					}

					break;
				case 5:
					if (lastDigit % 5 == 0 && array[i] != 3){
						array[i] = 0;
					}
					break;
					
				case 7:
					lastDigit*=2;
					
					int count = 0;

					for (int l = 0;l<digits.length-1;l++){
						count+=(l);
					}

					if(count-lastDigit % 7 == 0 && array[i] != 7){
						array[i] = 0;
					}

					break;
				}
			}
		}		

		for (int num:array){
			if (true){
				System.out.println(num);
			}
		}

	}

}

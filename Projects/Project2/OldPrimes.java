class Primes{

	public static void main(String[] args){
		
		int[] nums = new int[100];
		sieve(nums);
		
		for (int num:nums){
			if (num != 0){
				System.out.println(num);
			}
		}
	}

	public static void sieve(int[] array){

		int[] theSieve = {7,5,3,2,1};
			
		for (int i = 0;i<array.length;i++){  

			array[i]=i; //asign number

			char[] digitList = (array[i]+"").toCharArray(); //convert number into an array of char
			int[] digits = new int[digitList.length];//create empty array of same size
				
			for (int k = 0; k<digitList.length;k++){
				digits[k] = Character.getNumericValue(digitList[k]); //copy char as digit
			}					

			int lastDigit = (digits[digits.length-1]); //get the last number
//			System.out.println(array[i]+" "+lastDigit);			
		

			for (int j: theSieve){ //loop assigned number thru the Sieve
	
					switch (j){
				
					case 1:
						if (array[i] == 1){
							array[i] = 0;
							System.out.println(array[i]+" marked 0 by case "+j);
						}			
						break;	
					case 2:
						if (lastDigit % 2 == 0){
							System.out.println(array[i]+" marked 0 by case "+j);
							array[i] = 0;
						}
						break;
					case 3:
						int total = 0;
	
						for (int dig:digits){
							total+=(dig);
						}
	
						if(total % 3 == 0){
							
							System.out.println(array[i]+" marked 0 by case "+j);
							array[i] = 0;
						}

						break;
					case 5:
						if (lastDigit % 5 == 0){
							System.out.println(array[i]+" marked 0 by case "+j);
							array[i] = 0;
						}
						break;
					
					case 7:
						lastDigit*=2;
						
						int count = 0;

						for (int l = 0;l<digits.length-1;l++){
							count+=(array[i]);
						}
//						System.out.println(array[i]+" gets function result"+(count-lastDigit)+" last digit: "+lastDigit+" count"+count);
						if(Math.abs(count-lastDigit % 7) == 0 ){
							System.out.println(array[i]+" marked 0 by case "+j);
							array[i] = 0;
						}

						break;
					default:
						System.out.println(array[i]+" passed "+j);
					}
			}
		}		
	}

}

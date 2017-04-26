/*
Jaime Nufio
Jen25
31393971
Kapleau CS113 Section 2
*/


public class PascalTriangle {

    public static void main(String[] args) {

        int n = args.length == 1 ? Integer.parseInt(args[0]) : 1;
		
		for (int i = 1; i <= n; ++i) {
            int[] arr = Pascal.triangle(i);
            System.out.print((i < 10 ? " " : "") + i + ": ");
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

class Pascal {
	
	

    public static int[] triangle(int n) {

		int[] row = new int[n]; //row to return of size n;
		
		row[0] = 1; row[n-1] = 1; 	//All cases have this in common. 
		//even the first, where it assigns something twice

		if (n!=1){		//Base case has no math nor recursion.	
			int[] lastRow = triangle(n-1); //get last iteration by recursion
			row[1] = n-1; row[n-2] = n-1; //assign 2nd and penulitimate values
			for(int i = 2; i<(n-1); i++){ // assign values to array according to the previous iteration
				row[i] = (lastRow[i-1]+lastRow[i]);
			}
		}		

        return row; 
    }
}

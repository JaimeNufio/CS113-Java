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

		int[] row = new int[n];

		//Every row begins and ends in 1, so this goes before all conditions	
		row[0] = 1;
		row[n-1] = 1;

		if (n != 1){ //only do this math if the current row has width 2, there is no case for width < 1, so its not taken into account		
			row[1] = n-1; 	//All rows look like: 1 (X-1) ...Some Numbers... (X-1) 1
			row[n-2] = n-1; //its this line that makes me think the if statement is necesary, but I have my doubts.
			for (int i = 2; i < (n-1); i++){ //for the numbers in the middle, we start at 2 because we know positions 0 and 1
					int[] lastRow = triangle(n-1); //recursion to figure out the two pascal addends from the prior row
					row[i] = (lastRow[i-1]+lastRow[i]); //do math
			}	
		}

        return row; //return the array for row n

		/*
			And because I took the time to comment it:
			-Base Case is a row of width one storing 1, {1}, but because the ends of all rows must be 1
			 it just worked out that for the base case assigning row[0] and row[1-1] is just doing the same thing twice,
			 resulting in a scenario where I don't really have to take care for it because its gonna happen anyway, without stepping through a loop.

			-The recursive case steps through a loop to check previous rows for the addends for pascals triangle. Its encapsulated in the if statement,
			 and I feel with improved code quality I could probably even do without it, but that's not something I'm getting graded on, I don't think.

			-Method must return an int[], which is just outright stated by the function declaration you gave us in class. More so, its just the most
			 obvious choice: we are recursively stepping through lower levels of a pyramid built of a series of int. The best way to pass a bunch of intgers
			 that are related to one another is with an int[].
				
		*/
    }
}

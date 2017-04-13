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
		row[0] = 1;

		if (n == 1){

		}else{	
			row[n-1] = 1;
			for (int i = n; i < (n-1); i++){
				int[] lastRow = triangle(n-1); 
				row[i] = (lastRow[i-1]+lastRow[i]); 	
			}	
		}

        return row;
    }
}

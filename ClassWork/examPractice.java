import java.util.*;
public class examPractice{

	public static void main(String args[]){
	
	/* Practice 6.1	
		Scanner scan = new Scanner(System.in);
		int fromUser=0,total=0,cnt=0;
		fromUser = Integer.parseInt(scan.next());
		
		
		for (int i = 0; i <= fromUser; i++){
			if (i%2 != 0){
				total+=i;
				cnt++;
			}
		}		

		System.out.println((double)(total/cnt));
	*/

	//6.10
	/*
		String[] words = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve"};
		String text="", oldtext="";

		for (int i = 0; i<12; i++){
			text = words[i];
			oldtext = "";
			if (i > 0){
				for (int k = i-1; k >= 0; k--){
					oldtext+=words[k]+", ";
				}	
			}
			System.out.println("On the"+place(i+1)+" day of Christmas my true love gave to me, "+text+"\n"+oldtext);
		}

	}

	public static String place(int i){
		
		String text = "";
		switch(i){

			case 1:
				text = "1st";
			break;
			
			case 2:
				text = "2nd";
			break;

			case 3:
				text = "3rd";
			break;

			default:
				text = i+"th";
		}
		
		return text;
	}*/

	
	/*
		String Fabs = "Fabrizio";
		char[] fabsname = Fabs.toCharArray();
	
		for (int i = 0; i<fabsname.length;i++){
			System.out.print(Fabs.charAt(i));
		}
	
	*/

	}	

}


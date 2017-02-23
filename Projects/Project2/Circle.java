import java.util.Random;

public class Circle{

	/*
	Jaime Nufio, Jen25, 31393971
	CS 113
	*/

	double r;
	int countInCircle,countOutCircle;

	private static double mag(double[] set){

		double sum = 0;

		for (int i = 0; i<2;i++){
			sum+=Math.pow(set[i],2);
		}

		return (double) Math.sqrt(sum);
	}
	
	public static void main(String things[]){

		int numthings = Integer.parseInt(things[0]);
		double countInCircle = 0,countOutCircle=0;
		Random rand = new Random();
		
		for (int i = 0;i<numthings;i++){
		
			double[] pnt = new double[2];
			pnt[0] = rand.nextDouble();
		 	pnt[1] = rand.nextDouble(); 		
			
			if (mag(pnt) < 1){ // when I included the boundry, the experimental numbers were ~.79, too large
				countInCircle++;
			}else{
				countOutCircle++;
			}
		}

		System.out.println("For "+things[0]+" attempts, it was found that "+(countInCircle/numthings)+"% of points landed inside the circle.");
		System.out.println("For reffrence, it is theoretically expected for this number to be pi/4, or "+(Math.PI/4)+"%.");

	}
}

//PP: 3.5, 3.6, 3.7, 3.9, 4.3, 4.6
import java.util.Scanner;
import java.util.Random;

public class Hw{
	public static void main(String[] args){

		//So, this won't all run at the same time. It has to do with how I call "scan.nextDouble()"
		//Before I check if there is a thing to scan. Now, were this an actual program where these would all run 
		//together, I'd fix it, but these problems are independent, and as such I didn't feel the need to fix the issue 
		//of going from one problem into the other with if or try statements. So kindly uncomment the method you're 
		//checking, and recomment anything not in use. It should all work independently.	

		//Magnitude(); //3.5
		//VolumeAndArea(); //3.6
		//Heron(); //3.7
		//RandCylinder(); //3.9
	
		//The above paragraph really only describes the above functions
			
		MultiSphere Balls  = new MultiSphere();
		//System.out.println(Balls);
		TestBox Boxes = new TestBox(3);//This 3 is a multiplier

		//Oh, and I should mention that the HW wanted me to put them into their own independent .java files,
		//but whats the point if I can run them via a constructor?
	}

	private static void Magnitude(){	
		System.out.println("Problem 3.5");
		double x,y;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input an x value");
		x = scan.nextDouble();
		System.out.println("Input a y value");
		y = scan.nextDouble();	
		System.out.println(Math.sqrt(Math.pow(x,2)+Math.pow(y,2)));
		scan.close();
	}

	private static void VolumeAndArea(){		
		System.out.println("Problem 3.6");
		double r,volume,area;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a radius value");
		r = scan.nextDouble();
		volume = (4/3)*Math.PI*Math.pow(r,3);
		area = (4)*Math.PI*Math.pow(r,2);
		System.out.println("Volume = "+volume+"\nArea = "+area);
		scan.close();
	}

	private static void Heron(){
		System.out.println("Problem 3.7");
		Scanner scan = new Scanner(System.in);
		double[] sides = new double[3];
		double perimeter = 0,s,Area;

		for (int i = 0; i<3;i++){
			System.out.println("Enter value for Triangle side "+(i+1));
			sides[i] = scan.nextDouble();
			perimeter+=sides[i];
		}	
			
		s = perimeter/2;
		Area = Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
		Area = (double) Math.round(Area*1000)/1000;	

		System.out.println("Got:\nArea= "+Area);
		scan.close();
	}

	private static void RandCylinder(){
		System.out.println("3.9");
		double r,h,volume,area;
		Random rand = new Random();
		r = rand.nextInt(21-1)+1;
		h = rand.nextInt(21-1)+1;
		volume = Math.PI*(Math.pow(r,2))*h;
		area = Math.PI*2*r*h;
		System.out.println("Got:\nHeight = "+h+"\nRadius"+r+
			"\nVolume = "+volume+"\nArea = "+area);
	}
}

class Sphere{
	double diameter;
	Sphere(double diameter){	
		this.setDiameter(diameter);
	}

	public double getDiameter(){
		return this.diameter;
	}

	public  void setDiameter(double diameter){
		this.diameter = diameter;
	}

	public double volume(){
		double volume = (4/3)*Math.PI*Math.pow((this.diameter/2),3);	
		return (double) Math.round(volume*1000)/1000;	
	}

	public double area(){
		double area = (4)*Math.PI*Math.pow((this.diameter/2),2);
		return (double)  Math.round(area*1000)/1000;	
	}

	public String toString(){
		return "Sphere of Diameter "+this.diameter+" has:\n"+
			"Volume: "+this.volume()+"\nArea: "+this.area();	
	}
}

class MultiSphere{
	Sphere[] Balls  = new Sphere[4];
	
	MultiSphere(){	
		System.out.println("Problem 4.3");
		for (int i = 0; i<4; i++){
			Balls[i] = new Sphere(i+1); //idk what you wanted to be done, but the diameters follow the index
		}
	}
	
	private void modSpheres(double mult){
		for (int i = 0; i < this.Balls.length;i++){
			Balls[i].setDiameter(Balls[i].getDiameter()*mult);
		}
	}

	public String toString(){
		String text = "";	

		for (int i = 0; i<4;i++){
			text+=Balls[i].toString()+"\n";
		
		}
		
		return text;
	}
}	

class Box{
	double height, depth, width;
	boolean full;
	
	Box(double height, double depth, double width, boolean full){
		this.setHeight(height);
		this.setDepth(depth);
		this.setWidth(width);
		this.setFull(full);		
	}
	
	public void setDepth(double val){
		this.depth = val;
	}

	
	public void setWidth(double val){
		this.width = val;
	}

	
	public void setHeight(double val){
		this.height = val;
	}


	public void setFull(boolean val){
		this.full = val;
	}

	
	public double getHeight(){
		return this.getHeight();
	}


	public double getWidth(){
		return this.getWidth();
	}


	public double getDepth(){
		return this.getDepth();
	}


	public boolean getFull(){
		return this.getFull();
	}
	
	public String toString(){
		String addText = "";

		if (!this.getFull()){
			addText = "not ";
		}

		return "This Box is "+addText+"full, and of Dimensions"+this.getWidth()+"x"+this.getDepth()+"x"+this.getHeight()+"(Width,Depth,Height).";
	}
}

class BoxTest{
	Box[] Boxes = new Box[3];
	BoxTest(double num){
		System.out.println("Program 4.6");
		for (int i = 0; i<3;i++){
			this.Boxes[i] = new Box(i,i,i,true);
		}
	}

}

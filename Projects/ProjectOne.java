//import java.util.*;

public class ProjectOne {
	public static void main(String[] args){
		Rational a = new Rational(1,10);
		Rational b = new Rational(5,15);
		
		System.out.println(a+" / "+b+" = "+a.div(b));
		System.out.println(a+" * "+b+" = "+a.mult(b));
		System.out.println(a+" + "+b+" = "+a.add(b));
		System.out.println(a+" - "+b+" = "+a.sub(b));
		System.out.println(a+" has the GCD "+a.gcd());
		System.out.println(b+" has the GCD "+b.gcd());	
	}
}

class Rational{
	
	double num,denom;
	
	Rational(double num, double denom){	
		setDenom(denom);
		setNum(num);

		double gcdCheck = this.gcd();
	}
	
	public String toString(){
		return this.getNum()+"/"+this.getDenom();
	}
	
	private boolean divideZeroErrTest(Double test){
		if (test != 0 )
			System.out.println("Divide by Zero Error; Setting instance of Rational to null ");
		return test != 0;
	}
	
	private void setNum(double num){
		this.num = num;	
	}
	
	private void setDenom(double denom){
		this.denom = denom;	
		
	/*	if (divideZeroErrTest(denom)){
			//this = null;
			this.setNum(0);
			this.setDenom(1);
			//Turns out, setting an instance of a class to null is nonsense!
		}
	*/

	}
	
	public double getNum(){
		return this.num;
	}

	public double getDenom(){
		return this.denom;
	}
	
	public Rational add(Rational two){
		double comDenom = this.getDenom()*two.getDenom();
		double num1,num2;
		num1 = this.getNum()*two.getDenom(); num2 = two.getNum()*this.getDenom();
		return simp(new Rational(num1+num2,comDenom));
	}
	
	public Rational sub(Rational two){ // a - b
		double comDenom = this.getDenom()*two.getDenom();
		double num1,num2;
		num1 = this.getNum()*two.getDenom(); num2 = two.getNum()*this.getDenom();
		return simp(new Rational(num1-num2,comDenom));
	}
	
	public Rational mult(Rational two){
		return simp(new Rational(this.getNum()*two.getNum(),this.getDenom()*two.getDenom()));
	}

	public Rational div(Rational two){ // a/b
		return simp(new Rational(this.getNum()*two.getDenom(),this.getDenom()*two.getNum()));
	}

	public Rational simp(Rational simp){ //Simplify method (We have the GCD, might as well use it)
		
		//System.out.println(simp.gcd());
		double denomT = simp.getDenom()/simp.gcd(), numT = simp.getNum()/simp.gcd();		

		if (denomT < 0 || numT < 0){//Get the negative out of the denominator if there is one
			denomT = Math.abs(denomT);
			numT = -numT;
		}

		if ((denomT == (int)(denomT)) && (numT == (int)(numT)) ){//ensure #/gcd is integer
			simp.setDenom(denomT);
			simp.setNum(numT);		
		}
		
		return simp;
	}
		

	public double gcd(){

		double a, b,temp;
		a = this.num; b = this.denom;

		/*while (b!=0){ This didn't work for all cases for some reason
			a = b;
			b = a%b;
		}*/

		while (b != 0){ //this however, did
			temp = b;
			b = a%b;
			a = temp;
		}
		
		//System.out.println(a);
		return a;
	}
}

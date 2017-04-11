//import java.util.*;
/*
Jaime Nufio
CS113 Section 002
UCID - Jen25
*/ 


class Rational extends Number implements Comparable<Rational>{

	///**START OF KAPLEAU'S CODE**////

	public static void main(String[] Schwifty){

	}

/*
    public static void main(String[] args) {

        Rational a = new Rational(2, 4);
        Rational b = new Rational(2, 6);

        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.sub(b));
        System.out.println(a + " * " + b + " = " + a.mul(b));
        System.out.println(a + " / " + b + " = " + a.div(b));

        Rational[] arr = {new Rational(7, 1), new Rational(6, 1),
                          new Rational(5, 1), new Rational(4, 1),
                          new Rational(3, 1), new Rational(2, 1),
                          new Rational(1, 1), new Rational(1, 2),
                          new Rational(1, 3), new Rational(1, 4),
                          new Rational(1, 5), new Rational(1, 6),
                          new Rational(1, 7), new Rational(1, 8),
                          new Rational(1, 9), new Rational(0, 1)};

        selectSort(arr);

        for (Rational r : arr) {
            System.out.println(r);
        }

        Number n = new Rational(3, 2);

        System.out.println(n.doubleValue());
        System.out.println(n.floatValue());
        System.out.println(n.intValue());
        System.out.println(n.longValue());
    }

    public static <T extends Comparable<? super T>> void selectSort(T[] array) {

        T temp;
        int mini;

        for (int i = 0; i < array.length - 1; ++i) {

            mini = i;

            for (int j = i + 1; j < array.length; ++j) {
	            if (array[j].compareTo(array[mini]) < 0) {
	                mini = j;
	            }
            }

            if (i != mini) {
	            temp = array[i];
	            array[i] = array[mini];
	            array[mini] = temp;
            }
        }
    }
*/

	///**END OF UNCHANGEABLE CODE**////	

	double num,denom;
	
	Rational(double num, double denom){	
		setDenom(denom);
		setNum(num);

		double gcdCheck = this.gcd();
	}

	public double doubleValue(){
		return (double) (num/denom);
	}
	
	public float floatValue(){
		return (float) (num/denom);
	}

	public long longValue(){
		return (long) (num/denom);
	}

	public int	intValue(){
		return (int) (num/denom);
	}

	public int compareTo(Rational fraction){
		if (fraction.doubleValue() > this.doubleValue()){
			return 1;
		} else if (fraction.doubleValue() < this.doubleValue()){
			return -1;
		}
			return 0;
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
	
	private double getNum(){
		return this.num;
	}

	private double getDenom(){
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
	
	public Rational mul(Rational two){
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

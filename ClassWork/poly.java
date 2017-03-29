public class poly{

	public static void main(String[] args){

		base b = new Derived();
		b.foo();
	}
}

class base{

	public void foo(){
		System.out.println("BASE");
	}

}

class Derived extends base{
	public void foo(){
		System.out.println("DERIVED");
	}
}

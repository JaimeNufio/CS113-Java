public class ChapterEight{

	public static void main(String[] Schwifty){
	
		Derived d = new Derived();
		d.foo();
	}

}

class Base {

	public void foo(){
		System.out.prinln("Base foo");
	}

}

class Derved extends Base{

	//foo = 2; Error, foo is private in the parent. Would protected work?
	
	super Derived(){
		System.out.println("Hello World");
	}	

}



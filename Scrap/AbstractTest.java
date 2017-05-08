public class AbstractTest{

	public static void main(String[] args){

		myObj testObj = new thing();
		testObj.fuck();
		testObj.thingy();		
	}

}


abstract class myObj{

	abstract void fuck();
	
	void thingy(){
		System.out.print("ok");
	}

}

class thing extends myObj{

	void fuck(){
		System.out.print("mhmm");
	}
	
}

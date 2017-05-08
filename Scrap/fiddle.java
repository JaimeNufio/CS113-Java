public class fiddle{

	public static void main(String[] args){

		testy obj = new testy();
		obj.shit();
		
//		absy shit = new shitty();
	}

}

class foo{
	int num = 5;

	public static int bar(int thing){
		return thing+5;
	}

}

class boo{

	int num;
	
	public boo(int shit){
		this.num = shit;
	}
}

interface test{

	int i = 5;
	abstract void shit();
	public void absMeth();
		
	}

abstract class absy{
	
	abstract public void absMeth1();
	abstract public void absMeth2();
	abstract public void absMeth();
}

abstract class shitty extends absy{
	public void absMeth(){
		
	}
}

abstract class tester implements test{
	public void shit(){
		System.out.println(this.i);
	}
	public abstract void absMeth();	
}

class testy extends tester{

	public void absMeth(){
		
	}

}


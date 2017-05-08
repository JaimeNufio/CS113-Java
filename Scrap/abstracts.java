public class abstracts{

	public static void main(String args[]){

		fuck thing  = new fuck();
		thing.foo();
	}

}

interface inter{
	
	public int positive();
	public int negative();

}

abstract class abstr{
	
	abstract public int positive();
	abstract public int negative();
	
	public void foo(){
		System.out.println();	
	}

}

class fuck extends abstr{

	public int positive(){
		return -1;
	}
	public int negative(){
		return -1;
	}
}

class shit implements inter{
	public int positive(){
		return 1;
	}
	public int negative(){
		return -1;
	}
}

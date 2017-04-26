public class abstracts{

	public static void main(String args[]){

	}

}

interface inter{
	
	public int positive();
	public int negative();

}

abstract class abstr{
	
	abstract public int positive();
	abstract public int negative();
}

abstract class fuck extends abstr{

}

abstract class shit implements inter{
	abstract public int positive(){
		
	}
	abstract public int negative(){
			
	}
}

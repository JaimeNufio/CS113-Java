public class Exceptions{

	public static void main(String[] schwifty){
	
		try{
			divide(1,0);
		}catch(MyWillToLive e){ //catch exception
			System.out.println(e);
			//`System.exit(46); //error code marking
		}finally{ //after catch statement, if we haven't exited
			System.out.println("woohoo"); 
		}

	}	

	public static int divide ( int m, int n){
		
		if (n==0){
			throw new MyWillToLive(); //type of exception
		}
		
		return m/n;
	}
	
}

class myWillToLive extends Throwable{

}

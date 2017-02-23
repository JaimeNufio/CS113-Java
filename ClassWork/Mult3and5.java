public class Mult3and5{
	public static void main(String[] args){
		int cnt = 0;
		for (int i = 0; i<=1000; i++){
			if((i % 3 == 0 || i % 5 == 0) && !(i%15 ==0)){
				cnt+=i;			
			}
		}
		System.out.println(cnt);
	}
}

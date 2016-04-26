
public class MyClass {

	public static int larger(int a, int b) {
		if(a>b)								//1
			return a;						//2
		else
			return b;						//3
	}										//4
	
	public static int abs(int a) {
		if(a>=0)							//1
			return a;						//2
		else
			return -a;
	}
	
	public static int median(int a, int b, int c) {
		if(a<=b){
			if(b<=c)
				return b;
			else if(a<=c)
				return c;
			else
				return a;
		}
		else{
			if(a<=c)
				return a;
			else if(b<=c)
				return c;
			else
				return b;
		}
	}
}

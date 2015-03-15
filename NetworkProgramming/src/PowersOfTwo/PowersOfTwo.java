package PowersOfTwo;

public class PowersOfTwo {
	public static void main(String[] args) {
		// last power of two to print
		
		int N = Integer.parseInt(args[0]); 
		int i = 0; 
		
		// loop control counter 
		
		int v = 1; 
		 //current power of two
		
		for (int j=0; j <= N; j++ ) 
		{
		System.out.println(i + " " + v);
		i = i + 1;
		v = 2 * v;
		}
		}

}

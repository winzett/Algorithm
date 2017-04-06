import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = 0 ;
		int val = 0;
		int [] output;
		input = sc.nextInt();
		
		
		for(int i = 0 ; i < input ; i ++){
			val = sc.nextInt();
			output = new int[val+1];
			output[1] = 1;
			output[2] = 2;
			output[3] = 4;
			
			for(int j = 4 ; j <= val ; j ++)
				output[j] = output[j-1]+output[j-2]+output[j-3];
			
			
			
			System.out.println(output[val]);
		}
		
		
			
	}

}

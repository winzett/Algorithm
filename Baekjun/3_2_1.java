import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input;
		int[] arr = new int [1000001];
		for(int i = 1 ; i < 1000001 ; i ++)
			arr[i] = 10000001;
		input = sc.nextInt();
		
		arr[input] = 0;
		
		for(int i = input ; i > 0 ; i --){
			if(i>2)
				arr[i-1] = arr[i-1] < arr[i]+1 ? arr[i-1]:arr[i]+1;
			if(i %2 == 0)
				arr[i/2] = arr[i/2] < arr[i]+1 ? arr[i/2]:arr[i]+1;
			if(i %3 == 0)
				arr[i/3] = arr[i/3] < arr[i]+1 ? arr[i/3]:arr[i]+1;
		}
		
		
		System.out.println(arr[1]);

	}

}

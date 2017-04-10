import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc. nextInt();
		int a[] = new int [n];
		for(int i = 0 ; i < n ; i ++)
			a[i] = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		BigInteger sum = new BigInteger("0");
		
		for(int i = 0 ; i < n ; i++){
			a[i] -= b;
			if(a[i]<0) a[i] = 0;
			
			if(a[i]%c>0)
				sum = sum.add(BigInteger.valueOf((a[i]/c)+1));
			else
				sum = sum.add(BigInteger.valueOf((a[i]/c)));
			
		}
		
		System.out.println(sum.add(BigInteger.valueOf(n)));
		
	}

}

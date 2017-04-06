import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		BigInteger d[] = new BigInteger [input+1];
		for(int i = 1 ; i <= input ; i ++){
			
			d[i] = new BigInteger("0");
			if(i == 1)
				d[i] = d[i].add(BigInteger.ONE);
			else if(i == 2)
				d[i] = d[i].add(BigInteger.valueOf(2));
			else if(i == 3)
				d[i] = d[i].add(BigInteger.valueOf(3));
			else{
				d[i] = d[i].add(d[i-1]);
				d[i] = d[i].add(d[i-2]);
			}
			
		}
		System.out.println(d[input].mod(BigInteger.valueOf(10007)));
			
	}

}

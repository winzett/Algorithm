import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static final int up = 1;
	static final int left = 2;
	static final int right = 3;
	static final int down = 4;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		BigInteger map[][] = new BigInteger[n][n];
		BigInteger max = BigInteger.ZERO;
		BigInteger max_arr[] = new BigInteger[6];
		for(int i = 0 ; i < 6 ; i ++)
			max_arr[i] = BigInteger.ZERO;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = sc.nextBigInteger();

		go(0, max_arr, 0, map, n);

		for (int i = 0; i < max_arr.length; i++) 
			max = max.compareTo(max_arr[i]) == 1 ? max : max_arr[i];
		

		System.out.println(max);

	}

	public static int go(int trial, BigInteger[] arr, int dir, BigInteger[][] map, int n) {

		BigInteger[][] copy = new BigInteger[n][n];
		int counter = n;

		if (trial >= 5)
			return 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				copy[i][j] = map[i][j];

		
		while (counter != 0) {
			counter = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (copy[i][j] != BigInteger.ZERO) {
						switch (dir) {
						case up:
							if (i < n - 1 && copy[i + 1][j].equals(BigInteger.ZERO)) {
								copy[i + 1][j] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						case left:
							if (j > 0 && copy[i][j - 1].equals(BigInteger.ZERO)) {
								copy[i][j - 1] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						case right:
							if (j < n - 1 && copy[i][j + 1].equals(BigInteger.ZERO)) {
								copy[i][j + 1] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						case down:
							if (i > 0 && copy[i - 1][j].equals(BigInteger.ZERO)) {
								copy[i - 1][j] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						}
					}
				}
			}
		}
		
		switch (dir) {
		case up:
			for (int i = n - 2; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					if (copy[i + 1][j].equals(copy[i][j])) {
						copy[i + 1][j] = copy[i+1][j].multiply(BigInteger.valueOf(2));
						copy[i][j] = BigInteger.ZERO;
					}
				}
			}
			break;
		case left:
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (copy[i][j - 1].equals(copy[i][j])) {
						copy[i][j - 1]  = copy[i][j - 1].multiply(BigInteger.valueOf(2));
						copy[i][j] = BigInteger.ZERO;
					}
				}
			}
			break;
		case right:
			for (int i = 0; i < n; i++) {
				for (int j = n - 2; j >= 0; j--) {
					if (copy[i][j + 1].equals(copy[i][j])) {
						copy[i][j + 1] = copy[i][j + 1].multiply(BigInteger.valueOf(2));
						copy[i][j] = BigInteger.ZERO;;
					}
				}
			}
			break;
		case down:
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (copy[i - 1][j].equals(copy[i][j])) {
						copy[i - 1][j] = copy[i - 1][j].multiply(BigInteger.valueOf(2));
						copy[i][j] = BigInteger.ZERO;;
					}
				}
			}
			break;
		}
		
		counter = n;
		while (counter != 0) {
			counter = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (copy[i][j] != BigInteger.ZERO) {
						switch (dir) {
						case up:
							if (i < n - 1 && copy[i + 1][j].equals(BigInteger.ZERO)) {
								copy[i + 1][j] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						case left:
							if (j > 0 && copy[i][j - 1].equals(BigInteger.ZERO)) {
								copy[i][j - 1] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						case right:
							if (j < n - 1 && copy[i][j + 1].equals(BigInteger.ZERO)) {
								copy[i][j + 1] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						case down:
							if (i > 0 && copy[i - 1][j].equals(BigInteger.ZERO)) {
								copy[i - 1][j] = copy[i][j];
								copy[i][j] = BigInteger.ZERO;
								counter++;
							}
							break;
						}
					}
				}
			}
		}


		if (dir != 0) {
			trial++;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[trial] = arr[trial].compareTo(copy[i][j]) == 1? arr[trial] : copy[i][j];
		}

		
			go(trial, arr, up, copy, n);
			go(trial, arr, left, copy, n);
			go(trial, arr, right, copy, n);
			go(trial, arr, down, copy, n);

		return 0;
	}

}

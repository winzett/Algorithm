import java.util.Scanner;

public class Main {

	public static final int R = 1;
	public static final int G = 2;
	public static final int B = 3;
	public static int d[][][][];
	public static int[] r;
	public static int[] g;
	public static int[] b;
	public static int min;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		min = 1000000000;
		int n = sc.nextInt();
		int arr[] = new int[4];

		d = new int[n + 1][n + 1][n + 1][4];

		r = new int[n + 1];
		g = new int[n + 1];
		b = new int[n + 1];

		for (int i = n; i > 0; i--) {
			r[i] = sc.nextInt();
			g[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}

		go(n, arr, 0, 0);

		System.out.println(min);

	}

	static int go(int n, int[] arr, int p, int val) {

		if (n == 0) {
			min = min < val ? min : val;
			return 0;
		}

		if (val > min)
			return 0;

		int[] copy = new int[4];
		int sum;
		for (int i = 1; i < 4; i++) {
			copy[i] = arr[i];
		}

		switch (p) {
		case R:
			if (d[copy[R]][copy[G]][copy[B]][p] == 0)
				d[copy[R]][copy[G]][copy[B]][p] = val + r[n];
			else
				d[copy[R]][copy[G]][copy[B]][p] = d[copy[R]][copy[G]][copy[B]][p] < val
						+ r[n] ? d[copy[R]][copy[G]][copy[B]][p] : val + r[n];
			break;

		case G:
			if (d[copy[R]][copy[G]][copy[B]][p] == 0)
				d[copy[R]][copy[G]][copy[B]][p] = val + g[n];
			else
				d[copy[R]][copy[G]][copy[B]][p] = d[copy[R]][copy[G]][copy[B]][p] < val
						+ g[n] ? d[copy[R]][copy[G]][copy[B]][p] : val + g[n];
			break;

		case B:
			if (d[copy[R]][copy[G]][copy[B]][p] == 0)
				d[copy[R]][copy[G]][copy[B]][p] = val + b[n];
			else
				d[copy[R]][copy[G]][copy[B]][p] = d[copy[R]][copy[G]][copy[B]][p] < val
						+ b[n] ? d[copy[R]][copy[G]][copy[B]][p] : val + b[n];
			break;
		}
		// System.out.println("n : "+n+" p1 : "+p1+" p2 : "+p2);
		if (p != 0)
			n--;

		sum = d[copy[R]][copy[G]][copy[B]][p];

		switch (p) {
		case R:
			copy[G]++;
			go(n, copy, G, sum);
			copy[G]--;
			copy[B]++;
			go(n, copy, B, sum);
			return 0;

		case G:
			copy[R]++;
			go(n, copy, R, sum);
			copy[R]--;
			copy[B]++;
			go(n, copy, B, sum);
			return 0;

		case B:
			copy[R]++;
			go(n, copy, R, sum);
			copy[R]--;
			copy[G]++;
			go(n, copy, G, sum);
			return 0;

		default:
			copy[R]++;
			go(n, copy, R, sum);
			copy[R]--;
			copy[G]++;
			go(n, copy, G, sum);
			copy[G]--;
			copy[B]++;
			go(n, copy, B, sum);
			return 0;
		}

	}

}

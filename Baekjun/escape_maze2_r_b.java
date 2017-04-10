import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final int up = 1;
	static final int left = 2;
	static final int right = 3;
	static final int down = 4;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] input = new String[n];
		char[][] map = new char[n][m];
		int[] arr = new int[11];
		int min = 0;
		Point r = new Point();
		Point b = new Point();

		for (int i = 0; i < n; i++)
			input[i] = sc.next();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = input[i].charAt(j);
				if (map[i][j] == 'R') {
					r = new Point(i, j);
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					b = new Point(i, j);
					map[i][j] = '.';
				}

			}
		}

		go(0, 0, arr, map, r, b);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				min = i;
				break;
			}
		}
		if (min != 0)
			System.out.println(min);
		else
			System.out.println(-1);
	}

	static int go(int trial, int dir, int[] arr, char[][] map, Point r, Point b) {

		Point nr = new Point(r.x, r.y);
		Point nb = new Point(b.x, b.y);
		boolean check[] = new boolean[2];
		boolean done[] = new boolean[2];
		
		check[0] = false;
		check[1] = false;
		done[0] = false;
		done[1] = false;
		
		if (trial == arr.length-1)
			return 0;

		switch (dir) {
		case up: 
			while (!check[0] || !check[1]) {

				if (map[nr.x+1][nr.y] == 'O') {
					done[0] = true;
					check[0] = true;
					nr.x = nr.x+1;
				} else if (map[nr.x+1][nr.y] == '.') {
					
					if(nr.y == nb.y){
						if(nr.x+1 != nb.x){
							nr.x = nr.x + 1;
							check[0] = false;
						}else
							check[0] = true;
						
					}else{
						nr.x = nr.x+1;
						check[0] = false;
					}
					
					
					
				} else
					check[0] = true;

				if (map[nb.x+1][nb.y] == 'O') {
					done[1] = true;
					check[1] = true;
					nb.x = nb.x + 1;
				} else if (map[nb.x+1][nb.y] == '.') {
					
					if(nb.y == nr.y){
						if(nb.x+1 != nr.x){
							nb.x = nb.x + 1;
							check[1] = false;
						}else
							check[1] = true;
						
					}else{
						nb.x = nb.x + 1;
						check[1] = false;
					}
					
					
				} else
					check[1] = true;

			}
			break;

		case left:
			while (!check[0] || !check[1]) {

				if (map[nr.x][nr.y-1] == 'O') {
					done[0] = true;
					check[0] = true;
					nr.y = nr.y-1;
				} else if (map[nr.x][nr.y-1] == '.') {
					
					if(nr.x == nb.x){
						if(nr.y-1 != nb.y){
							nr.y = nr.y - 1;
							check[0] = false;
						}else
							check[0] = true;
						
					}else{
						nr.y = nr.y - 1;
						check[0] = false;
					}
					
					
					
				} else
					check[0] = true;

				if (map[nb.x][nb.y-1] == 'O') {
					done[1] = true;
					check[1] = true;
					nb.y = nb.y - 1;
				} else if (map[nb.x][nb.y-1] == '.') {
					
					if(nb.x == nr.x){
						if(nb.y-1 != nr.y){
							nb.y = nb.y - 1;
							check[1] = false;
						}else
							check[1] = true;
					}else{
						nb.y = nb.y - 1;
						check[1] = false;
					}
					
					
				} else
					check[1] = true;

			}
			break;

		case right:
			while (!check[0] || !check[1]) {

				if (map[nr.x][nr.y+1] == 'O') {
					done[0] = true;
					check[0] = true;
					nr.y = nr.y + 1;
				} else if (map[nr.x][nr.y+1] == '.') {
					
					if(nr.x == nb.x){
						if(nr.y+1 != nb.y){
							nr.y = nr.y + 1;
							check[0] = false;
						}else
							check[0] = true;
					}else{
						nr.y = nr.y + 1;
						check[0] = false;
					}
					
					
				} else
					check[0] = true;

				if (map[nb.x][nb.y+1] == 'O') {
					done[1] = true;
					check[1] = true;
					nb.y = nb.y + 1;
				} else if (map[nb.x][nb.y+1] == '.') {
					
					if(nb.x == nr.x){
						if(nb.y+1 != nr.y){
							nb.y = nb.y + 1;
							check[1] = false;
						}else
							check[1] = true;
					}else{
						nb.y = nb.y + 1;
						check[1] = false;
					}
					
					
				} else
					check[1] = true;

			}
			break;
		case down:
			while (!check[0] || !check[1]) {

				if (map[nr.x-1][nr.y] == 'O') {
					done[0] = true;
					check[0] = true;
					nr.x = nr.x - 1;
				} else if (map[nr.x-1][nr.y] == '.') {
					
					if(nr.y == nb.y){
						if(nr.x-1 != nb.x){
							nr.x = nr.x - 1;
							check[0] = false;
						}else
							check[0] = true;
					}else{
						nr.x = nr.x - 1;
						check[0] = false;
					}
					
					
				} else
					check[0] = true;

				if (map[nb.x-1][nb.y] == 'O') {
					done[1] = true;
					check[1] = true;
					nb.x = nb.x - 1;
				} else if (map[nb.x-1][nb.y] == '.') {
					
					if(nb.y == nr.y){
						if(nb.x-1 != nr.x){
							nb.x = nb.x - 1;
							check[1] = false;
						}else
							check[1] = true;
						
					}else{
						nb.x = nb.x - 1;
						check[1] = false;
					}
					
					
				} else
					check[1] = true;

			}
			break;
		}
		
		if(dir!=0)
			trial++;
		
		
			
		

		
		if(done[1]) return 0;
		if(done[0]){
			arr[trial] = 1;
			return 0;
		}
		
		if(dir!=up) go(trial, up, arr, map, nr, nb);
		if(dir!=left)go(trial, left, arr, map, nr, nb);
		if(dir!=right)go(trial, right, arr, map, nr, nb);
		if(dir!=down)go(trial, down, arr, map, nr, nb);

		return 0;
	}

	static class Point {
		int x;
		int y;

		public Point() {
			this.x = 0;
			this.y = 0;
		}

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

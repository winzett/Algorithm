import java.util.Scanner;

public class Main {

	static final int east = 1;
	static final int west = 2;
	static final int north = 3;
	static final int south = 4;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int x = sc.nextInt();
		int y = sc.nextInt();

		int k = sc.nextInt();
		int[] command = new int[k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++)
			command[i] = sc.nextInt();

		Dice d = new Dice();
		Point now = new Point(x, y);
		int[] val = new int[2];

		int work = 0;
		for (int i = 0; i < k; i++) {

			switch (command[i]) {
			case east:
				if (now.y + 1 < m) {
					now.y += 1;
					val = d.set_and_show(map[now.x][now.y], east);
					work = 1;
				}
				break;
			case west:
				if (now.y - 1 >= 0) {
					now.y -= 1;
					val = d.set_and_show(map[now.x][now.y], west);
					work = 1;
				}
				break;
			case north:
				if (now.x - 1 >= 0) {
					now.x -= 1;
					val = d.set_and_show(map[now.x][now.y], north);
					work = 1;
				}
				break;
			case south:
				if (now.x + 1 < n) {
					now.x += 1;
					val = d.set_and_show(map[now.x][now.y], south);
					work = 1;
				}
				break;
			}
			if (work == 1) {

				if (val[1] != -1)// 바닥면이 0인경우
					map[now.x][now.y] = val[1];
				else
					// 0이아닌경우
					map[now.x][now.y] = 0;

				work = 0;
				System.out.println(val[0]);
			}
		}

	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Dice {

		int m[] = new int[6];
		int pre = 0;
		int state = 0;// 바닥
		int news[][] = new int[6][5];
		int pair[] = new int[6];

		public Dice() {

			state = 5;

			news[0][east] = 2;
			news[0][west] = 3;
			news[0][north] = 1;
			news[0][south] = 4;

			news[1][east] = 2;
			news[1][west] = 3;
			news[1][north] = 5;
			news[1][south] = 0;

			news[2][east] = 5;
			news[2][west] = 0;
			news[2][north] = 1;
			news[2][south] = 4;

			news[3][east] = 0;
			news[3][west] = 5;
			news[3][north] = 1;
			news[3][south] = 4;

			news[4][east] = 2;
			news[4][west] = 3;
			news[4][north] = 0;
			news[4][south] = 5;

			news[5][east] = 2;
			news[5][west] = 3;
			news[5][north] = 4;
			news[5][south] = 1;

			pair[0] = 5;
			pair[1] = 4;
			pair[2] = 3;
			pair[3] = 2;
			pair[4] = 1;
			pair[5] = 0;

		}

		public void set_news(int cmd) {

			int tmp = 0;
			int tmp2 = 0;

			if (cmd == east)
				tmp2 = west;
			else if (cmd == west)
				tmp2 = east;
			else if (cmd == north)
				tmp2 = south;
			else if (cmd == south)
				tmp2 = north;

			while (news[state][tmp2] != pre) {
				tmp = news[state][west];
				news[state][west] = news[state][north];
				news[state][north] = news[state][east];
				news[state][east] = news[state][south];
				news[state][south] = tmp;
			}

		}

		public int[] set_and_show(int input, int cmd) {

			int[] return_val = new int[2];

			pre = state;

			if (cmd == east) {
				state = news[state][east];
			} else if (cmd == west) {
				state = news[state][west];
			} else if (cmd == north) {
				state = news[state][north];
			} else if (cmd == south) {
				state = news[state][south];
			}

			set_news(cmd);

			if (input == 0) {
				return_val[1] = m[state];
				// m[state] = 0;
			} else {
				return_val[1] = -1;
				m[state] = input;
			}

			return_val[0] = m[pair[state]];

//			System.out.println("____________________");
//			System.out.println("       " + cmd + "        ");
//			System.out.println("____________________");
//			System.out.println("       " + m[1] + "      ");
//			System.out.println("     " + m[3] + " " + m[0] + " " + m[2]
//					+ "      ");
//			System.out.println("       " + m[4] + "      ");
//			System.out.println("       " + m[5] + "      ");

			return return_val;
		}

	}
}

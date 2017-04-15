import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final int up = 0;
	static final int left = 1;
	static final int right = 2;
	static final int down = 3;
	static final int back = 4;
	static final int front = 5;

	static final int white = 100;
	static final int red = 101;
	static final int green = 102;
	static final int blue = 103;
	static final int orange = 104;
	static final int yellow = 105;

	static final int plus = 200;
	static final int minus = 201;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][][] cube = new int[6][4][4];
		int[] cube_center = new int[6];
		int n = sc.nextInt();
		ArrayList<Command> cmd = new ArrayList<Command>();		
		int w = 0;

		init(cube);

		
		cube_center[up] = white;
		cube_center[down] = yellow;
		cube_center[front] = red;
		cube_center[left] = green;
		cube_center[right] = blue;
		cube_center[back] = orange;
		
		for (int l1 = 0; l1 < n; l1++) {
			w = sc.nextInt();
			init(cube);
			cmd = new ArrayList<Command>();
			for (int l2 = 0; l2 < w; l2++) {
				String input = sc.next();
				cmd.add(new Command(input.charAt(0),input.charAt(1)));
			}
			init(cube);
			for(int l2 = 0 ; l2 < cmd.size() ; l2 ++){
				
				move(cmd.get(l2),cube);
				
//				for(int l3 = 0 ; l3 < 3 ; l3 ++){
//					printer(cube[front][up][l3]);
//				}
//				System.out.println();
//				
//				printer(cube[front][left][1]);
//				printer(cube_center[front]);
//				printer(cube[front][right][1]);
//				
//				System.out.println();
//				for(int l3 = 2 ; l3 >= 0 ; l3 --){
//					printer(cube[front][down][l3]);
//				}
//				System.out.println();
			}
			
			
			for(int l2 = 0 ; l2 < 3 ; l2 ++){
				printer(cube[up][up][l2]);
			}
			System.out.println();
			
			printer(cube[up][left][1]);
			printer(cube_center[up]);
			printer(cube[up][right][1]);
			
			System.out.println();
			for(int l2 = 2 ; l2 >= 0 ; l2 --){
				printer(cube[up][down][l2]);
			}
			
			
			
			System.out.println();
		}
	}
	static void printer(int val){
		switch(val){
		case red: System.out.print("r");
			break;
		case white:System.out.print("w");
			break;
		case blue:System.out.print("b");
			break;
		case yellow:System.out.print("y");
			break;
		case orange:System.out.print("o");
			break;
		case green:System.out.print("g");
			break;
		}
	}
	
	static void init(int[][][] cube) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					switch (i) {
					case up:
						cube[up][j][k] = white;
						break;
					case left:
						cube[left][j][k] = green;
						break;
					case right:
						cube[right][j][k] = blue;
						break;
					case down:
						cube[down][j][k] = yellow;
						break;
					case front:
						cube[front][j][k] = red;
						break;
					case back:
						cube[back][j][k] = orange;
						break;
					}
				}
			}
		}
		
	}

	static void move(Command cmd, int[][][] cube) {
		switch (cmd.p) {
		case front:
			if (cmd.dir == plus) {
				int temp[] = cube[front][up];
				cube[front][up] = cube[front][left];
				cube[front][left] = cube[front][down];
				cube[front][down] = cube[front][right];
				cube[front][right] = temp;

				temp = cube[up][down];
				cube[up][down] = cube[left][right];
				cube[up][left][0] = cube[left][right][2];
				cube[up][right][2] = cube[left][right][0];
				
				cube[left][right] = cube[down][up];
				cube[left][up][2] = cube[down][up][0];
				cube[left][down][0] = cube[down][up][2];
								
				cube[down][up] = cube[right][left];
				cube[down][left][2] = cube[right][left][0];
				cube[down][right][0] = cube[right][left][2];
				
				cube[right][left] = temp;
				cube[right][up][0] = temp[2];
				cube[right][down][2] = temp[0];
				
				
			}else{
				int temp[] = cube[front][up];
				cube[front][up] = cube[front][right];
				cube[front][right] = cube[front][down];
				cube[front][down] = cube[front][left];
				cube[front][left] = temp;

				temp = cube[up][down];
				cube[up][down] = cube[right][left];
				cube[up][left][0] = cube[right][left][2];
				cube[up][right][2] = cube[right][left][0];
				
				cube[right][left] = cube[down][up];
				cube[right][up][0] = cube[down][up][2];
				cube[right][down][2] = cube[down][up][0];
				
				cube[down][up] = cube[left][right];
				cube[down][left][2] = cube[left][right][0];
				cube[down][right][0] = cube[left][right][2];
				
				cube[left][right] = temp;
				cube[left][up][2] = temp[0];
				cube[left][down][0] = temp[2];
			}
			
			break;
		case back://뒷면을 정면에서 봤을 때 방향으로
			if (cmd.dir == plus) {
				int temp[] = cube[back][up];
				cube[back][up] = cube[back][left];
				cube[back][left] = cube[back][down];
				cube[back][down] = cube[back][right];
				cube[back][right] = temp;
				
				temp = cube[up][up];
				cube[up][up] = cube[right][right];
				cube[up][left][2] = cube[right][right][0];
				cube[up][right][0] = cube[right][right][2];
				
				cube[right][right] = cube[down][down];
				cube[right][up][2] = cube[down][down][0];
				cube[right][down][0] = cube[down][down][2];
				
				cube[down][down] = cube[left][left];
				cube[down][left][0] = cube[left][left][2];
				cube[down][right][2] = cube[left][left][0];
				
				cube[left][left] = temp;
				cube[left][up][0] = temp[2];
				cube[left][down][2] = temp[0];
				
			}else{
				int temp[] = cube[back][up];
				cube[back][up] = cube[back][right];
				cube[back][right] = cube[back][down];
				cube[back][down] = cube[back][left];
				cube[back][left] = temp;

				
				
				temp = cube[up][up];
				cube[up][up] = cube[left][left];
				cube[up][left][2] = cube[left][left][0];
				cube[up][right][0] = cube[left][left][2];
				
				cube[left][left] = cube[down][down];
				cube[left][up][0] = cube[down][down][2];
				cube[left][down][2] = cube[down][down][0];
				
				cube[down][down] = cube[right][right];
				cube[down][left][0] = cube[right][right][2];
				cube[down][right][2] = cube[right][right][0];
				
				cube[right][right] = temp;
				cube[right][up][2] = temp[0];
				cube[right][down][0] = temp[2];
				
			}
			break;
		case up:
			if (cmd.dir == plus) {
				int temp[] = cube[up][up];
				cube[up][up] = cube[up][left];
				cube[up][left] = cube[up][down];
				cube[up][down] = cube[up][right];
				cube[up][right] = temp;
				
				temp = cube[back][up];
				cube[back][up] = cube[left][up];
				cube[back][left][2] = cube[left][up][0];
				cube[back][right][0] = cube[left][up][2];
				
				cube[left][up] = cube[front][up];
				cube[left][left][2] = cube[front][up][0];
				cube[left][right][0] = cube[front][up][2];
				
				cube[front][up] = cube[right][up];
				cube[front][left][2] = cube[right][up][0];
				cube[front][right][0] = cube[right][up][2];
				
				cube[right][up] = temp;
				cube[right][left][2] = temp[0];
				cube[right][right][0] = temp[2];
				
			}else{
				int temp[] = cube[up][up];
				cube[up][up] = cube[up][right];
				cube[up][right] = cube[up][down];
				cube[up][down] = cube[up][left];
				cube[up][left] = temp;

				temp = cube[back][up];
				cube[back][up] = cube[right][up];
				cube[back][left][2] = cube[right][up][0];
				cube[back][right][0] = cube[right][up][2];
				
				cube[right][up] = cube[front][up];
				cube[right][left][2] = cube[front][up][0];
				cube[right][right][0] = cube[front][up][2];
				
				cube[front][up] = cube[left][up];
				cube[front][left][2] = cube[left][up][0];
				cube[front][right][0] = cube[left][up][2];
				
				cube[left][up] = temp;
				cube[left][left][2] = temp[0];
				cube[left][right][0] = temp[2];
			}
			break;
		case down:
			if (cmd.dir == plus) {
				int temp[] = cube[down][up];
				cube[down][up] = cube[down][left];
				cube[down][left] = cube[down][down];
				cube[down][down] = cube[down][right];
				cube[down][right] = temp;
				
				temp = cube[front][down];
				cube[front][down] = cube[left][down];
				cube[front][left][0] = cube[left][down][2];
				cube[front][right][2] = cube[left][down][0];
				
				cube[left][down] = cube[back][down];
				cube[left][left][0] = cube[back][down][2];
				cube[left][right][2] = cube[back][down][0];
				
				cube[back][down] = cube[right][down];
				cube[back][left][0] = cube[right][down][2];
				cube[back][right][2] = cube[right][down][0];
				
				cube[right][down] = temp;
				cube[right][left][0] = temp[2];
				cube[right][right][2] = temp[0];
				
				
			}else{
				int temp[] = cube[down][up];
				cube[down][up] = cube[down][right];
				cube[down][right] = cube[down][down];
				cube[down][down] = cube[down][left];
				cube[down][left] = temp;

				temp = cube[front][down];
				cube[front][down] = cube[right][down];
				cube[front][left][0] = cube[right][down][2];
				cube[front][right][2] = cube[right][down][0];
				
				cube[right][down] = cube[back][down];
				cube[right][left][0] = cube[back][down][2];
				cube[right][right][2] = cube[back][down][0];
				
				cube[back][down] = cube[left][down];
				cube[back][left][0] = cube[left][down][2];
				cube[back][right][2] = cube[left][down][0];
				
				cube[left][down] = temp;
				cube[left][left][0] = temp[2];
				cube[left][right][2] = temp[0];
				
			}
			break;
		case left:
			if (cmd.dir == plus) {
				int temp[] = cube[left][up];
				cube[left][up] = cube[left][left];
				cube[left][left] = cube[left][down];
				cube[left][down] = cube[left][right];
				cube[left][right] = temp;
				
				temp = cube[up][left];
				cube[up][left] = cube[back][right];
				cube[up][up][0] = cube[back][right][2];
				cube[up][down][2] = cube[back][right][0];
				
				cube[back][right] = cube[down][left];
				cube[back][up][2] = cube[down][left][0];
				cube[back][down][0] = cube[down][left][2];
						
				cube[down][left] = cube[front][left];
				cube[down][up][0] = cube[front][left][2];
				cube[down][down][2] = cube[front][left][0];
				
				cube[front][left] = temp;
				cube[front][up][0] = temp[2];
				cube[front][down][2] = temp[0];
				
			}else{
				int temp[] = cube[left][up];
				cube[left][up] = cube[left][right];
				cube[left][right] = cube[left][down];
				cube[left][down] = cube[left][left];
				cube[left][left] = temp;

				temp = cube[up][left];
				cube[up][left] = cube[front][left];
				cube[up][up][0] = cube[front][left][2];
				cube[up][down][2] = cube[front][left][0];
				
				cube[front][left] = cube[down][left];
				cube[front][up][0] = cube[down][left][2];
				cube[front][down][2] = cube[down][left][0];
				
				cube[down][left] = cube[back][right];
				cube[down][up][0] = cube[back][right][2];
				cube[down][down][2] = cube[back][right][0];
				
				cube[back][right] = temp;
				cube[back][up][2] = temp[0];
				cube[back][down][0] = temp[2];
			}
			break;
		case right:
			if (cmd.dir == plus) {
				int temp[] = cube[right][up];
				cube[right][up] = cube[right][left];
				cube[right][left] = cube[right][down];
				cube[right][down] = cube[right][right];
				cube[right][right] = temp;
				
				temp = cube[up][right];
				cube[up][right] = cube[front][right];
				cube[up][up][2] = cube[front][right][0];
				cube[up][down][0] = cube[front][right][2];
				
				cube[front][right] = cube[down][right];
				cube[front][up][2] = cube[down][right][0];
				cube[front][down][0] = cube[down][right][2];
				
				cube[down][right] = cube[back][left];
				cube[down][up][2] = cube[back][left][0];
				cube[down][down][0] = cube[back][left][2];
				
				cube[back][left] = temp;
				cube[back][up][0] = temp[2];
				cube[back][down][2] = temp[0];
				
			}else{
				int temp[] = cube[right][up];
				cube[right][up] = cube[right][right];
				cube[right][right] = cube[right][down];
				cube[right][down] = cube[right][left];
				cube[right][left] = temp;

				temp = cube[up][right];
				cube[up][right] = cube[back][left];
				cube[up][up][2] = cube[back][left][0];
				cube[up][down][0] = cube[back][left][2];
				
				cube[back][left] = cube[down][right];
				cube[back][up][0] = cube[down][right][2];
				cube[back][down][2] = cube[down][right][0];
				
				cube[down][right] = cube[front][right];
				cube[down][up][2] = cube[front][right][0];
				cube[down][down][0] = cube[front][right][2];
				
				cube[front][right] = temp;
				cube[front][up][2] = temp[0];
				cube[front][down][0] = temp[2];
			}
			break;
		}
	}

	static class Command {
		int dir = 0;
		int p = 0;

		public Command(char p, char dir) {
			switch (p) {
			case 'F':
				this.p = front;
				break;
			case 'B':
				this.p = back;
				break;
			case 'U':
				this.p = up;
				break;
			case 'D':
				this.p = down;
				break;
			case 'L':
				this.p = left;
				break;
			case 'R':
				this.p = right;
				break;
			}

			switch (dir) {
			case '+':
				this.dir = plus;
				break;
			case '-':
				this.dir = minus;
				break;
			}
		}
	}

}

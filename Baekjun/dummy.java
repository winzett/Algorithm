import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final int up = 1;
	static final int left = 2;
	static final int right = 3;
	static final int down = 4;
	static final int no = 1111;
	static int check = 0;
	static final int apple = 100;
	static final int wall = 101;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<command> cmd = new ArrayList<command>();
		ArrayList<Point> trace = new ArrayList<Point>();
		trace.add(new Point(1,1));
		int state = right;
		int time = 0;
		Point bam = new Point(1,1,state);
		
		int n = sc.nextInt();

		int map[][] = new int[n + 2][n + 2];

		for(int i = 0 ; i < n+2 ; i ++){
			map[0][i] = wall;
			map[i][0] = wall;
			map[i][n+1] = wall;
			map[n+1][i] = wall;
		}
		
		
		
		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			map[sc.nextInt()][sc.nextInt()] = apple;
		}

		int l = sc.nextInt();
		
		
		
		int pre_tmp = 0;
		int tmp = 0;
		for(int i = 0 ; i < l ; i ++){
			pre_tmp = tmp;
			tmp = sc.nextInt();
			
			int val = tmp - pre_tmp;
			
			cmd.add(new command(val, sc.next().charAt(0)));
		}
		int temp = 0;
		
		
		for(int i = 0 ; i < cmd.size() ; i ++){
			temp = move(bam, trace, cmd.get(i), map);
			time += temp;
			
			if(check == 1)
				break;
		}
		cmd.add(new command(n, 'n'));
		
		while(check != 1){
			temp = move(bam, trace, cmd.get(cmd.size()-1), map);
			time += temp;
		}
		System.out.println(time);
		
	}
	
	
	static int move(Point bam,ArrayList<Point> trace, command cmd, int[][] map){
		
		for(int i = 1 ; i <= cmd.time ; i ++){
			
//			System.out.println("_______________________________");
//			
//			for(int j = 0 ; j < 12 ; j ++){
//				for(int m = 0 ; m < 12 ; m ++){
//					if(map[j][m] == apple)
//						System.out.print("@");
//					else if(j ==bam.x && m == bam.y)
//						System.out.print("B");
//					else if(map[j][m] == wall)
//						System.out.print("w");
//					else
//						System.out.print("_");
//				}
//				System.out.println();
//			}
			
			if(bam.state == up)bam.up_state();
			else if(bam.state == left)bam.left_state();
			else if(bam.state == right)bam.right_state();
			else if(bam.state == down)bam.down_state();
			
			if( map[bam.x][bam.y] != wall && !contain(bam,trace))
				push(trace,new Point(bam.x,bam.y));
			else{
				check = 1;
				return i;
			}
			
			if(map[bam.x][bam.y] != apple)
				pop(trace);
			else{
				map[bam.x][bam.y] = 0;
			}
		}
		
		
		bam.state = direction(bam.state, cmd.dir);
		check = 0;
		return cmd.time;
	}
	static boolean contain(Point p, ArrayList<Point> t){
		for(int i = 0 ; i < t.size() ; i ++){
			if(p.x == t.get(i).x && p.y == t.get(i).y)
				return true;
		}
		
		return false;
	}
	
	static int direction(int state, int dir){
		int rdir = dir;
		
		switch(state){
		case up:
			rdir = dir;
			break;
		case left:
			if(dir == left)
				rdir = down;
			else
				rdir = up;
			break;
		case right:
			if(dir == left)
				rdir = up;
			else
				rdir = down;
			break;
		case down:
			if(dir == left)
				rdir = right;
			else
				rdir = left;
			break;
		}
		
		
		return rdir;
	}
	static void pop(ArrayList<Point> arr){
		arr.remove(0);
	}
	static void push(ArrayList<Point> arr, Point p){
		arr.add(p);
	}

	static class Point{
		
		int x = 0;
		int y = 0;
		int state = 0;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y, int state){
			this.x = x;
			this.y = y;
			this.state = state;
		}
		
		public void up_state(){
			this.x -=1;
		}
		public void down_state(){
			this.x +=1;
		}
		public void right_state(){
			this.y +=1;
		}
		public void left_state(){
			this.y -=1;
		}
	}
	static class command{
		int time = 0;
		int dir = ' ';
		public command(int time, char dir){
			this.time = time;
			if(dir == 'L')
				this.dir = left;
			else if(dir == 'D')
				this.dir = right;
			else
				this.dir = no;
		}
	}
}

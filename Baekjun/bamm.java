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
		BigInteger survival_time = new BigInteger("0");
		boolean die = false;
		BigInteger t;
		char dir_input;
		int dir = 0;
		int state = 0;
		
		BigInteger l = sc.nextBigInteger();
		BigInteger Max = l.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("0");
		
		
		int n = sc.nextInt();
		
		Point now = new Point(l.add(BigInteger.ONE),l.add(BigInteger.ONE));
		
		ArrayList<Point> trace = new ArrayList<Point>();
		ArrayList<Command> command_list = new ArrayList<Command>();		
	
		
		for(int i = 0 ; i < n ; i ++){
			t = sc.nextBigInteger(); 
			dir_input = sc.next().charAt(0);
			
			if(dir_input == 'L') dir = left;
			else if(dir_input == 'R') dir = right;
			
			command_list.add(new Command(t,dir));
		}
		
		state = right;
		
		do{
			if(now.x.compareTo(Max)==1 || now.y.compareTo(Max) == 1 
					|| now.x.compareTo(BigInteger.ZERO) == -1 || now.y.compareTo(BigInteger.ZERO) == -1){ 
				die=true; 
//				System.out.println("틀밖");
			}
			
			boolean check = false;
			
			for(Point p : trace)
				if(p.x.equals(now.x) && p.y.equals(now.y))
					check = true;
					
			
			
			if(check){
				die = true;
//					System.out.println("몸 밟음");// 없을 때 콜할 수 도 있음 수정 요망
			}else trace.add(now);
			
//			System.out.println("x : "+trace.get(trace.size()-1).x+" y : "+trace.get(trace.size()-1).y); 
			
			if(command_list.get(0).t.compareTo(BigInteger.ZERO) == 0){	
				state = Direction(state, command_list.get(0).dir);
				command_list.remove(0);
//				System.out.println("state up(1), left(2), right(3), down(4) : "+state);
			}

			
			if(command_list.size() == 0){ 
				die = true;
//				System.out.println("커멘드 모두 수행");
			}
			else{

				x = trace.get(trace.size()-1).x;
				y = trace.get(trace.size()-1).y;
								
				switch(state)
				{
				case up :
					y = y.add(BigInteger.ONE);
					break;
				case left :
					x = x.subtract(BigInteger.ONE);
					break;
				case right :
					x = x.add(BigInteger.ONE);
					break;
				case down :
					y = y.subtract(BigInteger.ONE);
					break;
				}
				now = new Point(x,y);
				
				
				command_list.get(0).t = command_list.get(0).t.subtract(BigInteger.ONE);
			}
			survival_time = survival_time.add(BigInteger.ONE);
			
			
//			System.out.println(command_list.get(0).t);
			
			
		}while(!die);
		
		System.out.println(survival_time.subtract(BigInteger.ONE));
	}
	
	public static int Direction(int state, int dir){
		
		switch(state){
		
		case up:
			return dir;
		
		case left:
			if(dir == left) return down;
			if(dir == right)return up;
		
		case right:
			if(dir == left) return up;
			if(dir == right)return down;
		
		case down :
			if(dir == left) return right;
			if(dir == right)return left;
		
		default:
			return 0;
		}
		
		
	}
	
	static class Point{
		BigInteger x;
		BigInteger y;
		
		public Point(BigInteger x, BigInteger y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Command{
		BigInteger t;
		int dir;
		
		public Command(BigInteger t, int dir){
			this.t = t;
			this.dir = dir;
		}
	}

}

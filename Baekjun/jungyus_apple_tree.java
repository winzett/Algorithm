import java.util.Scanner;

public class Main {

	static final int up = 1;
	static final int left = 2;
	static final int right = 3;
	static final int down = 4;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int x,y;
		int map[][] = new int [6][6];
		Point g = new Point(1,1);
		Point h = new Point(5,5);
		//0 tree, 1 no tree

		for(int i = 0 ; i < k ; i ++){
			x = sc.nextInt();
			y = sc.nextInt();
			map[x][y] = 1;
		}
		map[1][1] = 1;
		map[5][5] = 1;
		
		for(int i = 0 ; i < 6 ; i ++)
			map[0][i] = 1;
		
		for(int i = 0 ; i < 6 ; i ++)
			map[i][0] = 1;
		
		
		System.out.println(go(g,h,map));
		
	}
	static int go(Point gc, Point hc, int[][]map){
		
		
		int[][] copy = new int [6][6];
		int  count = 0;
		//이미 이동한 상태
		Point g = new Point(gc.x, gc.y);
		Point h = new Point(hc.x, hc.y);
		
		if(g.compare(h)&&tree_check(map))
			return 1;
		
		if(g.compare(h))
			return 0;
		if(tree_check(map))
			return 0;
		
		for(int i = 1 ; i < 6 ; i ++)
			for(int j = 1 ; j < 6 ; j ++)
				copy[i][j] = map[i][j];
		
		boolean gup = false;
		boolean gleft = false;
		boolean gright = false;
		boolean gdown = false;
		boolean hup = false;
		boolean hleft = false;
		boolean hright = false;
		boolean hdown = false;
		
		if(g.x+1 < 6 && copy[g.x+1][g.y] == 0)
			gup = true;

		if(g.x-1 > 0 && copy[g.x-1][g.y] == 0)
			gdown = true;
		
		if(h.x+1 < 6 && copy[h.x+1][h.y] == 0)
			hup = true;

		if(h.x-1 > 0 && copy[h.x-1][h.y] == 0)
			hdown = true;
		
	
		if(g.y+1 < 6 && copy[g.x][g.y+1] == 0)
			gright = true;

		if(g.y-1 > 0 && copy[g.x][g.y-1] == 0)
			gleft = true;
		
		if(h.y+1 < 6 && copy[h.x][h.y+1] == 0)
			hright = true;

		if(h.y-1 > 0 && copy[h.x][h.y-1] == 0)
			hleft = true;

		if(!gup&&!gdown&&!gleft&&!gright)
			return 0;
		if(!hup&&!hdown&&!hleft&&!hright)
			return 0;
		
		
		if(gup&&hup){
			g.x +=1;
			h.x +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gup&&hdown){
			g.x +=1;
			h.x -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gup&&hright){
			g.x +=1;
			h.y +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gup&&hleft){
			g.x +=1;
			h.y -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		////////////////////////////////////////////////
		if(gdown&&hup){
			g.x -=1;
			h.x +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		
		if(gdown&&hdown){
			g.x -=1;
			h.x -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gdown&&hright){
			g.x -=1;
			h.y +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gdown&&hleft){
			g.x -=1;
			h.y -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		
		/////////////////////////////////////////
		if(gleft&&hup){
			g.y -=1;
			h.x +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		
		if(gleft&&hdown){
			g.y -=1;
			h.x -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gleft&&hright){
			g.y -=1;
			h.y +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gleft&&hleft){
			g.y -=1;
			h.y -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		///////////////////////////////////////////////////
	
		if(gright&&hup){
			g.y +=1;
			h.x +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gright&&hdown){
			g.y +=1;
			h.x -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gright&&hright){
			g.y +=1;
			h.y +=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
			g.x = gc.x;
			g.y = gc.y;
			h.x = hc.x;
			h.y = hc.y;
		}
		if(gright&&hleft){
			g.y +=1;
			h.y -=1;
			copy[g.x][g.y] = 1;
			copy[h.x][h.y] = 1;
			count += go(g,h,copy);
			copy[g.x][g.y] = 0;
			copy[h.x][h.y] = 0;
		}
		
		return count;
	}
	
	
	static boolean tree_check(int[][] map){

		for(int i = 1 ; i < 6 ; i++)
			for(int j = 1; j < 6 ; j ++)
				if(map[i][j] == 0)
					return false;

		return true;
	}
	
	static class Point{
		int x = 0 ;
		int y = 0 ;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public boolean compare(Point o){
			if(this.x == o.x && this.y == o.y)
				return true;
			else
				return false;
		}
	}
}

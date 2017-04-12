import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.math.BigInteger;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
        
			int n = sc.nextInt();
			int m = sc.nextInt();
//			int[] x = new int[100000];
			int[] arr = new int[n];
			BigInteger sum = new BigInteger("0");
			int[] dx;
			
			for(int i = 0 ; i < n; i ++){
				arr[i] = sc.nextInt();
//				x[arr[i]] = 1;
			}
			Arrays.sort(arr);
			//그룹을 m개로 나누는게 중요
			
			if(m>1 && m!=n){
				
				dx= new int[n-1];

				for(int i = 0 ; i <  arr.length-1 ; i ++){
					dx[i] = distance(arr[i],arr[i+1]);
				}
				
				int cp[] = new int[n-1];
				
				for(int i = 0 ; i < n-1 ; i ++){
					cp[i] = dx[i];
				}
				
				Arrays.sort(cp);
				
				int[] px;
//				int len = 0;
				
				
				px = new int[m+1];
//				len = m-1;
				
				
				for(int i = cp.length-m+1; i < cp.length ; i++){
					for(int j = 0 ; j < n-1 ; j ++){
						if(cp[i] == dx[j]){
							cp[i] = -1;
							dx[j] = -1;
							px[i-cp.length+m] = j;
							break;
						}
					}
				}
				px[0] = 0;
				px[m] = arr.length-1;
				//px에 있는 점 까지 한블럭 
				
				for(int i = 0 ; i < px.length-1 ; i++){
					sum = sum.add(get_sum(i,px[i],px[i+1],arr));
				}
				
//1
//5 5
//2 5 9 20 800
//1
//5 5
//2 5 7 9 800
//1
//5 3
//2 4 6 8 10
//1
//5 3
//2 5 7 9 800
			}else if (m == 1){
				sum = get_sum(0,0,n-1,arr);
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sum);
		}
	}

	public static int distance(int x1, int x2){
		return Math.abs(x1-x2);
	}

	public static BigInteger get_sum(int count, int sp, int ep, int[] arr){
		BigInteger min = new BigInteger("0");
		BigInteger sum = new BigInteger("0");
		int temp = arr[sp];
		
		if(count != 0)
			sp ++;
		if(ep-sp == 1)
			return BigInteger.valueOf(arr[ep]-arr[sp]);
		if(ep == sp)
			return BigInteger.ZERO;
		
		for(int i = temp; i <= arr[ep] ; i++){/////////////////////////////////////////////////////////////여길고치자
			sum = BigInteger.ZERO;
			for(int j = sp; j <= ep ; j++){
				sum  = sum.add(BigInteger.valueOf(distance(i,arr[j])));
			}
			if(!min.equals(BigInteger.ZERO))
				min = min.compareTo(sum) == -1 ? min:sum;
			else min = sum;
		}
		
		return min;
	}
}
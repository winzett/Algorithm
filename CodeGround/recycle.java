import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.math.BigInteger;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class Solution {
	public static void main(String args[]) throws Exception	{
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� sample_input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� sample_input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� sample_input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
        
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
			//�׷��� m���� �����°� �߿�
			
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
				//px�� �ִ� �� ���� �Ѻ� 
				
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

			// �� �κп��� ������ ����Ͻʽÿ�.
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
		
		for(int i = temp; i <= arr[ep] ; i++){/////////////////////////////////////////////////////////////�����ġ��
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
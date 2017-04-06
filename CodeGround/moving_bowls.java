import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.math.BigInteger;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
 �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� sample_input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		 * ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� sample_input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		 * ǥ���Է� ��� sample_input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ����, ���� PC���� �Ʒ� �޼ҵ带
		 * ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�. ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ��
		 * �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�.
		 */
		// Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		int n = 0;// Ÿ������
		int h = 0;// ���ð���
		int s = 0;// ����ũ��
		long th = 0;//��ü���ð���

		int arr[][];
		ArrayList<Integer> numlist;
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ�
			// �˴ϴ�.
			
			numlist = new ArrayList<Integer>();
			n = sc.nextInt();
			arr = new int[n+1][10001];
			th = 0;
			
			for (int i = 1; i <= n; i++) {
				
				h = sc.nextInt();
				
				for(int j = 1 ; j <= h ; j++){
					
					s = sc.nextInt();
					
					if(arr[i][s]!=1){
						arr[i][s] = 1;
						numlist.add(s);
						th ++;
					}
					
				}
			}
			
			int [] nums = new int[numlist.size()];
			
			for(int i = 0 ; i < numlist.size() ; i++)
				nums[i] = numlist.get(i);
			
			Arrays.sort(nums);
			int [][] backup = new int [n+1][10001];
			
			for(int i = 1 ; i <= n ; i++)
				for(int j = 1 ; j <=10000 ; j ++)
					backup[i][j] = arr[i][j];
				
			
			
			int index=0;
			long counter = 0;
//			boolean checker = false;
			int checker = 0;
			int rp = 0;
			
			for(int j = nums[index]; index < nums.length-1; index ++ ,j = nums[index]){
				
				checker = 0;
				
				for(int i = 1 ; i <= n ; i ++){
					
						
					if(arr[i][j] == 1 && j != nums[index+1] && arr[i][nums[index+1]] == 1){
						
						arr[i][j] = 0;
						arr[i][nums[index+1]] = 0;
						rp = i;
						counter ++;
						break;
						
					}else if(arr[i][j] == 0)
						checker ++;
					else if(arr[i][j] == 1){
						arr[i][j] = 0;
						rp = i;
					}
					
					if(checker == n){
						
//						for(int l = 1 ; l <= n ; l ++)
						arr[rp][nums[index]] = backup[rp][nums[index]];
						
						i = 0;
						checker = 0;
					}
					
				}
				
			}
			
			BigInteger ans = new BigInteger("0");
			ans = ans.add(BigInteger.valueOf(2*(th-counter)-1-n));
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("#testcase" + test_case);
			System.out.println(ans);
		}
	}
}
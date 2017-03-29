import java.util.Scanner;
import java.io.FileInputStream;
import java.math.*;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
 �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. ���� ������
		 * PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�, ǥ���Է� ���
		 * input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է���
		 * ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�. ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų�
		 * �ּ�(//) ó�� �ϼž� �մϴ�.
		 */
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;
		int input = 0;
		int length = 0;
		int min_val = 1;
        BigInteger max_val ;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ�
			// �˴ϴ�.
			input = sc.nextInt();
			min_val = 0;
			
			while (length != input && min_val != Math.pow(2, input)) {
				min_val +=1;
				int start_val = min_val;
				length = 0;
				
				while (start_val != 1) {
					if (start_val % 2 == 0)
						start_val /= 2;
					else
						start_val = 3 * start_val + 1;
					
					length++;
//					System.out.println(min_val+" : "+start_val);
				}

//				
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			if(min_val== 0)
				min_val =1;
			max_val = new BigInteger("1");
			for(int i = 0 ; i < input ; i ++)
				max_val = max_val.multiply(BigInteger.valueOf(2));
            
			System.out.println(min_val+" "+max_val);
		}
	}
}
import java.util.Scanner;
import java.io.FileInputStream;

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
		int input = 0;
		int parr[];
		int qarr[];
		int arr[];
		int sum = 0;
		int state = 0;
		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ�
			// �˴ϴ�.
			input = sc.nextInt();
			parr = new int[input];
			qarr = new int[input];
			arr = new int[input];

			for (int i = 0; i < input; i++)
				parr[i] = sc.nextInt();

			for (int i = 0; i < input; i++)
				qarr[i] = sc.nextInt();

			for (int i = 0; i < input; i++) {

				if (i == 0)
					arr[0] = parr[0] > qarr[0] ? parr[0] : qarr[0];
					
				else if (i == 1) 
					arr[1] = arr[0]+parr[1]>qarr[1]?arr[0]+parr[1]:qarr[1];
					
				else {
					arr[i] = arr[i-1]+parr[i]>arr[i-2]+qarr[i]?arr[i-1]+parr[i]:arr[i-2]+qarr[i];
				}
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(arr[input-1]);
		}
	}
}
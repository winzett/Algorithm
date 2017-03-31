/* �Ʒ� �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
   ��, ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */
import java.util.Arrays;
import java.util.Scanner;

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

		int TC;
		int test_case;
		int p = 0;
		int w=0;
		int[] score;

		TC = sc.nextInt();

		for (test_case = 1; test_case <= TC; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			p = sc.nextInt();
			score = new int[p];
			for (int i = 0; i < p; i++) {
				score[i] = sc.nextInt();
			}

			Arrays.sort(score);
			int temp ;
			for (int i = 0; i < score.length - 1; i++) {
				if (score[i] + score.length >= score[score.length - 1] + 1) {
					temp = 1;
					for (int j = score.length-1; j >= i; j--) {
						if(score[j]+temp <= score[i] + score.length){
							temp++;
							w= j;
						}else
							break;
					}
					if(i == w)
						break;
				} else
					continue;
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(score.length-w);
		}
	}
}
import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
 이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		 * 만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		 * 표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 또한, 본인 PC에서 아래 메소드를
		 * 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다. 단, Codeground 시스템에서 "제출하기" 할 때에는 반드시
		 * 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다.
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
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도
			// 됩니다.
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

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(arr[input-1]);
		}
	}
}
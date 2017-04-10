import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	static int [] p;
	static int [] used;

	public static void main(String args[]) throws Exception	{

        //System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
			int N = sc.nextInt();
			p = new int[N];
			used = new int[N+1];
			nPr(0, N, N);
		}
	}
	public static void nPr(int n, int k, int m)
	{
		if( n == k)
		{
			for(int i =0; i<k; i++)
				System.out.print(p[i]+" ");
			System.out.println();
		}
		else
		{
			for(int i=1; i<=m; i++)
			{
				if(used[i] == 0)
				{
					used[i] = 1;
					p[n] = i;
					nPr(n+1, k, m);
					used[i] = 0;
				}
			}
		}
	}
}

import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	static int V;
	static int E;
	static int [] ch1;
	static int [] ch2;
	static int [] par;
	public static void main(String args[]) throws Exception	{

        System.setIn(new FileInputStream("Tree.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			V = sc.nextInt();
			E = sc.nextInt();
			ch1 = new int[V+1];
			ch2 = new int[V+1];
			par = new int[V+1];
			for(int i = 0 ; i<E; i++)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				if(ch1[n1] == 0)
					ch1[n1] = n2;
				else
					ch2[n1] = n2;
				par[n2] = n1;
			}
			// 5의 조상 출력..
			int c = 5;
			while(par[c] != 0)
			{
				c = par[c];
				System.out.print(c+" ");
			}
			System.out.println();
			// 순회..
			vlr(1);
			System.out.println();
			lvr(1);
			System.out.println();
			lrv(1);
			System.out.println();
		}
	}
	public static void vlr(int n)
	{
		if(n!=0)
		{
			System.out.print(n+" ");
			vlr(ch1[n]);
			vlr(ch2[n]);
		}
	}
	public static void lvr(int n)
	{
		if(n!=0)
		{
			lvr(ch1[n]);
			System.out.print(n+" ");
			lvr(ch2[n]);
		}
	}
	public static void lrv(int n)
	{
		if(n!=0)
		{
			
			lrv(ch1[n]);
			lrv(ch2[n]);
			System.out.print(n+" ");
		}
	}
}
		

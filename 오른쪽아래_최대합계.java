import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int [][] k;
	static int [][] d;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Text.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			k = new int[N+1][M+1];
			d = new int[N+1][M+1];
			for(int i=1; i<=N; i++)
			{
				for(int j=1; j<=M; j++)
				{
					k[i][j] = sc.nextInt();
				}
			}
			find(N, M);
			System.out.println("#"+tc+" "+d[N][M]);
		}
		
		
	}
	public static void find(int n, int m)
	{
		for(int i = 1; i<=n; i++)
		{
			for(int j = 1; j<=m; j++)
			{
				d[i][j] =  ((d[i-1][j]>d[i][j-1])?d[i-1][j]:d[i][j-1]) + k[i][j];
			}
		}
	}

}

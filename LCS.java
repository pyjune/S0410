/*
1
BACFAF
AFDF
 */

import java.util.Scanner;

public class Solution {
	static int [][] d;
	static String X;
	static String Y;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++)
		{
			X = sc.next();
			Y = sc.next();
			System.out.println("#"+tc+" "+lcs(X.length(), Y.length()));
		}

	}
	public static int lcs(int n, int m)
	{
		d = new int[n+1][m+1];
		for(int i = 1; i<=n; i++)
		{
			for(int j = 1; j<=m; j++)
			{
				if(X.charAt(i-1)==Y.charAt(j-1))
					d[i][j] = d[i-1][j-1]+1;
				else
					d[i][j] = d[i-1][j]>d[i][j-1]?d[i-1][j]:d[i][j-1];
			}
		}
		return d[n][m];
	}
}

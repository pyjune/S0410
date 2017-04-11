import java.util.Scanner;

public class Solution {
	static int last;
	static int [] Q;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Q = new int[N+1];
		last = 0;
		for(int i = 0; i<N; i++)
		{
			int d = sc.nextInt();
			enQ(d);
		}
		while(last>0)
		{
			int r = deQ();
			System.out.print(r+" ");
		}
	}
	public static void enQ(int n)
	{
		int c = ++last;
		int p = c / 2;
		Q[c] = n;
		while( Q[p] > Q[c] && c>1 )
		{
			int t = Q[p];
			Q[p] = Q[c];
			Q[c] = t;
			c= p;
			p = p/2;
		}	
	}
	public static int deQ()
	{
		int r = Q[1];
		Q[1] = Q[last];
		last--;
		int p = 1;
		while(p<last)
		{
			int c1 = p * 2;
			int c2 = p * 2 + 1;
			if(c2<=last)
			{
				int c = Q[c1]<Q[c2]?c1:c2;
				if( Q[c] < Q[p] )
				{
					int t = Q[c];
					Q[c] = Q[p];
					Q[p] = t;
					p = c;
				}
				else
					break;
			}
			else if(c1<=last)
			{
				if(Q[c1]<Q[p])
				{
					int t = Q[c1];
					Q[c1] = Q[p];
					Q[p] = t;
					p = c1;
				}
				else
					break;
			}
			else
				break;
		}
		return r;
	}
}

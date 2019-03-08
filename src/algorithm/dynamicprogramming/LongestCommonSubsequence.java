package algorithm.dynamicprogramming;

public class LongestCommonSubsequence {
	
	public int findLCS(String a, String b) {
		
		int n = a.length();
		int m = b.length();
		
		char[] aArray= a.toCharArray();
		char[] bArray= b.toCharArray();
		
		int[][] dp = new int[n][m];
		
		for(int i=0;i<n;i++) { // check first column
			if(aArray[i]==bArray[0]) {
				dp[i][0]=1;
				for(int j=i+1;j<n;j++) {
					dp[j][0]=1;
				}
				break;
			}
		}
		for(int i=0;i<m;i++) { // check first row
			if(aArray[0]== bArray[i]) {
				dp[0][i]=1;
				for(int j=i+1;j<m;j++) {
					dp[0][j]=1;
				}
				break;
			}
		}
		
		for(int i=1;i<n;i++) { 
			for(int j=1;j<m;j++) { 
				if(aArray[i] == bArray[j]) {
					dp[i][j]= dp[i-1][j-1]+1;
				}else {
					dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
				}		
			}		
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(dp[i][j]+"  ");
			}
			System.out.println();
		}
		
		return dp[n-1][m-1];
	}
	

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String a="android";
		String b="random";
		int l= lcs.findLCS(a, b);
		System.out.println("The Longest Common Subsequence is:"+l);
	}

}

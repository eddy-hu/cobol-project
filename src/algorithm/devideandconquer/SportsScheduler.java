package algorithm.devideandconquer;

public class SportsScheduler {
	
	public void scheduleTable(int[][] table,int n) {
		if(n==1) {
			table[0][0]=1;
		}else {
			//schedule the top left
			int m =n/2;
			scheduleTable(table,m);
			//schedule the top right
			for(int i=0;i<m;i++) {
				for(int j =m;j<n;j++) {
					
				}
			}
			
			//schedule the bottom left
			
			//schedule the bottom right
			
		}
		
		
	}

	public static void main(String[] args) {
		

	}

}

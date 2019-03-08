package algorithm.backtracking;

public class EightQueens {

	public static int num =0;
	public static final int QUEEN_NUM =8;
	public static int[] cols = new int[QUEEN_NUM];//queens' index
	
	/**
	 * 
	 * @param n column number of queen
	 */
	public void getCount(int n) {
		boolean[] rows = new boolean[QUEEN_NUM];//true means there is a queen
		for(int i =0; i<n;i++) {
			rows[cols[i]] = true;
			int d = n-i;//diagonal
			//right diagonal
			if(cols[i]-d>0) {
				rows[cols[i]-d] =true;
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

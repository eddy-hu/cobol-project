package algorithm.recursion;

public class TowerOfHanoi {
	    private int i;
		public void hanoi(int n, char from ,char dependOn,char to) {
			if(n==1) {
				move(1,from,to);
			}else {
				hanoi(n-1,from,to,dependOn);//moves n-1 plates uses C from A to B;
				move(n,from,to);//moves N(last one) from A to C;
				hanoi(n-1,dependOn,from,to); //moves n-1 plates uses A from B to C;
			}
		}

	private void move(int n, char from, char to) {
		
			System.out.println("Step "+(i++)+" moved from "+from+" to "+to);
		}

	public static void main(String[] args) {
	
		TowerOfHanoi th = new TowerOfHanoi();
		th.hanoi(9, 'A', 'B', 'C');
	}

}

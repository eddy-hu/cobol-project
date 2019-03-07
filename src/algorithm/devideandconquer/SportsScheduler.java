package algorithm.devideandconquer;

public class SportsScheduler {

	public void scheduleTable(int[][] table, int n) {
		if (n == 1) {
			table[0][0] = 1;
		} else {
			// schedule the top left
			int m = n / 2;
			scheduleTable(table, m);
			// schedule the top right
			for (int i = 0; i < m; i++) {
				for (int j = m; j < n; j++) {
					table[i][j] = table[i][j - m] + m;

				}
			}

			// schedule the bottom left
			for (int i = m; i < n; i++) {
				for (int j = 0; j < m; j++) {
					table[i][j] = table[i - m][j] + m;

				}
			}
			// schedule the bottom right
			for (int i = m; i < n; i++) {
				for (int j = m; j < n; j++) {
					table[i][j] = table[i - m][j - m];

				}
			}
		}

	}

	public static void main(String[] args) {
		int teamNum = 16;
		int[][] teamTable = new int[teamNum][teamNum];
		
		SportsScheduler scheduler = new SportsScheduler();
		scheduler.scheduleTable(teamTable, teamNum);
		for (int i = 0; i < teamNum; i++) {
			for (int j = 0; j < teamNum; j++) {
				System.out.print(teamTable[i][j] + " ");
			}
			System.out.println();
		}

	}

}

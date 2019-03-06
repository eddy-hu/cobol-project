package algorithm.greedy;

import java.util.Arrays;

public class GreedyBag {
	
	private void greedyBag(int capacity, int[] weights,int[] values) {
		int length = weights.length;
		double[] highValue =new double[length];
		int[] index = new int[length];// sorted high value index
		for(int i=0; i<length;i++) {
			highValue[i] = (double)values[i]/(double)weights[i];
			index[i]=i;
		}
		double temp = 0;
		for(int i =0;i<length-1;i++) {
			for(int j=i+1;j<length;j++) {
				if(highValue[i]<highValue[j]) {
					temp = highValue[i];
					highValue[i]=highValue[j];
					highValue[j]=temp;
					int x = index[i];
					index[i]=index[j];
					index[j]=x;
				}
			}
		}
		// records sorted weights and values;
		int[] w1 = new int[length];
		int[] v1 = new int[length];
		for(int i=0;i<length;i++) {
			w1[i]=weights[index[i]];
			v1[i]=values[index[i]];
		}
		
		int[] x = new int[length];
		int totalValue =0;
		for(int i=0;i<length;i++) {
			if(w1[i]<=capacity) {//means bag still has space
				x[i]=1;// means this item has been added to the bag
				totalValue+=v1[i];
				System.out.println("Item:"+w1[i]+" has been added to the bag");
				capacity-=w1[i];
			}
		}
		
		System.out.println("Items added to the bag:"+Arrays.toString(x));
		System.out.println("The max total value is:"+totalValue);
		
		
	}

	public static void main(String[] args) {
		int MAX_WEIGHT =150;
		int[] weights = new int[] {35,30,60,50,40,10,25};
		int[] values = new int[] {10,40,30,50,35,40,30};
		GreedyBag greedyBag= new GreedyBag();
		greedyBag.greedyBag(MAX_WEIGHT, weights, values);
		

	}

}

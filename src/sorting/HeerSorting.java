package sorting;

public class HeerSorting {

	public static void main(String[] args) {
		sort(new int[] {3,56,2,46,74,23,745,5,4,0,66});

	}
	
	private static void sort(int[] arr) {
		
		int d= arr.length/2;
		while(true) {
			for(int i=0;i<d;i++) {
				for(int j=i;j+d<arr.length;j+=d) {
					int temp;
					if(arr[j]>arr[j+d]) {
						temp=arr[j];
						arr[j]=arr[j+d];
						arr[j+d]=temp;
					}
				}
			}
			if(d==1)break;
			d--;
		}
		for(int i :arr) {
			System.out.println(i);
		}
		
	}

}

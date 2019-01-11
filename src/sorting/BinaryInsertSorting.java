package sorting;

public class BinaryInsertSorting {

	public static void main(String[] args) {
		sort(new int[] {3,56,2,46,74,23,745,5,4,0,66});

	}
	
	private static void sort(int[] arr) {
		
		for(int i=1; i<arr.length;i++) {
			int temp =arr[i];
			int left =0;
			int right =i-1;
			int mid =0;
			while(left<=right) {
				mid=(left+right)/2;
				if(temp<arr[mid]) {
					right= mid-1;
				}else {
					left=mid+1;
				}
			}
			for(int j=i-1;j>=left;j--) {
				arr[j+1]=arr[j];//move the numbers that bigger than left to next index
				
			}
			if(left!=i) {
				arr[left]=temp;
			}
		}
		
		for(int i : arr) {
			System.out.println(i);
		}
	}

}

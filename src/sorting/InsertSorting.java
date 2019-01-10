package sorting;

public class InsertSorting {

	public static void main(String[] args) {
		int[] arr = {5,2,4,2,23,22,11,54,3,44};
		
		for(int i=1; i<arr.length;i++) {
			int temp = arr[i];
			int j;
			for(j=i-1;j>=0;j--) {
				if(arr[j]>temp) {
					arr[j+1]=arr[j];
					
				}else {
					break;
				}
			}
			arr[j+1]=temp;
			
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
	}
}

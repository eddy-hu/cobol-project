package sorting;

public class SelectSorting {

	public void selectSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++) {
			if(arr[j]<arr[minIndex]) {
				minIndex =j;
			}
			}
			int temp = arr[minIndex];
			arr[minIndex]= arr[i];
			arr[i]=temp;
		
		}
		
		for(int i : arr) {
		System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		SelectSorting ss = new SelectSorting();
		ss.selectSort(new int[] {2,7,1,8,3,22,44,12,34,21});

	}

}

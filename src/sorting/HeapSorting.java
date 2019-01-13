package sorting;

public class HeapSorting {

	public static void main(String[] args) {
			sort(new int[] {3,56,2,46,74,23,745,5,4,0,66});

		}
		
		private static void sort(int[] arr) {
			
			if(arr.length<=1||arr==null) {
				return;
			}
			
			buildMaxHeap(arr);
			for(int i =arr.length-1;i>=1;i--){
				exchangeElements(arr,0,i);
				maxHeap(arr,i,0);
			}
			for(int i:arr) {
				System.out.println(i);
			}
		}

		private static void buildMaxHeap(int[] arr) {
			int half= (arr.length-1)/2;
			for(int i=half;i>=0;i--) {
				maxHeap(arr,arr.length,i);
				
			}
			
			
		}

		private static void maxHeap(int[] arr, int length, int i) {
			int left = i*2+1;
			int right = i*2+2;
			int largest =i;
			if(left<length&&arr[left]>arr[i]) {
				largest=left;
			}
			if(right<length&&arr[right]>arr[largest]) {
				largest=right;
			}
			if(i!=largest) {
				exchangeElements(arr,i,largest);
				maxHeap(arr,length,largest);
			}
		}

		private static void exchangeElements(int[] arr, int i, int largest) {
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			
			
		}
}

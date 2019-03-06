package algorithm;

public class BinarySearch {
	
	//recursion
	public int binarySearch(int element, int[] array, int low, int high) {
		if(low>high) {
			return -1;
		}
		int middle = (low+high)/2;
		
		if(array[middle]==element) {
			return middle;
		}
		
		if(array[middle]<element) {
			return binarySearch(element,array,middle+1,high);
		}
		if(array[middle]>element) {
			return binarySearch(element,array,low,middle-1);
		}
		return -1;
	}
	
	//non recursion
	public int binarySearch(int element, int[] array) {
		int low=0;
		int high=array.length-1;
		while(low<=high) {
			int middle = (low+high)/2;
			if(element>array[middle]) {
				low=middle+1;
			}else if(element<array[middle]) {
				high=middle-1;
			}else {
				return middle;
			}
		}
		
		return -1;
	}


	public static void main(String[] args) {
		
		BinarySearch binarySearch = new BinarySearch();
		int[] array = {-1,22,55,44,111,1055,1678};
		System.out.println(binarySearch.binarySearch(44, array, 0, array.length-1));
		System.out.println(binarySearch.binarySearch(44, array));
		
	
	}

}

package algorithm.recursion;

public class Euclidean {
	
	public int gcd(int m,int n){
		if(n==0) {
			return m;
		}else {
			return gcd(n,m%n);
		}
	}

	public static void main(String[] args) {
		Euclidean e = new Euclidean();
		System.out.println(e.gcd(36, 24));
	}

}

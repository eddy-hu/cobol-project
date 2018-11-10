package graph;

public class GraphKruskal {
	private Edge[] edges;
	private int size;
	
	public GraphKruskal(int size) {
		this.size=size;
		edges= new Edge[size];
	}
	
	public void miniSpanTreeKruskal() {
		int m,n,sum=0;
		int[] parent  = new int[size]; //index is begin, value is end;
		for(int i=0;i<size;i++) {
			parent[i]=0;
		}
		for(int i=0;i<size;i++) {
			n=find(parent,edges[i].begin);
			m=find(parent,edges[i].end);
			if(n!=m) { 
				parent[n]=m;
				System.out.println("Begin: "+edges[i].begin+" End: "+edges[i].end +" Weight: "+edges[i].weight);
				sum+=edges[i].weight;
			}
		}
		System.out.println("Sum: "+sum);
	
	}

	private int find(int[] parent, int f) {
        while(parent[f]>0) {
        	f=parent[f];
        }

		return f;
	}

	public void createEdgeArray() {
		Edge e1 = new Edge(4,7,7);
		Edge e2 = new Edge(2,8,8);
		Edge e3 = new Edge(0,1,10);
		Edge e4 = new Edge(0,5,11);
		Edge e5 = new Edge(1,8,12);
		Edge e6 = new Edge(3,7,16);
		Edge e7 = new Edge(1,6,16);
		Edge e8 = new Edge(5,6,17);
		Edge e9 = new Edge(1,2,18);
		Edge e10 = new Edge(6,7,19);
		Edge e11 = new Edge(3,4,20);
		Edge e12 = new Edge(3,8,21);
		Edge e13 = new Edge(2,3,22);
		Edge e14 = new Edge(3,6,24);
		Edge e15 = new Edge(4,5,26);
		
		edges = new Edge[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15};
		
	}
	
	
	class Edge{
		private int begin;
		private int end;
		private int weight;
		public Edge(int begin, int end, int weight) {
			super();
			this.begin = begin;
			this.end = end;
			this.weight = weight;
		}
		public int getBegin() {
			return begin;
		}
		public void setBegin(int begin) {
			this.begin = begin;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		
	
	}
	
	
	public static void main(String[]args) {
		GraphKruskal gk = new GraphKruskal(15);
		gk.createEdgeArray();
		gk.miniSpanTreeKruskal();
		
	}

}

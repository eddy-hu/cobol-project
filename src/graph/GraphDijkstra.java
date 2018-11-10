package graph;

public class GraphDijkstra {

	private final static int MAXVEX =9;
	private final static int MAX_WEIGHT =65535;
	private int shortTablePath[] = new int[MAXVEX];
	
	
	
	public GraphDijkstra() {}
	
	// get shortest path of graph
	public void shortestPath(Graph graph) {
		int min;
		int index;
		boolean isGetPath[] = new boolean[MAXVEX];
		for(int i=0; i<graph.getVertexSize();i++) {
			shortTablePath[i]=graph.getMatrix()[0][i];
			
		}
		shortTablePath[0]=0;
		isGetPath[0]=true;
		for(int i=1; i<graph.getVertexSize();i++) {
		   min = MAX_WEIGHT;
		   for(int j=0;j<graph.getVertexSize();j++) {
			   if(!isGetPath[j] && shortTablePath[j]<min) {
				   index =j;
				   min = shortTablePath[j];
			   }
		   }
		}
	}
	
	public static void main(String[] args) {
 
	char a= 'y';
    
	System.out.println(a++);
  
	}

}

package graph;

public class GraphDijkstra {

	private final static int MAXVEX = 9;
	private final static int MAX_WEIGHT = 65535;
	private int shortTablePath[] = new int[MAXVEX]; // the weight that from vertex 0 to each node

	public GraphDijkstra() {
	}

	// get shortest path of graph
	public void shortestPath(Graph graph) {
		int min;
		int index = 0;
		boolean isGetPath[] = new boolean[MAXVEX];
		for (int i = 0; i < graph.getVertexSize(); i++) {
			shortTablePath[i] = graph.getMatrix()[0][i];// get 0[] vertex's weight

		}
		shortTablePath[0] = 0;
		isGetPath[0] = true;
		for (int i = 1; i < graph.getVertexSize(); i++) {
			min = MAX_WEIGHT;
			for (int j = 0; j < graph.getVertexSize(); j++) {
				if (!isGetPath[j] && shortTablePath[j] < min) { // get the connected node
					index = j;
					min = shortTablePath[j];
				}

			}
			isGetPath[index] = true;
			for (int k = 0; k < graph.getVertexSize(); k++) {
				if (!isGetPath[k] && (min + graph.getMatrix()[index][k] < shortTablePath[k])) {
					shortTablePath[k] = min + graph.getMatrix()[index][k];

				}
			}
		}
		
		for(int i : shortTablePath) {
			System.out.println(i+" "+shortTablePath[i]);
		}
	}
	

}

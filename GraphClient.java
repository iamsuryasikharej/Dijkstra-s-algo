import java.util.LinkedList;

public class GraphClient {
	public static void main(String[] args) {
		Graph g=new Graph();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addEdge("a", "b",2);
		g.addEdge("b", "c",3);
		g.addEdge("c", "d",1);
		g.addEdge("d", "a",10);
		g.addEdge("d", "e",8);
		g.addEdge("e", "f",5);
		g.addEdge("f", "g",4);
		g.addEdge("g", "e",6);
//		g.displayGraph();
//		g.BFT1("a");
//		g.BFT("a");
//		
//		g.getConnectedComponents();
//		System.out.println(g.isCyclic("a"));
//		g.DFT("a", new LinkedList<String>());
//		System.out.println("-------");
//		g.BFT("a");
		g.dijkatras("a");
		g.dijkatras("b");
		

		
	}

}

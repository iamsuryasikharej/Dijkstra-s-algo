
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
	HashMap<String, HashMap<Node,Integer>> vertices = new HashMap<>();
	LinkedList<String> visisted = new LinkedList<>();

	public void addEdge(String src1, String src2,int cost) {
		Map<Node,Integer> l1 = null;
		Map<Node,Integer> l2 = null;
		if (vertices.containsKey(src1) && vertices.containsKey(src2)) {
			l1 = vertices.get(src1);
			l2 = vertices.get(src2);
		}
		if (!l1.containsKey(src2) && !l2.containsKey(src1)) {
			l1.put(new Node(src2),cost);
			l2.put(new Node(src1),cost);

		}
	}

	public void addVertex(String x) {
		vertices.put(x, new HashMap<Node, Integer>());
	}

	public void displayGraph() {
		System.out.println(vertices);
	}

	// BFT iterative assuming it’s a connected graph
	public void BFT(String src) {
		Queue q = new Queue();
		visisted = new LinkedList<>();
		HashMap<String, String> path = new HashMap<>();

		if (vertices.containsKey(src)) {
			q.enqueue(src);
			visisted.add(src);
		}
		while (!q.linkedList.isEmpty()) {
			String key = q.dequeue();
			System.out.println(key);
			HashMap<Node, Integer> neighbour = vertices.get(key);
			
			for(int i=0;i<neighbour.keySet().toArray().length;i++) {
			Node n=(Node) neighbour.keySet().toArray()[i];
//			for (Node n : neighbour) {
				if (!visisted.contains(n.data)) {

					q.enqueue(n.data);
					visisted.add(n.data);

				}
			}

		}
	}

	// BFT recursive assuming it’s a connected graph
	public void BFT1(String src) {
		Queue q = new Queue();
		HashSet<String> visisted = new HashSet<>();
		HashMap<String, String> path = new HashMap<>();

		if (vertices.containsKey(src)) {
			q.enqueue(src);
			visisted.add(src);

		}
		BFT1Traverse(q, visisted);
	}
	// BFT recursive assuming it’s a connected graph

	private void BFT1Traverse(Queue q, HashSet<String> visisted) {
		if (q.linkedList.isEmpty()) {
			return;
		}
		String key = q.dequeue();
		System.out.println(key);

		HashMap<Node,Integer> neighbour = vertices.get(key);
//		for (Node n : neighbour) {
		for(int i=0;i<neighbour.keySet().toArray().length;i++) {
			Node n=(Node) neighbour.keySet().toArray()[i];
			if (!visisted.contains(n.data)) {
				q.enqueue(n.data);
				visisted.add(n.data);

			}
		}
		BFT1Traverse(q, visisted);

	}

	public void getConnectedComponents() {

		Set<String> vertices1 = vertices.keySet();
		LinkedList<String> linkedList = new LinkedList<String>(vertices1);
		int connectedComponentsCounter = 0;
		for (int i = 0; i < linkedList.size(); i++) {
			if (!visisted.contains(linkedList.get(i))) {
				connectedComponentsCounter++;
				System.out.println("entry for" + linkedList.get(i));
				BFT(linkedList.get(i));
			}
		}

		System.out.println("Number of connected components present ---->" + connectedComponentsCounter);
	}
	
	public boolean isCyclic(String src)
	{
		int cyclicCounter=0;
		Queue q = new Queue();
		LinkedList<String> visisted1 = new LinkedList<>();
		HashMap<String, String> path = new HashMap<>();

		if (vertices.containsKey(src)) {
			q.enqueue(src);
		}
		while (!q.linkedList.isEmpty()) {
			String key = q.dequeue();
			if(visisted1.contains(key))
			{
				cyclicCounter++;
			}
			visisted1.add(key);
			

			System.out.println(key);
			HashMap<Node,Integer> neighbour = vertices.get(key);
//			for (Node n : neighbour) {
			for(int i=0;i<neighbour.keySet().toArray().length;i++) {
				Node n=(Node) neighbour.keySet().toArray()[i];
				if (!visisted1.contains(n.data)) {

					q.enqueue(n.data);
//					visisted1.add(n.data);

				}
			}

		}
		if(cyclicCounter>0)
		{
			return true;
		}
		else
			return false;
	}
	
	
	
//	public void DFT(String src,LinkedList<String> visited)
//	{
//		System.err.println("entry dft------->"+src);
//		if(!visited.contains(src))
//		{
//			System.out.println(src);
//			visited.add(src);
//			
//		}
//		LinkedList<Node> neighbours=null;
//		if(vertices.containsKey(src))
//		{
//			neighbours=vertices.get(src);
//		}
//		for(Node temp:neighbours)
//		{
//			if(!visited.contains(temp.data)) {
//			System.err.println("calling DFT"+temp.data +"from-->"+src);
//			DFT(temp.data,visited);
//			}
//			
//		}
//	}
	
	
	public void dijkatras(String src)
	{
		HashMap<String, Integer> finalCostMap=new HashMap<String, Integer>();
		ArrayList<String> visited=new ArrayList<String>();
		HashMap<Node,Integer> neighbours=vertices.get(src);
		Heap<DijkatrasNode> heap=new Heap();
		heap.add(new DijkatrasNode(src, new StringBuilder(src), 0));


		
		
		startDijkatras(heap,visited,finalCostMap);
		System.out.println(finalCostMap+"<---for the given source node--->"+src);
		
	}

private void startDijkatras(Heap<DijkatrasNode> heap, ArrayList<String> visited, HashMap<String, Integer> finalCostMap) {
	if(heap.isEmpty())
	{
		return;
	}
	else
	{
		DijkatrasNode temp=heap.remove();
		if(visited.contains(temp.name))
		{
			int x=finalCostMap.get(temp.name);
			
			if(temp.cost<x)
				
			{
				System.out.println("entry");
				finalCostMap.put(temp.name, temp.cost);
			}
		}
		else
		{
			visited.add(temp.name);
			finalCostMap.put(temp.name, temp.cost);

		}
//		finalCostMap.put(temp.name, temp.cost);
		String vertex=temp.name;
		StringBuilder builder=temp.path;
		HashMap<Node, Integer> neighbours=vertices.get(vertex);
		for(int i=0;i<neighbours.keySet().toArray().length;i++)
		{
			Node temp1=(Node) neighbours.keySet().toArray()[i];
			int cost=neighbours.get(neighbours.keySet().toArray()[i]);
			if(!visited.contains(temp1.data))
			{
				heap.add(new DijkatrasNode(temp1.data,builder.append(temp1.data) , temp.cost+cost));
						
			
			}
		}
		startDijkatras(heap, visited, finalCostMap);
		
	}
	
}

}

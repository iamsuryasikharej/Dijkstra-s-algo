
public class DijkatrasNode implements Comparable<DijkatrasNode> {
	String name;
	StringBuilder path;
	int cost;
	public DijkatrasNode(String name, StringBuilder path, int cost) {
		super();
		this.name = name;
		this.path = path;
		this.cost = cost;
	}

	@Override
	public int compareTo(DijkatrasNode o) {
		if(this.cost<o.cost)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	
	
	
	
}

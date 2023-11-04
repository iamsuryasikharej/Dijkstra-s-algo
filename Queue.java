import java.util.LinkedList;

public class Queue {
LinkedList<String> linkedList=new LinkedList<String>();
public void enqueue(String n)
{
	linkedList.addFirst(n);
}
public String dequeue()
{
	return linkedList.removeLast();
}
}

import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
	ArrayList<T> data = new ArrayList<T>();

	public void add(T item) {
		data.add(item);
		upheapify(data.size() - 1);
	}

	public void upheapify(int index) {
//		if(index==0 && data.get(0)>data.get(index))
//		{
//			swap(0,index);
//			return ;
//		}
//		else {

		int parent = (index - 1) / 2;
		if (parent == 0 && index == 0) {
			return;
		}

		if (heapCondt(parent, index)) {
			swap(parent, index);
			upheapify(parent);
		}

	}

	private boolean heapCondt(int parent, int index) {
		if (data.get(parent).compareTo(data.get(index)) > 0) {
			return true;
		} else {
			return false;
		}
	}

//		}

	private void swap(int i, int index) {
		T a = data.get(i);
		T b = data.get(index);

		data.remove(i);
		data.add(i, b);

		data.remove(index);
		data.add(index, a);

	}

	public void displayHeap() {
		System.out.println(data);

	}

	public T remove() {
		T x = null;
		if (!(data.size() == 0)) {

			int remove_index = 0;
			x = data.get(remove_index);
			swap(0, data.size() - 1);
			data.remove(data.size() - 1);

			downHeapify(0);

			return x;
		}

		else {
			System.err.println("Nothing left to remove bro");
			return null;
		}

	}

	private void downHeapify(int parent) {
		int child1 = (2 * parent) + 1;
		int child2 = (2 * parent) + 2;
		int min_index = findMinIndex(parent, child1, child2);
		if (min_index != parent) {
			swap(min_index, parent);
			downHeapify(min_index);

		}

	}

	private int findMinIndex(int parent, int child1, int child2) {

		int x = parent;

		if (child1 < data.size()) {

			if ((data.get(child1).compareTo(data.get(parent)) < 0)) {
				x = child1;
			}

		}
		if (child2 < data.size()) {
			if ((data.get(child2).compareTo(data.get(x))) < 0) {
				x = child2;
			}

		}
		return x;
	}
	
	public boolean isEmpty()
	{
		return data.size()==0;
	}
	
	

}

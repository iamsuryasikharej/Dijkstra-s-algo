
public class HeapClient {

	public static void main(String[] args) {

		Heap<Integer> heap = new Heap<>();
		heap.add(10);
		heap.displayHeap();

		heap.add(20);
		heap.displayHeap();

		heap.add(30);
		heap.displayHeap();

		heap.add(40);
		heap.displayHeap();

		heap.add(5);
		heap.displayHeap();

		heap.add(3);
		heap.displayHeap();

		heap.add(1);
		heap.displayHeap();
		heap.add(0);
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();
		System.out.println(heap.remove() + "has been removed");
		heap.displayHeap();

//		
	}

}

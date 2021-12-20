
public class BinaryHeap <T extends Comparable<T>>{
	
	private static final int DEFAULT_CAPACITY = 10;
	protected T[] array;
	protected int size;

	public BinaryHeap() {
		super();
		this.array = (T[]) new Comparable(DEFAULT_CAPACITY);
		this.size = 0;
	}
	
	public void add(T value) {
		if (size == this.array.length - 1) 
			increaseSize();
		
		// take the next available slot
		size++;
		array[size] = value;
		
		bubbleUp();
		
	}
	
	public void bubbleUp() {
		
		int hole = size;
		
		while (hole > 0) {
			int parent = hole / 2;
			
			if(array[hole].compareTo(array[parent]) < 0) {
				swap(hole, parent);
				hole = parent;
			} else {
				break;
			}
		}
	}
	
	public void swap(int hole, int parent) {
		int temp = hole;
		T replace = array[hole];
		array[parent] = array[hole];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

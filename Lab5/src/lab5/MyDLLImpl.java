package lab5;

import java.util.NoSuchElementException;

public class MyDLLImpl<E> implements MyDoubleLinkedList {
	
	public MyDoubleNode head;
	public MyDoubleNode tail;
	public int size;
	

	public MyDLLImpl() {
		super();
		this.head = new MyDoubleNode(null, tail, null); // MyDoubleNull(data, next, prev)
		this.tail = new MyDoubleNode(null, null, head);
		
		this.size = 0;
	}

	@Override
	public void insert(Object x) {
		
		if (lookup(x)) {
			throw new IllegalStateException("This node is already in the list.");
		}
		
		if (this.size == 0) {
			head = new MyDoubleNode(x, tail, null); // if empty, sets x as the head before the tail
		} else if (this.size == 1) {
			tail = new MyDoubleNode(x, null, head); // if 1, sets x as the tail
			head.next = tail;
		} else {
			tail.next = new MyDoubleNode(x, null, tail);
			tail = tail.next;
		}
		
		this.size++;

	}

	@Override
	public void delete(Object x) {
		if (isEmpty() || x == null) {
			throw new NoSuchElementException("The node is not in this list");
		} else {
			
			MyDoubleNode current = head;
			
			while (current != null) {
				if (current.data.equals(x)) {
					if (current.next == null) {
						current.prev.next = null;
						tail = current.prev;
					} else if (current.prev == null) {
						current.next.prev = null;
						head = current.next;
					} else {
						current.prev.next = current.next;
						current.next.prev = current.prev;
					}
					size--;
					return;
				}
				current = current.next;
			}
			
			throw new NoSuchElementException("Node is not found");
			
		}

	}

	@Override
	public boolean lookup(Object x) {
		if (isEmpty()) {
			return false;
		} else {
			MyDoubleNode current = head;
			
			while (current.next != null) {
				if (current.data.equals(x)) {
					return true;
				}
				current = current.next;
			}
			return false;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next == null;
	}

	@Override
	public void printList() {
		MyDoubleNode current = head;
		
		String str = new String("[ ");
		
		for(int i = 0; i < size; i++) {
			str += current.data + " ";
			current = current.next;
		}
		str += "]";
		System.out.println(str);

	}

	@Override
	public void printListRev() {
		MyDoubleNode current = tail;
		
		String str = new String("[ ");
		
		for(int i = 0; i < size; i++) {
			str += current.data + " ";
			current = current.prev;
		}
		
		str += "]";
		System.out.println(str);

	}
	
	public int getSize() {
		return this.size;
	}

	public static void main(String[] args) {
		  MyDLLImpl<Integer> dll = new MyDLLImpl<Integer>();
		  dll.insert(10);
		  dll.insert(34);
		  dll.insert(56);
		  dll.insert(364);
		  dll.printList();
		  dll.delete(56);
		  dll.delete(34);
		  dll.printListRev();
	}

}

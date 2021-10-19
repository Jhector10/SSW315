package simulator;

public class MyQueue<E> {
    //Node class for single linked list queue
    private static class Node<E> {
        //Instance variables for Node
        private E data;
        private Node<E> next;

        //Constructor for Node, to be completed by you
        private Node(E dataItem) {
        	data = dataItem;
        	next = null;
        }

        //Constructor for Node, to be completed by you
        private Node(E dataItem, Node<E> nodeRef) {
        	data = dataItem;
        	next = nodeRef;
        }
    }

    //Instance variables for queue
    private Node<E> front;
    private Node<E> rear;
    private int size;

    //Constructor for queue, to be completed by you
    public MyQueue () { 
    	
    	front = null;
    	rear = null;
    	size = 0;
    }

    //Adds a node to queue, to be completed by you
    public boolean offer(E item) {
    	// checks to add a node to the rear of the queue
    	if(item == null) {
    		throw new IllegalArgumentException();
    	}
    	if (front == null) {
    		rear = new Node<E>(item);
    		front = rear;
    	} if (front == rear) {
    		front.next = new Node<E>(item);
    		rear = front.next;
    	}
    	else {
    		rear.next = new Node<E>(item);
   			rear = rear.next;
   		}
   		
   		size++;
    	return true;
    }

    //Returns the node at front of queue, to be completed by you
    public E peek() { 
    	if(front == null) {
    		return null;
    	} else {
    		return front.data;
    	}
    }

    //Returns and removes the node at front of queue, to be completed by you
    public E poll() {
    	E item = peek();
    	
    	if (front == null) {
    		return null;
    	} if (size == 1) {
    		front = null;
    		rear = null;
    	} else {
    		front = front.next;
    	}
    	
    	size--;
    	return item;
    }

    //Returns the data element at a specific index, to be completed by you
    public E get(int index) {
    	if (size == 0 || index < 0 || index > size - 1) {
    		throw new IllegalStateException();
    	} 
    	Node<E> node = front;
    	for(int i = 0; i < index; i++) {
    		node = node.next;
    	}
    	
    	return node.data;
    }
    

    //Returns the size of the queue, to be completed by you
    public int size() {	
    	return size;
    }
}

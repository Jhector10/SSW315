package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@SuppressWarnings("hiding")
public class ArrayBasedStack <E> implements Stack <E> {

	E[] stuff;  //internal storage for collections;
	int size; 	//number of items;

	//Constructor
	public ArrayBasedStack()
	{
		stuff = (E[]) new Object[10]; // Use an array of size 10.
		size = 0;	// The stack is initially empty.	
			
	} 

	@Override
	public void push(E x) {
		if (size == stuff.length) {
			E[] increaseStuff = (E[]) new Object[size * 2];
			for (int i = 0; i < stuff.length; i++) {
				increaseStuff[i] = stuff[i];
			}
			stuff = increaseStuff;
		}
		
		stuff[size] = x;
		size++;
	}

	@Override
	public void pop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		stuff[size - 1] = null;
		size--;

	}

	@Override
	public E top() {
		return stuff[size-1];
	}

	@Override
	public E topAndPop() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E top = stuff[size-1];
		stuff[size-1] = null;
		size--;
		return top;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}


	@Override
	public void makeEmpty() {
		for(int i = 0; i < size; i++) {
			stuff[i] = null;
		}
		size = 0;
	}

	public String toString() {
		if(size==0){
			return null;
		}
 
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++){
			sb.append(stuff[i] + ", ");
		}
 
		sb.setLength(sb.length()-2);
		return sb.toString();	
	}
	
	public static void main(String[] args) {

		ArrayBasedStack<String> stack = new ArrayBasedStack<String>();
		stack.push("hello");
		stack.push("world");
		stack.push("3rd");
		stack.push("4th");
		stack.push("5th");
		stack.push("6th");
		stack.push("7th");
		stack.push("8th");
		stack.push("9th");
		
		System.out.println(stack);
		
		System.out.println(stack.size);
		
		stack.push("10th");
		
		System.out.println(stack.size);
		
		stack.push("resized");
		
		System.out.println(stack.size);
		

		System.out.println(stack);

		System.out.println(stack.topAndPop());
		
		System.out.println(stack);

		stack.pop();
		System.out.println(stack);
	}
	
}

import java.util.Collection;
import java.util.Iterator;


public class myCollectionClass<E> implements Collection<E> {
	
	private E[] items;
	private int size;
	
	public void ConstructorClass() {
		items = (E[]) new Object[10];
		//items = new E[10];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	@Override 
	public Object[] toArray() {
		return null;
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}
	
	@Override
	public boolean add(E e) {
		
		if(size < 10) {
			items[size] = e;
			size++;
			
			return true;
		
		} else {
			return false;
		}
	}
	
	@Override
	public boolean remove(Object o) {
		return false;
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}

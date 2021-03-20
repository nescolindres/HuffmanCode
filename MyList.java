package cs282sol;

import java.util.Arrays;

public class MyList<E> {

	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];
	
	public MyList() {
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public void add(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}
	
	private void ensureCapa() {
		int newSize = elements.length *2;
		elements = Arrays.copyOf(elements, newSize);
	}
	
	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i >= size || i <0 ) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		return (E) elements[i];
	}
	
	public int size() {
		return this.size;
	}
	
	public int find(Object x) {
		int indexOfObject = -1;
		for(int i = 0; i < elements.length; i ++) {
			if (elements[i] == x)
				indexOfObject = i;
		}
		return indexOfObject;
	}
	
	
	public Boolean contains(Object x) {
	 return find(x) >= 0;
	}
	
	
	public void set ( int index, E element) {
		if ((index >= 0 || (index< this.size()))) {
			this.elements[index] = element;
		}
		else
			throw new IndexOutOfBoundsException("index " + index + " is beyond the sixe of the array (" + this.size() + ")");
	}
	
}

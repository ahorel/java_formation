package arrayList;

import java.util.Arrays;

public class ArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }


    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}

public class myownarrayList<E> {
	private int dataCapacity = 10
	private Object elements[];
	private int currentsize = 0;
	
	public void addValues(E e) {
		if(currentsize == elements.length) {
			ensureCapacity();
		}
		elements[currentsize++] = e;
		
	}
	
	public void ensureCapacity() {
		int newsize = elements.length * 2;
		elements = Arrays.copyOf(elements, newsize);
		
	}
	
	public E get(int i) {
		return (E) elements[i];
	}
}
package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


public class BinaryMinHeap <E> implements PriorityQueue<E>{
	private Object[] data;
	private int size;
	private Comparator <? super E> comp;
	
	
	/**
	 * Basic no parameter constructor, builds empty heap and sets comp to use compareTo
	 */
	@SuppressWarnings("unchecked")
	public BinaryMinHeap() {
		this((a, b) -> ((Comparable<? super E>) a).compareTo(b));
	}
	
	/**
	 * Constructor that builds empty heap and sets comp
	 * @param comp, the comparator to sort by
	 * @throws IllegalArgumentException if comp is null
	 */
	public BinaryMinHeap (Comparator<? super E> comp) {
		if (comp == null)
			throw new IllegalArgumentException("Comp cannot be null");
		this.size = 0;
		this.comp = comp;
		this.data = new Object[16];
	}
	
	/**
	 * Builds heap from the input list and sets comp to use compareTo
	 * @param list, a list of entries to add to the heap
	 */
	@SuppressWarnings("unchecked")
	public BinaryMinHeap (List<? extends E> list) {
		this(list, (a, b) -> ((Comparable<? super E>) a).compareTo(b));
	}

	/**
	 * Builds heap from the input list and sets comp to input comparator
	 * @param list, a list of entries to add to the heap
	 * @param comp, the comparator to sort the heap by
	 * @throws NullPointerException if null elements are contained in list
	 * @throws IllegalArgumentException if comp is null
	 */
	public BinaryMinHeap (List<? extends E> list, Comparator<? super E> comp) {
		if (comp == null)
			throw new IllegalArgumentException("Comp cannot be null");
		this.size = list.size();
		this.comp = comp;
		this.data = new Object[list.size() + 10];
		int i = 0;
		for (E element: list) {
			if (element == null)
				throw new NullPointerException("Elements cannot be null");
			this.data[i++] = element;
		}
		buildHeap();
	}
	
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (this.isEmpty())
			throw new NoSuchElementException("Heap is empty");
		return this.entryAt(0);
	}

	@Override
	public E extract() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size < 1;
	}

	@Override
	public void clear() {
		this.size = 0;
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Helper method to cast array from Object to E and suppress warnings
     */
    @SuppressWarnings("unchecked")
    private E entryAt(int index) {
    	return (E) data[index];
    }
    
    /**
     * Private helper method to build heap
     */
    private void buildHeap() {
        for (int i = (this.size / 2) - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }
    
    
    /**
     * Moves the element at the given index down the tree until in place
     */
    private void percolateDown(int i) {
    	E target = entryAt(i);
    	int half = this.size / 2;
		while (i < half) {
			int leftIndex = 2 * i + 1;
			int rightIndex = leftIndex + 1;
			int childIndex = leftIndex;
			E smallerChild = entryAt(leftIndex);
        	if (rightIndex < this.size) {
				E rightChild = entryAt(rightIndex);
				if (innerCompare(rightChild, smallerChild) < 0) {
					childIndex = rightIndex;
					smallerChild = rightChild;
				}
        	}
        	if (innerCompare(target, smallerChild) <= 0)
        		break;
        	this.data[i] = smallerChild;
        	i = childIndex;
    }
    
    this.data[i] = target;    
    }
    
    /**
     * Moves the element at the given index up the tree until it is in place
     */
    private void percolateUp(int i) {
    	E target = entryAt(i);
    	while (i > 0) {
    		int parentIndex = (i - 1) / 2;
    		E parent = entryAt(parentIndex);
    		if (innerCompare(target, parent) >= 0) {
    			break;
    		}
    		this.data[i] = parent;
            i = parentIndex;
        }
        this.data[i] = target;
    }
    
    /**
     * Compares two elements using the heaps comp
     */
    private int innerCompare(E a, E b) {
        return this.comp.compare(a, b);
    }

	@Override
	public void add(E element) { 
		if (element == null)
			throw new NullPointerExcep
				tion("Element cannot be null");
		if (size == data.length) {
			Objecct[] newData = new Object[data.length * 2];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}

		data[size] = element;
		size++;
		percolateUp(size - 1);
}

	@Override
	public E extract() throws NoSuchElementException {
		if (isEmpty()) 
			throw new NoSuchElementException("Heap is empty");

		E minimum = entryAt(0);

		data[0] = data[size - 1];
		data[size - 1] = null;
		size--;

		if (size > 0) 
			percolateDown(0);

		return minimum;
	}

	@Override
	public Object[0] toArray() {
		Object[] result = new Object[size];
		System.arraycopy(data, 0, result, 0, size);
		return result;

	}

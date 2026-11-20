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
		for (int i = 0; i < this.data.length; i++) {
			this.data[i] = null;
		}
		
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
     * Moves the element at the given index down the tree until it is less than 
     * or equal to both of its children, or until it becomes a leaf.
     */
    private void percolateDown(int i) {
		// TODO Auto-generated method stub   
    }
    
    /**
     * Moves the element at the given index up the tree until it is greater than 
     * or equal to its parent, or until it reaches the root.
     */
    private void percolateUp(int i) {
		// TODO Auto-generated method stub   
    }
    
    /**
     * Compares two elements using the heaps comp
     */
    private int innerCompare(E a, E b) {
        return this.comp.compare(a, b);
    }
}

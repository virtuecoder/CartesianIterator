

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CartesianIterator implements Iterator {

	private final Iterable[] iterables;
	private final Iterator[] iterators;
	private Object[] tuple; 
	private int index, size;
	private boolean empty;

	public CartesianIterator(Iterable ...iterables) {
		this.iterables = iterables;
		size = iterables.length;
		this.iterators = new Iterator[size];

		// Check for empty case
		if (size == 0) {
			empty = true;
		}

		// Get iterators and check for empty case
		for (int i = 0; i < size; i++) {
			iterators[i] = iterables[i].iterator();
			if (!iterators[i].hasNext()) {
				empty = true;
				break;
			}

		}
		
		if (!empty) {
			// Initialize the elements of the tuple except the last one
			tuple = new Object[size];
			for (int i = 0; i < size - 1; i++) {
				if (iterators[i].hasNext())
					tuple[i] = iterators[i].next(); 
	
			}
			index = size - 1;
		}
	}

	@Override
	public boolean hasNext() {
		if (empty) return false;
		for (int i = 0; i < size; i++) {
			if (iterators[i].hasNext()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object next() {
		if (!hasNext()) {
			throw new NoSuchElementException(); 
		}
			
		tuple = tuple.clone();
		int indexBefore = index;
		
		while (index >= 0 && index < size) {
			if (iterators[index].hasNext()) {
				tuple[index] = iterators[index].next();
				break;
			}
			else {
				index--;				
			}
		}
		if (index < 0) {
			initFrom(1);				
			index = size - 1;
		}
		else if (index < indexBefore) {
			initFrom(index + 1);
			index = size - 1;
		}
		
		return tuple;
	}
	
	private void initFrom(int from) {
		for (int i = from; i < size; i++) {
			Iterator it = iterables[i].iterator();
			iterators[i] = it;
			tuple[i] = it.next(); 
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}

package queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class LoopQueue<E> implements Queue<E>{
	
	private E[] data;
	private int front, tail;
	private int size;

	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity+1];
		front =0;
		tail =0;
		size =0;
	}
	
	public LoopQueue() {
		this(10);
	}

	public int getCapacity() {
		return data.length-1;
	}
	
	public void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity+1];
		for(int i =0; i< size;i++) {
			newData[i] = data[(i+front)%data.length];
		}
		data = newData;
		front =0;
		tail =size;
	}
	
	public void enqueue(E e) {
		if((tail+1)% data.length == front) {
			resize(getCapacity()*2);
		}
		data[tail]=e;
		tail=(tail+1)%data.length;
		
	}
	
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

}

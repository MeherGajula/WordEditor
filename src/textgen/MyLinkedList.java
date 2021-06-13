package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		
		//head.next = tail; 
		//tail.prev = head; 
		size = 0; 
		

		// TODO: Implement this method
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 * @return 
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		if(element == null) {
			
			throw new NullPointerException("Null elements shouldn't be added"); 
			
		}
		  LLNode<E> a = new LLNode<E>(element);
		  
		  if(size==0) {
			  
			  a.next = head; 
			  head = a; 
		  }
		  
		  else {
			  
			 tail = head; 
			 while(tail.next != null) {
				 
				 tail = tail.next; 
			 }
			 
			 tail.next =a;
			  
		  }
		  
		size++ ; 
		 
		return true; 
		
		
	}

	

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index<0 || index > size-1) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		
		int i = 0; 
		LLNode<E> a = head;
		
		while(a != null) {
			
			if(i == index) {
				
				return a.data;
			}
			i++; 
			a = a.next; 
		}

		assert(false); 
		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index>size || index<0) {
			
			throw new IndexOutOfBoundsException("Index is out of bounds"); 
			
		}
		if(element == null) {
			
			throw new NullPointerException("Null elements cannot be added");
		}
		
		
		LLNode<E> newNode =  new LLNode<E>(element); 
		if(size==0 || index==0) {

			newNode.next = head; 
			head = newNode; 	
		}
		
		else {
			LLNode<E> prevNode = goTo(index-1); 
			newNode.next = prevNode.next; 
			newNode.prev = prevNode; 
			newNode.prev.next = newNode;
		}
		size++; 
		
	}

	
		//Writing a helper method to return the node at a particular place
		public LLNode<E> goTo(int index){
			
			
			if(index<0 || index >=size) {
				
				throw new IndexOutOfBoundsException(" The index is out of bounds"); 
			}
			
			LLNode<E> current = head;
			for(int i =0; i<index; i++) {
				
				current = current.next;
			}

			return current;	
		}

	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if(index>=size || index<0) {
			
			throw new IndexOutOfBoundsException("Index is out of bounds"); 
			
		}
		
		LLNode<E> currNode = goTo(index); 
		E a = currNode.data;
		
		if(currNode.next != null && currNode.prev != null) {
			
			currNode.next.prev = currNode.prev; 
			currNode.prev.next = currNode.next; 
			currNode = null; 	
		}
		
		else if(currNode.next == null && currNode.prev == null ) {
			
			currNode = null;
			
		}
		
		else if(currNode.next == null && currNode.prev != null) {
			
				tail.next = currNode.prev; 
				tail = currNode.prev; 
		}
		
		else {
			
			head.prev = currNode.next;
			head = currNode.next;

		}
			
		
		
		size--; 
		
		return a;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if(index <0 || index >= size) {
			
			throw new IndexOutOfBoundsException("You can't replace the item");
		}
		
		if(element == null) {
			
			throw new NullPointerException("You cannot pull null elements inside the list"); 
		}
		
		LLNode<E> currNode = goTo(index);  
		E replaced = currNode.data;
		currNode.data = element;
		
		
		return replaced;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}

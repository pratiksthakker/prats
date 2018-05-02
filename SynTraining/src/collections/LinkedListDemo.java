package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/**
 * Unlike HassMap or Sets there is not initial capacity allocated of loadFactor defined over here , it increases linerly whenever the elements are added and that is the reason 
 * we do not need the ensureCapacity Function here
 */
	LinkedList<String> lList = new LinkedList<String>();
	lList.add("A1");
	lList.add("A2");
	lList.add("A3");
	lList.offer("A4");
	System.out.println(lList);
	Iterator<String> descItr = lList.descendingIterator();//LinkedList Structure is like a doubly circular linked list so this enables us to easily traverse in reverse as well.
													//Basically the Header.Previous is always the last element in the LinkedList and so if you see the add function it internally calls addBefore function .
		while(descItr.hasNext())//internally it checks is header.previous is present
		{
			System.out.println(descItr.next());
			descItr.remove();//Note in ArrayList or Any list if we remove using the Iterator obj then there will be no concurrent modification exception 
								//since internally both the modcount and expectedModCount value will be increased 
		}
		
	System.out.println(lList);
	//------------------Basically using a descending Iterator and removing the elements we have kind of implemented a Stack Data structure internally -----------/
	lList.add("A1");
	lList.addFirst("A2");
	lList.addLast("A3");
	lList.add(3, "a4");
	
	for(int i =0;i<10;i++)
	{
		lList.add("aa"+i);
	}
	System.out.println(lList);
	lList.remove(9);//Here we will think that it will start from the 0 index and after 9 iteration reach here but since it kind of doubly linkedlist it will see if it is nearer to last or 
					//first index by comparing it with the half of the size so ideally here it will use the descending iterator and start with header.previuos
	System.out.println(lList);
	
	}

	
	/**
	 * Please note above explanation is as per 1.5/1.6 in 1.7 instead of Entry a Node class is used and also the linked list is not circular instead it mantains 2 Pointers first and last and then decideds from where to travers and everything 
	 * So the add funtion there will not be addBefore but will be linkLast . check the API doc for more
	 */
}

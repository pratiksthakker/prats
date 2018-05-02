package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * 
 * @author pratik.thakker
 * do visit http://ganeshrashinker.blogspot.in/
 * The ArrayList is internally an array of objects i.e. object[] 
 *
 */
public class ArrayListExamples {
	
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();//Here memory will be allocated and the capacity will be initialized to 10.
		//Also the Array will have all values as null but the
		//ArrayList when displayed here will not show null but will be displayed as empty since it is dynamic DS and static datastructure as Array .
		System.out.println(list);//Here just "[]" will be printed since there is no element inside the ArrayList as of now , this is do due the toString Function in AbstractCollection class .
		for(int i=0;i<10;i++)
		{
			list.add("a"+i);
		}
		//At this point the size of the array is 10 and the capacity is also 10.
		System.out.println(list);
		System.out.println(list.size());
		list.add("a55"); //Here the add function internally checks the ensure capacity method and sees if the capacity of the aary is correct to fit the added element.
						//If the capacity is not proper then the arrayList is resized this is basically done by creating a new arrayList and coping all the oldelements to it .
		System.out.println(list);
		System.out.println(list.size());//The grow method which increases the capacity is different in 1.5/1.6 & 1.7
		
		/*
		//modCount - It is nothing but the number of operations performed on the arralist . it increases wheneever something is added/removed etc...
		for(Iterator<String> itr = list.iterator();itr.hasNext();itr.next())//here the iterator maintains a expectedModcount which is initialized with the modcount of the ArrayList .
		{
			itr.remove(); // Here we will get illegalStateException since till now the itr.Next is not called and so there is noting to remove at the current position . The while loop will be clear to remove the element .
			System.out.println("Removed");
			//list.remove(1); //will throw concurrentmodification exception since the modcount changed and now the modcount and expectedModcount are not equal .
		}*/
		
		list.add(5, "a66");
		
		//The Above Add function first checks if the index is less than or equal to the size of the array else will throw IndexOutOfBound
		//If the index is fine then it will check for the capacity using ensure capacity , if need will grow the capacity and the old array will be copied to the new arrayList
		//using the grow function which internally calls Arrays.copyOf() method and then the new element is inserted using the 
		//System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length) method .

		System.out.println(list);
		System.out.println(list.size());
		Iterator<String> itr = list.iterator();
		while(itr.hasNext())
		{
			itr.next();
			//list.remove(2);//will throw concurrentmodification exception since the modcount changed and now the modcount and expectedModcount are not equal .
			itr.remove();
		}
		//All elements are removed at this point of time .
		System.out.println(list);
		System.out.println(list.size());
	}

}

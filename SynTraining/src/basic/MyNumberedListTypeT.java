package basic;


public class MyNumberedListTypeT<T extends Number> {
	
	T[] myList;
	
	public MyNumberedListTypeT(T[] tArray)
	{
		myList = tArray;
	}

	public MyNumberedListTypeT() {
		super();
	}
	
	public void add(T t)
	{
		System.out.println("Added : "+t);
	}
	
	public void addWild(T t)
	{
		System.out.println("Added : "+t);
	}
	
	
}


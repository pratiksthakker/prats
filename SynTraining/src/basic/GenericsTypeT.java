package basic;

public class GenericsTypeT {
	
	public static void main(String[] args)
	{
//		MyNumberedListTypeT<String> sList = new MyNumberedListTypeT<String>();//This will throw
				//Error since We have specified the MyNumberedList as T extend number and over here giving a String to it is not valid
		
		MyNumberedListTypeT<Integer> intArray = new MyNumberedListTypeT<Integer>();//Valid since Integer is subclass of Number.
		intArray.add(2);
		
	}

}

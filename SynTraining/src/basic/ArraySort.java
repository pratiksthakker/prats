package basic;

public class ArraySort {
	
	public static void main(String args[])
	{
		/*int[] intarr= new int[]{5,8,1,3,2,6,9,4,7,10};
		sortArr(intarr);*/
		int[] intarr2= new int[]{5,8,1,3,2,6,9,4,7,10};
		RemoveOddAndQuareEven(intarr2);
		
	}
	
	private static void RemoveOddAndQuareEven(int[] intarr) {
		for(int i =0;i<intarr.length;i++)
		{
			if(intarr[i]%2==0)
			{
				intarr[i] = (int) (Math.pow(intarr[i], 2));
			}
		}
		sortArr(intarr);
		
	}

	public static void printArr(int[] intarr)
	{
		for(int i =0;i<intarr.length;i++)
		{
			System.out.println(intarr[i]);
		}
	}
	
	public static void sortArr(int[] intarr)
	{
		printArr(intarr);
		for(int i =0;i<intarr.length;i++)
		{
			for(int j=i;j<intarr.length;j++)
			{
				if(intarr[j]<intarr[i])
				{
					int temp = intarr[j];
					intarr[j] = intarr[i];
					intarr[i] = temp;
				}
			}
		}
		printArr(intarr);
	}
}

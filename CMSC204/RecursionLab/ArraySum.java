/**
 * 
 */

/**
 * @author Yared Fikremariam
 *
 */
public class ArraySum {
	
	/**
	 * Returns the sum of values in an array of integers
	 * @param a array of type Integer
	 * @param index
	 * @return
	 */
	public int sumOfArray(Integer[] a,int index)
	{
		if(index == 0)
		{
			return a[0];
		}
		else
			return a[index]+ sumOfArray(a, index - 1);
		
	
		
	}

}

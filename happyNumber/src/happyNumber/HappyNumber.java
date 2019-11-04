package happyNumber;

import java.util.ArrayList;

/**
 * @author Roland
 * @version 1.0.0
 *
 */
public class HappyNumber {
	
	ArrayList<Integer> checktNoList = new ArrayList<Integer>();
	
	public HappyNumber() {
		
	}
	/**
	 * Tests each number in the specified range to see if it is a Happy Number and returns a string with each calculated Happy Number.
	 * @param from The start value of the numbers to be checked
	 * @param to The end value of the numbers to be checked
	 * @return a string containing every 'happy number' in the given range
	 */
	public String getHappyNumbers(int from, int to) {
		String happyNumbers = null;
		for(int i = from; i<= to; i++)
			if(isHappy(i))
				happyNumbers += i + ";";
		return happyNumbers;
	}
	
	/**
	 * Checks if a number is a 'Happy Number'.<br>
	 * A <b>'Happy number'</b> is a number where the sum of the squares of its digits in the long run is equal to 1.<br>
	 * Example:<br>
	 * 19 -> 1^2 + 9^2 = 82 -> 8^2 + 2^2 = 68 -> 6^2 + 8^2 = 100 -> 1^2 + 0^2 + 0^2 = 1
	 * @param no the number that has to be tested
	 * @return true if the number is 'Happy'
	 */
	private boolean isHappy(int no) {
		if(no == 1)
			return true;
		
		if(!checktNoList.isEmpty() || checktNoList.contains(no))
			return false;
		checktNoList.add(no);
		
		int temp1 = 0;
		int temp2 = 0;
		String noAsSting = Integer.toString(no);
		int length = noAsSting.length();
		
		for(int i = 0; i< length; i++) {
			temp1 = Character.getNumericValue(noAsSting.charAt(i));
			temp1 = (int) Math.pow(temp1, 2);
			temp2 += temp1;
		}
		if(isHappy(temp2))
			return true;
		return false;
	}
}

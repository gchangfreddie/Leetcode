package algorithm;

/**
 * Author: Grace Chang (gracechang007@gmail.com)
 * This class is responsible for converting the string to a long.
 * 
 * Assumption: if the input string greater than the Long.MAX_VALUE or less than the Long.MIN_VALUE, 
 * will cut the last digit to make the long number in the range. 
 * For example if the input String is 9223372036854775808, will convert it to 922337203685477580
 * We can also choose to throw exception for overflow, but for this one I choose to convert the valid part
 */
public class StringToLong {
	private final String minStr = String.valueOf(Long.MIN_VALUE).substring(1); 
	private final String maxStr = String.valueOf(Long.MAX_VALUE);
	/**
	 * Convert String to long
	 * @param s String pass to be converted
	 * @return the converted long number
	 * @exception if the s contains invalid char
	 */
	public long stringToLong(String s) throws NumberFormatException{
		// if s is null or empty throw NumberFormatException
		if (s==null || s.length()==0) throw new NumberFormatException(s);
		
		// check the first char, whether it is a sign
		char firstChar = s.charAt(0); 
		int neg = 1; 
		int start=0; 
		if (firstChar=='-' || firstChar=='+') {
			// if the String only contains sign, it is not a valid long number, throw exception
			if (s.length()==1) throw new NumberFormatException(s); 
			start=1; 
			neg = firstChar=='-' ? -1 : 1 ; 
		}
		
		long  res = 0; 
		int len = String.valueOf(Long.MAX_VALUE).length(); 
		for (int i=start; i<s.length(); i++) {
			char c = s.charAt(i); 
			// if char is not a valid digit, will return number till the char
			if (!isValid(c)) throw new NumberFormatException(s); 
			
			// if the number has the same length as the max or min value, it is possible to overflow
			// if it is overflow, we will return number till this char
			String sub = s.substring(start, i+1); 
			if (sub.length()>len || (sub.length()==len && isOverflow(sub, neg))) break;
			res = res*10+(c-'0'); 
		}
		return res*neg; 
	}
	
	/*
	 * check whether the the convert number will overflow, use string to compare because it is faster
	 */
	private boolean isOverflow(String s, int neg){
		if (neg==-1) {
			return s.compareTo(minStr) >0; 
		} else {
			return s.compareTo(maxStr)>0; 
		}
	}
	
	private boolean isValid(char c){
		return c>='0' && c<='9'; 
	}
	
	// test valid, invalid, overflow cases
	public static void main(String[] args){
		String[] array = new String[] {"+", "-", "-0", "+0", "123", "-123", "0000", "2342421004204322424224", "2abc33452",
				 "9223372036854775245"};
		StringToLong stl = new StringToLong(); 
		for (String s : array) {
			try {
				System.out.println(stl.stringToLong(s)); 
			} catch (Exception e){
				System.out.println("Exception of input String: " + e.getLocalizedMessage());
			}
		}	
	}
	
}

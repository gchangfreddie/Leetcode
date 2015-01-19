package question.hundred.to.last;

public class DecodeWays {
	public int numDecodings(String s) {
        if (s.length()==0 || s.charAt(0)=='0') return 0; 
        if (s.length()==1) return 1; 
        int[] count = new int[s.length()]; 
        count[0]=1; 
        if (Integer.parseInt(s.substring(0, 2)) <= 26) { 
            if (s.charAt(1)=='0') count[1]=1; //10
            else count[1]=2; //12 1,2
        } else{
            if (s.charAt(1)=='0') return 0; //30
            else count[1]=1; //35 3,5
        }
        for (int i=2; i<s.length(); i++) {
            int temp =0; 
            if (count[i-2]!=0) {
                if (s.charAt(i-1)!='0'&& Integer.parseInt(s.substring(i-1, i+1))<=26) temp+=count[i-2]; 
            }
            if (count[i-1]!=0){
                if (s.charAt(i)!='0') temp+=count[i-1]; 
            }
            if (temp==0) return 0; 
            count[i]=temp; 
        }
        return count[s.length()-1]; 
    }
	
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays(); 
		int res = dw.numDecodings("100"); 
		res = dw.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"); 
		System.out.println(res);
	}
}

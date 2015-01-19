package leetCode.arrayString;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(); 
        for (int i=0; i<s.length(); i++){
            while (i<s.length()&& s.charAt(i)==' ') i++; 
            if (i==s.length()) break;
            StringBuilder word = new StringBuilder(); 
            while(i<s.length()&&s.charAt(i)!=' ') {
                word.append(s.charAt(i)); 
                i++;
            }
            word.append(" "); 
            sb.insert(0, word); 
        }
        return sb.toString().trim(); 
    }
}

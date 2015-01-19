package RecursiveAndDP;
import java.util.*;
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>(); 
        if (s.length()==0 || dict.size()==0) return res; 
        boolean[] dp = new boolean[s.length()+1]; 
        for (int i=0; i<dp.length; i++) dp[i]=true; 
        word(s, dict, dp, res, "", 0); 
        return res; 
    }
    
    public boolean word(String s, Set<String> dict, boolean[] dp, List<String> res, String prefix, int start){
        if (s.length()==start) res.add(prefix.trim()); 
        else {
            boolean temp = false; 
            for (int i=start+1; i<=s.length(); i++){
                if (dp[i]&&dict.contains(s.substring(start, i))){
                    if (word(s, dict, dp, res, prefix+" "+s.substring(start, i), i)) 
                        temp=true; 
                }
            }
            if (!temp) dp[start]=false;
        }
        return dp[start]; 
    }
}

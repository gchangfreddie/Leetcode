package RecursiveAndDP;
import java.util.*;
public class GenerateParenthese {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>(); 
        generate(n, n, "", res); 
        return res; 
    }
    public void generate(int left, int right, String prefix, List<String> res) {
        if (left==0 && right==0) res.add(prefix);
        else {
            if (left>0) generate(left-1, right, prefix+"(", res);
            if (right>left) generate(left, right-1, prefix+")", res); 
        }
    }
}

package leetCode.arrayString;
import java.util.*;
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if (num.length<4) return res; 
        Arrays.sort(num); 
        for (int i=0; i<num.length-3; i++) {
            if (i>0 && num[i]==num[i-1]) continue; 
            for (int j=i+1; j<num.length-2; j++){
                if (j>i+1 && num[j]==num[j-1]) continue; 
                int m=j+1, k=num.length-1; 
                while(m<k){
                    if (num[i]+num[j]+num[m]+num[k]==target) {
                        List<Integer> temp = new ArrayList<Integer> (); 
                        temp.add(num[i]);  temp.add(num[j]);  temp.add(num[m]);  temp.add(num[k]); 
                        res.add(temp); 
                        m++; k--; 
                        while(m<k && num[m]==num[m-1]) m++; 
                        while(k>m && num[k]==num[k+1]) k--; 
                    } else {
                        if (num[i]+num[j]+num[m]+num[k]>target) k--;
                        else m++;
                    }
                }
            }
        }
        return res; 
    }
}

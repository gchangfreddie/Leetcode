package First30;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        sort(numbers, 0, numbers.length); 
        int low=0, high=numbers.length-1;
        while(low<high) {
        	int temp = numbers[low] + numbers[high] ; 
        	if (temp==target) break;
        	else if (temp<target) low++; 
        	else if (temp>target) high++; 
        }
        if (low<high) return new int[] {numbers[low], numbers[high]};
        else return null; 
    }
    
    private void sort(int[] array, int low, int high) {
    	if (low >= high-1) { // only one item in the subarray
            return; 
        }
    	int mid = low + (high-low)/2; 
    	sort(array, low, mid); 
    	sort(array, mid, high); 
    	merge(array, low, mid, high); 
    }
    
    private void merge(int[] a, int low, int mid, int high) {
        
        int l=low, m=mid, h=high, index=0;
        int[] aux = new int[high-low];  //aux is a temp array
        while(true) {
            if (m>=high) {
                while (l<mid) aux[index++] = a[l++]; 
                break;
            }
            if (l>=mid) {
                while (m<high) aux[index++] = a[m++]; 
                break;
            }
            if (a[l]<=a[m]) aux[index++] = a[l++]; 
            else aux[index++] = a[m++]; 
        } 
        // now aux is a sorted array
        for (int i=0; i<aux.length; i++) {
        	a[low+i] = aux[i]; 
        }
        // now a[low] to a[high-1] is a sorted array
    }
    
    public static void main(String[] args){
    	int[] a = new int[]{3,2,4}; //{15,7,21,1,33,4,9}; 
    	TwoSum ts = new TwoSum(); 
    	ts.sort(a, 0, a.length); 
    	int[] b = ts.twoSum(a, 6); 
    	
    	for (int i=0; i<b.length; i++){
    		System.out.print(" " + b[i]);
    	}
    	
    }
}
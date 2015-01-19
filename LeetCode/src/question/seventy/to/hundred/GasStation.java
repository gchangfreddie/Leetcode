package question.seventy.to.hundred;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas==null || gas.length==0 || cost==null || cost.length==0) return -1; 
//		if (gas.length==1) return gas[0]>=cost[0] ? 0: -1;  
		int[] amount = new int[gas.length]; 
		for (int i=0; i<gas.length; i++) {
			if (circuit(gas, cost, i, (i+1)%gas.length, gas[i]-cost[i], amount)) return i; 
		}
		return -1; 
	}

	public boolean circuit(int[] gas, int[] cost, int start, int current, int gasAmount, int[] amount) {
		//should first check the gasAmount<0
		if (gasAmount<0) {
			return false; 
		}    
		if (start==current) return true; 
		if (gasAmount<amount[current]) return false; 
		boolean res =  circuit(gas, cost, start, (current+1)%gas.length, gasAmount+gas[current]-cost[current], amount); 
		if (res==false) {
			amount[current] = gasAmount; 
		}
		return res; 
	}

	public static void main(String[] args) {
		GasStation gs = new GasStation(); 
		int index =gs.canCompleteCircuit(new int[]{4}, new int[]{5}); 
		System.out.println(index);
	}
}

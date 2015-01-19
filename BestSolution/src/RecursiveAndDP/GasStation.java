package RecursiveAndDP;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length==0 || cost.length==0) return -1; 
        for (int i=0; i<gas.length; i++) {
        	// note must be (i+1)%length, if i, when gas.length==1 always return true;
           if (gas[i]>=cost[i] && traverse(gas, cost, i, (i+1)%gas.length, gas[i]-cost[i])) return i; 
        }
        return -1; 
    }
    
    public boolean traverse(int[] gas, int[] cost, int start, int cur, int storage){
        if (cur==start) return true;
        if (gas[cur]+storage-cost[cur]>=0 && traverse(gas, cost, start, (cur+1)%gas.length, gas[cur]+storage-cost[cur]))
            return true; 
        return false; 
        
    }
}

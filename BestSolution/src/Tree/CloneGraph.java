package Tree;

import java.util.*;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node==null) return null; 
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
		dfs(map, node); 
		for (UndirectedGraphNode n : map.keySet()){
			ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>(); 
			for (UndirectedGraphNode connectNode : n.neighbors) {
				list.add(map.get(connectNode)); 
			}
			map.get(n).neighbors =list; 
		}
		return map.get(node); 
	}

	public void dfs(HashMap<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
		map.put(node, new UndirectedGraphNode(node.label)); 
		for (UndirectedGraphNode n : node.neighbors) {
			if (!map.containsKey(n)) {
				dfs(map, n); 
			}
		}
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

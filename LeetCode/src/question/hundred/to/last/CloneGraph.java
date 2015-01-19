package question.hundred.to.last;

import java.util.*;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node==null) return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); 
		queue.add(node); 
		UndirectedGraphNode res = new UndirectedGraphNode(node.label); 
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
		map.put(node, res); 
//		for (UndirectedGraphNode neighbor: node.neighbors) { //dfs
//			if (!marked.contains(neighbor))
//				cloneGraph(neighbor, res, marked); 
//		}
		while(!queue.isEmpty()) { //BFS
			UndirectedGraphNode n = queue.remove(); 
			UndirectedGraphNode cur = map.get(n); 
			for(UndirectedGraphNode neighbor: n.neighbors) {
				if (!map.containsKey(neighbor)) {
					queue.add(neighbor); 
					UndirectedGraphNode next = new UndirectedGraphNode(neighbor.label); 
					map.put(neighbor, next); 
				}
				cur.neighbors.add(map.get(neighbor)); 
			}
		}
		return res; 
	}
	
	public void cloneGraph(UndirectedGraphNode node, UndirectedGraphNode res, Set<UndirectedGraphNode> marked) {
		marked.add(node); 
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); 
		res.neighbors.add(newNode); 
		for (UndirectedGraphNode neighbor: node.neighbors) {
			if (!marked.contains(neighbor)) cloneGraph(neighbor, newNode, marked);
		}
		
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null)	return null;
    	HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
    	UndirectedGraphNode rootCopy = new UndirectedGraphNode(node.label);
    	map.put(node, rootCopy);
    	Queue<UndirectedGraphNode> q = new LinkedList<>();
    	q.add(node);
    	while(q.size() != 0) {
    		UndirectedGraphNode cur = q.poll();
    		UndirectedGraphNode copy = map.get(cur);
    		for(UndirectedGraphNode iter : cur.neighbors) {
    			if(!map.containsKey(iter)) {
    				map.put(iter, new UndirectedGraphNode(iter.label));
    				q.add(iter);
    			}
    			copy.neighbors.add(map.get(iter));
    		}
    	}
    	return rootCopy;
    }
}
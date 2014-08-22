public class LRUCache {
    
    static class Node {
        Node next = null;
        Node prev = null;
        int val = 0;
        int key = 0;

        public Node() {
        }

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer,Node> map;
    private int size; 

    public LRUCache(int capacity) {
        size = capacity;
        head = new Node();
        tail = head;
        map = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            append(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            append(node);
            node.val = value;
            return;
        }
        if(map.size() == size) {
            Node least = head.next;
            remove(least);
            map.remove(least.key);
        }
        Node nw = new Node(key,value);
        map.put(key,nw);
        append(nw);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
        else {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void append(Node node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
    }
}
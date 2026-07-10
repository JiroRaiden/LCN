class LRUCache {
    public class Node{
        Node next,prev;
        int key, value;
        Node(int key,int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    public final Map<Integer,Node> cache;
    public final int capacity;

    public final Node head;
    public final Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        cache = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        
        Node node=cache.get(key);
        if(node==null) return -1;

        deleteNode(node);
        addNodeHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node!=null)
        {
            node.value = value;
            deleteNode(node);
            addNodeHead(node);
        }
        else
        {
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addNodeHead(newNode);

            if(cache.size()>capacity)
            {
                Node lru = tail.prev;
                cache.remove(lru.key);
                deleteNode(lru);
            }
        }
    }

    public void addNodeHead(Node node)
    {
        Node headNext = head.next;
        head.next = node;
        node.prev= head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void deleteNode(Node node)
    {
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
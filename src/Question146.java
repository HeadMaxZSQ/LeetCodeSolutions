import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 【题解最优解】使用一个HashMap和一个自定义的双向链表来实现LRU存储。其中HashMap存储key和Node。注意双向链表只要记录伪头部和伪尾部即可。
 * 时间复杂度：O(1)
 * 空间复杂度：O(N)
 */
public class Question146 {

    class LRUCache {
        public class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            DLinkedNode() {}
            DLinkedNode(int _key, int _value) {key = _key; value = _value;}
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            //创建伪头部和伪尾部
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            //查找HashMap是否存在
            DLinkedNode node = cache.get(key);
            //如果不存在直接返回-1
            if (node == null) {
                return -1;
            }
            //如果存在，则将节点移动到链表头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            //查找HashMap是否存在
            DLinkedNode node = cache.get(key);
            if (node == null) {
                //如果不存在则创建节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                if (this.size == capacity) {
                    //如果容量已满，则需要删除最久未使用的节点
                    DLinkedNode lastNode = removeTail();
                    cache.remove(lastNode.key);
                    --size;
                }
                addToHead(newNode);
                cache.put(key, newNode);
                ++size;
            } else {
                //如果存在则直接更新
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }
}
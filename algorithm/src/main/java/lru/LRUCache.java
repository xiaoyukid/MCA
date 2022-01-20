//package lru;
//
//import java.util.HashMap;
//
///**
// * @author yuchao
// * @create 2021-11-10-3:53 下午
// */
//public class LRUCache<K, V> implements Cache<K, V> {
//
//    private int size;
//
//    private Map<K, LinkedListNode<CacheElement<K, V>>> linkedListNodeMap;
//    private DoublyLinkedList<CacheElement<K, V>> doublyLinkedList;
//
//    public LRUCache(int size) {
//        this.size = size;
//        this.linkedListNodeMap = new HashMap<>(size);
//        this.doublyLinkedList = new DoublyLinkedList();
//    }
//
//    @Override
//    public boolean put(K key, V value) {
//        CacheElement<K, V> item = new CacheElement<K, V>(key, value);
//        LinkedListNode<CacheElement<K, V>> newNode;
//        if (this.linkedListNodeMap.containsKey(key)) {
//            LinkedListNode<CacheElement<K, V>> node = this.linkedListNodeMap.get(key);
//            newNode = doublyLinkedList.updateAndMoveToFront(node, item);
//        } else {
//            if (this.size() >= this.size) {
//                this.evictElement();
//            }
//            newNode = this.doublyLinkedList.add(item);
//        }
//        if(newNode.isEmpty()) {
//            return false;
//        }
//        this.linkedListNodeMap.put(key, newNode);
//        return true;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }
//
//    public LinkedListNode<T> updateAndMoveToFront(LinkedListNode<T> node, T newValue) {
//        if (node.isEmpty() || (this != (node.getListReference()))) {
//            return dummyNode;
//        }
//        detach(node);
//        add(newValue);
//        return head;
//    }
//}

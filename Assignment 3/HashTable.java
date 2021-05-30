package com.company;
import java.util.LinkedList;

public class HashTable<K, V> {

    private class Node {
        private final K key;
        private  V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public LinkedList[] hashTable;

    public HashTable() {
        hashTable = new LinkedList[10];
    }

    public void insert(K key, V value) {
        Node newItem = getNode(key);
        if (newItem != null){
            newItem.value = value;
            return;
        }
        newBucket(key).add(new Node(key,value));
    }

    public void delete(K key) {
        Node item = getNode(key);
        if (item == null) {
            throw new IllegalStateException();
        }
        getBucket(key).remove(item);
    }

    public K get(K key) {
        Node item = getNode(key);
        if (item == null)
            return null;
        return (K) item.value;
    }

    private LinkedList getBucket(K key){
        return hashTable[hash((Integer) key)];
    }

    private LinkedList newBucket(K key){
        int index;
        index = hash((Integer) key);
        LinkedList bucket= hashTable[index];
        if (bucket == null) {
            hashTable[index] = new LinkedList<>();
            bucket = hashTable[index];
        }
        return bucket;
    }

    private Node getNode(K key) {
        LinkedList<Node> bucket = getBucket(key);
        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i++) {
                Node entry = bucket.get(i);
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private int hash(int key) {
        return key % hashTable.length;
    }


    public static void main(String[] args) {

        HashTable<Integer,String> hashTable = new HashTable();
        System.out.println("Hash Table: ");
        System.out.println("Insert element: ");
        hashTable.insert(1,"Algorithm ");
        hashTable.insert(2,"Sorting Algorithm");
        hashTable.insert(3,"Searching Algorithm");


        for (int i=1;i<4;i++){
            System.out.println(hashTable.get(i));
        }

        System.out.println("Delete key: ");
        hashTable.delete(2);

        for (int i=1;i<4;i++){
            System.out.println(hashTable.getNode(i));
        }

        hashTable.insert(4,"Graph algorithm");
        System.out.println(hashTable.getBucket(4));

    }
}

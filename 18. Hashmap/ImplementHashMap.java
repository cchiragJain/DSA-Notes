import java.util.*;

/* Check LC submission for a better answer */
public class ImplementHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer,Integer> hm = new MyHashMap<>();
        hm.put(1,1);
        hm.put(2,2);
        System.out.println(hm.get(2));
    }
}

class MyHashMap<K,V>{
    private class HMNode{
        K key;
        V value;

        HMNode(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    private int size; // n

    // array of linkedlist with hmnodes
    private LinkedList<HMNode>[] buckets; // N = buckets.length;

    // constructor
    public MyHashMap(){
        // make a array of size 4 ( 4 buckets )
        initbuckets(4);
        // no elements are present at the start
        this.size = 0;
    }

    public void put(K key,V value){
        int bucketIndex = hashFunction(key);
        int dataIndex = getIndexInBucket(key,bucketIndex);

        if(dataIndex == -1){
            // if not found insert it to the hashtable
            // create a new node
            HMNode node = new HMNode(key,value);
            // add to the last of the linked list present at the bucketIndex
            buckets[bucketIndex].addLast(node);
            this.size++;
        } else{
            // update the already existing value
            // get the node from the bucket
            HMNode node = buckets[bucketIndex].get(dataIndex);
            // update the value of the node
            node.value = value;
        }

        // rehashing to make sure that calls remain O(lambda) or constant
        // load factor
        double lambda = (size * 1.0) / buckets.length;

        if(lambda > 2){
            rehash();
        }
    }

    public V get(K key){
        int bucketIndex = hashFunction(key);
        int dataIndex = getIndexInBucket(key,bucketIndex);
        if(dataIndex == -1){
            return null;
        }

        // get the value of the node present in bucketIndex
        V value = buckets[bucketIndex].get(dataIndex).value;

        // value will be null by default
        return value;
    }

    public V remove(K key){
        int bucketIndex = hashFunction(key);
        int dataIndex = getIndexInBucket(key,bucketIndex);
        if(dataIndex == -1){
            return null;
        }

        V value = buckets[bucketIndex].get(dataIndex).value;
        buckets[bucketIndex].remove(dataIndex);
        this.size--;

        return value;
    }

    public boolean containsKey(K key){
        int bucketIndex = hashFunction(key);
        int dataIndex = getIndexInBucket(key,bucketIndex);

        return dataIndex != -1;
    }

    public int size(){
        return this.size;
    }

    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();

        // traverse the buckets array
        for(int i = 0;i < buckets.length;i++){
            // for each head of the linked list in the buckets array add all its node keys
            for(HMNode node:buckets[i]){
                keys.add(node.key);
            }
        }

        return keys;
    }
    
    private void initbuckets(int N){
        // bucket is a array of type linked list
        buckets = new LinkedList[N];
        for(int i = 0;i < buckets.length;i++){
            // each bucket is a linked list of hmnodes
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(K key){
        // hashcode is available on all data types in java
        int hashCode = key.hashCode();

        // hashcode could be negative and a large number as well
        // taking modulus buckets.length so will get it in between 0 to buckets.length 
        return (Math.abs(hashCode) % buckets.length);
    }

    private int getIndexInBucket(K key,int bucketIndex){
        int dataIndex = 0;

        for(HMNode node:buckets[bucketIndex]){
            // need to compare values and not references
            if(node.key.equals(key)){
                return dataIndex;
            }
            dataIndex++;
        }

        // if not found inside this bucket
        return -1;
    }

    /* this will be a costly operation of O(N) but doing this will make other operations O(constant) */
    private void rehash(){
        LinkedList<HMNode>[] oldBuckets = buckets;

        // make new buckets array of double the original size
        initbuckets(oldBuckets.length * 2);
        this.size = 0;

        // put old elements in the bucket array
        for(int i = 0;i < oldBuckets.length;i++){
            for(HMNode node:oldBuckets[i]){
                put(node.key,node.value);
            }
        }

    }
}

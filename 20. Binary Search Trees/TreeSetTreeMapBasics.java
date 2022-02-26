import java.util.*;

/* Mostly useful when need to do search insert delete operations but also need them to be in sorted order and also useful when need lower,higher,ceiling & floor values */
public class TreeSetTreeMapBasics {
    public static void main(String[] args) {
        // TREESET
        /* 
            Everything similar to hashset but uses a self balancing binary tree underneath and also stores value in a sorted order
            T.C -> O(logn) for operations
            Hashset does not maintain sorted order but a treeset does
         */

        // Adding and removing
        TreeSet<Integer> set = new TreeSet<>();
        set.add(6);
        set.add(5);
        set.add(100);
        set.add(1);
        set.add(10);

        System.out.println(set); // [1, 5, 6, 10, 100]

        set.remove(6);
        System.out.println(set);

        System.out.println(set.contains(1)); // true
        System.out.println(set.contains(12)); // false

        // TRAVERSING
        for(int val:set){
            System.out.print(val + " ");
        }

        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        System.out.println();

        // Lower,Higher,Floor,Ceiling
        // returns the lower value
        System.out.println(set.lower(4));
        // return higher value
        System.out.println(set.higher(4));

        // ceiling -> >=
        System.out.println(set.ceiling(4));
        // floor -> <=
        System.out.println(set.floor(4));

        // TREEMAP
        TreeMap<String,Integer> map = new TreeMap<>();
        // add remove
        map.put("Hello",12);
        map.put("Iello",13);
        map.put("jello",14);

        System.out.println(map);
        map.remove("Hello");
        System.out.println(map);

        System.out.println(map.containsKey("Hello"));

        // traversing
        Set<String> keys = map.keySet();
        for(String key:keys){
            System.out.println(key + " " + map.get(key));
        }

        // higherKey, lowerKey, floorKey, ceilingKey
        // does the provided operation for the given key
    }
}
import java.util.*;

public class HashMapHashSetBasics {
    public static void main(String[] args) {
        /* ------------------------HASHSET---------------------------- */
        HashSet<Integer> hs = new HashSet<>();
        hs.add(5);
        hs.add(2);
        hs.add(3);
        System.out.println(hs);

        hs.add(3); // only unique values are added
        System.out.println(hs);

        System.out.println(hs.contains(3));
        System.out.println(hs.contains(4));

        // TRAVERSING A SET
        for(int key:hs){
            System.out.print(key + " ");
        }
        System.out.println();
        // using the iterator class
        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        // REMOVE, Size, isEmpty
        hs.remove(3);
        System.out.println(hs);

        System.out.println(hs.size());
        
        System.out.println(hs.isEmpty());

        // Empty the entire set
        hs.clear();
        System.out.println(hs.size());

        System.out.println();

        /* ---------------------------HASHMAP------------------------- */
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Chirag",10);
        hm.put("Jain",20);

        System.out.println(hm);
        System.out.println(hm.size());

        System.out.println(hm.get("Jain"));
        System.out.println(hm.get(";asjd")); // null if key not present

        // Traversal
        // there are other ways as well
        Set<String> keys = hm.keySet(); // get all the keys
        for(String key:keys){
            System.out.println(key + " " + hm.get(key));
        }
        // use values if want to traverse using values
        hm.values();

        System.out.println(hm.containsKey("Chirag"));
        System.out.println(hm.containsKey("hirag"));

        System.out.println(hm.containsValue(20)); // not useful since values can be duplicated

        hm.remove("Jain"); // also returns the value of the removed key or null if not present
        System.out.println(hm);

    }
}
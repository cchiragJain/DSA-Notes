import java.util.*;

/* Contains ->
    1. Verical sum in binary tree
    2. Vertical Traversal
    3. Top view of binray tree
    4. Bottom view
*/

public class BinaryTreeQuestions4 {
    public static void main(String[] args) {
        Node root = new Node(1);
        /* 
                      1
                   /    \
                  2      3
                 / \    /  \
                4   5   6   7
                   /       / \
                  8       9  10
        */

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        // verticalSum(root);
        // verticalTraversal(root);
        // System.out.println(verticalTraversal(root));
        // topViewOfBinaryTree(root);
        bottomViewOfBinaryTree(root);
    }

    /* -----------------VERTICAL SUM IN BINARY TREE----------------------------
        Given root of a tree print vertical sum of all the nodes
        Print sum of levels but levels are vertical and print in order
    */
    // T.C -> If there are (index) entries in the treemap they are going to take log(index) time So overall it will take O(N log(index)) time
    // S.C -> O(N)
    public static void verticalSum(Node root){
        // key -> horizontal level,value -> sum of level
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        // for the root node the value will be 0
        // for root left it will be -1 and for right it will be +1
        verticalSumHelper(root,0,map);

        // iterate over the map 
        // values will be in sorted order since using treemap
        Set<Integer> keys = map.keySet();

        for(int key:keys){
            System.out.print(map.get(key) + " ");
        }
    }

    private static void verticalSumHelper(Node root,int pos,TreeMap<Integer,Integer> map){
        if(root == null){
            return;
        }
        // DOING inorder traversal here 
        // but can follow any traversal here

        // add nodes present on left side of tree to the map
        // if initial value is 0 of root node then left will have value of 0 - 1 = -1 on the horizontal scale
        verticalSumHelper(root.left,pos - 1,map);

        // get value against pos if previously present or put 0
        int sum = map.getOrDefault(pos,0);
        // put the new value with adding the current root data
        map.put(pos,root.data + sum);

        // make a call for right node
        verticalSumHelper(root.right,pos + 1,map);
    }

    /* -------------------VERTICAL TRAVERSAL OF BINARY TREE---------------------- */
    public static void verticalTraversal(Node root){
        // T.C -> O(n logn) treemap mein get put log n leta S.C -> O(N)
        /* Order -> First in level order comes first and left node comes first */
        /* 
            Do a level order traversal and in the queue store pair of horizontal distance and node
            After removing from queue check if exists and add to the existing treemap or create a new arraylist for the key of horizontal distance
            Call for left with horizontal distance of parent - 1 and for right with horizontal distance of parent + 1
        */

        // to store key -> horizontal index , value -> arraylist
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<>();

        // DOING A NORMAL LEVEL ORDER TRAVERSAL USING A QUEUE BUT ALSO USING A MAP TO STORE THE CURRENT NODE ACCORDINGLY IN A MAP

        // queue for level order traversal
        Queue<Pair2> q = new ArrayDeque<>();
        // root node will be 0
        q.offer(new Pair2(root,0));

        while(q.isEmpty() == false){
            Pair2 it = q.poll();
            Node curr = it.node;
            int hd = it.hd;

            if(map.containsKey(hd)){
                map.get(hd).add(curr.data);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.data);
                map.put(hd,list);
            }

            if(curr.left != null) {
                q.offer(new Pair2(curr.left,hd - 1));
            } 
            if(curr.right != null){
                q.offer(new Pair2(curr.right,hd + 1));
            }
        }
    }

    /* ------------------------TOP VIEW OF BINARY TREE--------------------------- 
        Preference to the left child
    */
    public static void topViewOfBinaryTree(Node root){
        // TreeMap ki key jo h uske basis pe sort hota h toh left vaaali posn pehle aaegi
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        // queue for level order traversal
        Queue<Pair2> q = new ArrayDeque<>();
        // root node will be 0
        q.offer(new Pair2(root,0));

        // similar to above question
        while(q.isEmpty() == false){
            Pair2 it = q.poll();
            Node curr = it.node;
            int hd = it.hd;

            // only add if the key does not exist
            // if key does not exist means first occurence of the horizontal distance so only add then
            // only want top level node
            if(map.containsKey(hd) == false){
                map.put(hd,curr.data);
            }

            if(curr.left != null) {
                q.offer(new Pair2(curr.left,hd - 1));
            } 
            if(curr.right != null){
                q.offer(new Pair2(curr.right,hd + 1));
            }
        }

        for(int key : map.keySet()){
            System.out.println(map.get(key));
        }
    }

    /* -----------------------BOTTOM VIEW OF BINARY TREE------------------------ */
    public static void bottomViewOfBinaryTree(Node root){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        // queue for level order traversal
        Queue<Pair2> q = new ArrayDeque<>();
        // root node will be 0
        q.offer(new Pair2(root,0));

        // similar to above question
        while(q.isEmpty() == false){
            Pair2 it = q.poll();
            Node curr = it.node;
            int hd = it.hd;

            // will keep on updating the value
            map.put(hd,curr.data);

            if(curr.left != null) {
                q.offer(new Pair2(curr.left,hd - 1));
            } 
            if(curr.right != null){
                q.offer(new Pair2(curr.right,hd + 1));
            }
        }

        for(int key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}

class Pair2{
    int hd;
    Node node;

    Pair2(Node node,int hd){
        this.node = node;
        this.hd = hd;
    }
}
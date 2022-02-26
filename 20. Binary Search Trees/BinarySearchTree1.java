import java.util.*;

/* 
    Refer notebook for examples
    BST ka inorder hamesha sorted
    Contains ->
        1. Search in BST
        2. Insert in BST
        3. Delete in BST
        4. Max in BST
        5. FLoor,Ceil in BST
        6. Ceiling on left side in an array
        7. Kth smallest in BST
        8. Check for BST
        9. Fix BST with two nodes swapped
        10. Pair Sum with given BST

    All question assumes that BST will have only distinct values
 */

public class BinarySearchTree1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < arr.length;i++){
            arr[i] = sc.nextInt();
        }

        Node root = new Node(20);
        /* 
                     20
                   /    \
                  15     30
                 / \       \
                12  18     40
               /          /  \
              7          35  50
        */

        root.left = new Node(15);
        root.left.left = new Node(12);
        root.left.right = new Node(18);
        root.left.left.left = new Node(7);
        root.right = new Node(30);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);
        root.right.right.right = new Node(50);

        // System.out.println(searchInBST(root,400));
        // insertBST(root,19);
        // System.out.println(levelOrder(root));
        // root = deleteBST(root,15);
        // System.out.println(levelOrder(root));
        // ceilingOnLeftSideOfArray(arr);
    }

    /* ---------------------SEARCH IN BINARY SEARCH TREE--------------------- 
        Given a BST and a key return if it exists in the tree or not
    */
    public static boolean searchInBST(Node root,int key){
        /* RECURSIVE T.C -> O(H) S.C -> O(H) */
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        } else if(key > root.data){
            return searchInBST(root.right,key);
        } else {
            return searchInBST(root.left,key);
        }

        /*
        ITERATIVE SOLUTION T.C -> O(H) S.C -> O(1)
        while(root != null){
            if(root.data == key){
                return true;
            } else if(root.data < key){
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return false;
        */
    }

    /* --------------------INSERT IN BST------------------------------------
        Given a BST and a key value insert it at the correct position
    */
    public static Node insertBST(Node root,int key){
        // RECURSIVE T.C -> O(H) S.C -> O(H)
        if(root == null){
            // agar leaf node h ya fir null node mila h starting mein toh naya node return kardo 
            // leaf hua toh pichli call ki vjah se parent se connect ho jaaega
            return new Node(key);
        }

        // connect karna jaruri h vanra base case mein node khaali memory mein ban jaaega connect nahi hoga parent se
        // baaki cases mein same hi rahega tree ka structure kyuki end mein root return kar rahe
        if(key > root.data){
            root.right = insertBST(root.right,key);
        } else if(key < root.data) {
            root.left = insertBST(root.left,key);
        }
        
        // if already present in the tree then no need to do anything also will return after inserting
        return root;

        /* ITERATIVE SOLUTION T.C -> O(H) S.C -> O(1)
            Similar to searching but maintain two ref nodes of parent = null and curr which will iterate and find where to insert also while finding keep checking if already exists or not in which case just return the root only
            After finding where to insert insert acoordingly to the parent node
        */
    }

    /* ------------------------DELETE IN BST-----------------------------
        Given a BST and key remove the key from it maintaining the bst property of the tree
        Refer notebook 
     */
    public static Node deleteBST(Node root,int key){
        // T.C -> O(H) S.C -> O(H)
        if(root == null){
            // if reached null means was not present in tree and no need to modify the tree then
            return null;
        }
        
        // first 2 conditions are same as insert only first find it and then connect
        if(key > root.data){
            root.right = deleteBST(root.right,key);
        } else if(key < root.data){
            root.left = deleteBST(root.left,key);
        } else {
            // idhar tab aaega jab equal hoga node key ke

            if(root.left != null && root.right != null){
                // both child are present case
                // find max on the left side
                int maxFromLeft = maxInBST(root.left);
                // update data to max
                root.data = maxFromLeft;
                // remove max from the tree
                // the max will always be at the 0 child or 1 child case
                root.left = deleteBST(root.left,maxFromLeft);

                return root;
            } 
            else if(root.left != null){
                // single child case
                return root.left;
            }
            else if(root.right != null){
                // single child case
                return root.right;
            } 
            else {
                // leaf node
                // remove the node 
                return null;
            }
        }

        return root;
    }

    /* -------------------MAXIMUM VALUE IN BST---------------------------------- 
        Min mein go left left left....
    */
    public static int maxInBST(Node root){
        // agar right exist karta h toh keep going there
        if(root.right != null){
            return maxInBST(root.right);
        }
        // agar no right is there means at the max only since left will have a smaller value 
        else {
            return root.data;
        }
    }

    /* ----------------------------FLOOR,CEIL IN BST-----------------------
        Given root & key of BST find floor of the tree
        Floor -> value equal or closest smaller than the key

        CEIL -> value equal or closest largest value than the key
                Bas ulti kardio condition
    */
    public static Node floorInBST(Node root,int key){
        // T.C -> O(H) S.C -> O(1)
        Node res = null;

        while(root != null){
            if(root.data == key){
                return root;
            } else if(root.data > key){
                // agar key chooti h toh right mein aur bade hi hoge so go to the left to find smaller
                root = root.left;
            } else {
                // agar key badi h toh current vaala bhi answer ho sakta ho aur root ke right mein jaaege jisse aur closest bhi mil sakta h key ke agar ho toh
                res = root;
                root = root.right;
            }
        }

        return res;
        /* NAIVE
            T.C -> O(N) & S.C -> O(N)
            Do any type of traversal and keep a closest smaller variable and keep updating it
            update when ans < arr[i] < key
        */
    }

    /* --------------------CEILING ON LEFT SIDE IN ARRAY------------------------- */
    public static void ceilingOnLeftSideOfArray(int[] arr){
        // T.C -> O(N logn) S.C -> O(N)
        TreeSet<Integer> set = new TreeSet<>();
        for(int val : arr){
            // ceiling -> closest greater or equal
            if(set.ceiling(val) != null){
                System.out.print(set.ceiling(val) + " ");
            } else {
                System.out.print(-1 + " ");
            }

            set.add(val);
        }

        /* NAIVE T.C -> O(N^2)
        System.out.print(-1 + " ");
        for(int i = 1;i < arr.length;i++){
            int ans = Integer.MAX_VALUE;
            for(int j = i - 1;j >= 0;j--){
                if(arr[j] >= arr[i]){
                    ans = Math.min(ans,arr[j]);
                }
            }
            if(ans == Integer.MAX_VALUE){
                System.out.print(-1 + " ");
            } else{
                System.out.print(ans + " ");
            }
        }
        */
    }

    public static int findKthSmallest(Node root,int k){
        /* if allowed to change the tree structure then can do it in O(log n) time by storing no of nodes in left subtree with every node
            For each node leftCount + 1 will be its k value
            if(leftCount + 1 < k) go to the right and give k as leftCount - k
        */
        
        /*
            * Naive would be to just do a inorder traversal of bst and stop when idx == k 
            * T.C -> O(N) S.C -> O(N)
            * Can reduce S.C -> O(H + K) if while doing inorder we keep a counter variable and stop when count reaches == k since inorder mein toh sorted hi hoga

            public int kthSmallest(TreeNode root, int k) {
                Ref count = new Ref(0);
                Ref ans = new Ref(0);
                kthSmallest(root,k,count,ans);
                return ans.val;
            }

            private void kthSmallest(TreeNode root,int k,Ref count,Ref ans){
                if(root == null){
                    return;
                }

                kthSmallest(root.left,k,count,ans);
                count.val++;
                if(count.val == k){
                    ans.val = root.val;
                }

                kthSmallest(root.right,k,count,ans);
            }
        */
        // to make work
        return -1;
    }
    
    /* ----------------------CHECK FOR BST-------------------------------------- */
    static long prev = Long.MIN_VALUE; // using long since node value can be Integer.MIN_VALUE as well
    public static boolean checkBST(Node root){
        /* 
            Simple preorder traversal where we check if current node is greater than left node and less than right node will not work since there can be cases where left subtree is a bst but may have a node that can be greater than the parent node 
        */
        /* 
            Correct but inefficient T.C -> O(N^2) worst case
            For every node get the max in left subtree and min in right subtree and current should be greater than max in left and less than min in right
            Will have to do O(H) operations for every node
            H can become n in case of skewed tree
        */

        /* 
            T.C -> O(N) S.C -> O(H)
            Do inorder and keep a array of inorder elements and keep checking if sorted or not T.C -> O(N) or keep a prev reference 
        */
        // prev previous node ka reference rakhta h jo traverse ho chuka h
        if(root == null) {
            return true;
        }

        if(checkBST(root.left) == false) {
            return false;
        }

        // duplicates exist kar sakte h isliye =
        if(root.data <= prev) {
            return false;
        }
        // store current as previous for the next node in traversal
        prev = root.data;
        
        return checkBST(root.right);
    }

    /* ------------------FIX BST WITH TWO NODES SWAPPED-------------------------- */
    /* static Node prev = null,first = null,second = null;
    // uncomment the code works just fine
    public static void fixBST(Node root){
        // T.C -> O(N)
        fixBSTHelper(root);
        // first will get the first value of anomaly in the inorder traversal
        // second will have the second node
        // swap the values of those nodes
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    private static void fixBSTHelper(Node root){
        if(root == null){
            return;
        }
        
        // do a simple inorder traversal
        fixBSTHelper(root.left);

        // check if for current node is the property of BST followed
        if(prev != null && root.data < prev.data){
            // the first will get updated only once
            if(first == null){
                first = prev;
            }
            // second can have different values
            // ex. second can just be the next value in the inorder or any other value that does not follow the property
            second = root;
        }

        // update prev for next node
        prev = root;

        fixBSTHelper(root.right);
    } */

    /* --------------------PAIR SUM WITH GIVEN BST-------------------------------
        Given a BST and a sum value find if a pair with that sum exists
    */
    public static boolean isPairPresent(Node root,int sum){
        /* NAIVE 
            T.C -> Theta(N) & S.C -> O(N)
            Store inorder in a list
            Since inorder will be in sorted order do a 2 pointer with low and high pointer like did in arrays question
        */
        // Better would be O(N) but will be better overall since will immediately return true
        return isPairPresent(root,sum,new HashSet<>());
    }

    private static boolean isPairPresent(Node root,int sum,HashSet<Integer> set){
        if(root == null){
            return false;
        }

        if(isPairPresent(root.left,sum,set)) return true;

        if(set.contains(sum - root.data)){
            return true;
        } else {
            set.add(root.data);
        }

        return isPairPresent(root.right,sum,set);
    }
}  

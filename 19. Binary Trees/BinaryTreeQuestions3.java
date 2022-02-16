import java.util.*;

/* 
    Contains ->
        1. Maximum width of binary tree 
        2. Print nodes at distance k from node
        3. Minimum time to burn a node (works for all nodes)
        4. Count total nodes in complete binary tree
        5. Construct binary tree from preoder/postorder & inorder traversals
        6. Convert binary tree to Doubly linked list
        7. Convert binary tree to linked list
        8. Serialize or Deserialize Binary Tree
*/

public class BinaryTreeQuestions3 {
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

        // System.out.println(maxWidthOfBinaryTree(root));
        // System.out.println(getNodesAtDistanceK(root,root.right.right,2));

        // System.out.println(minTimeToBurnLeaf(root,5));
    }

    /* ----------------------MAXIMUM WIDTH OF BINARY TREE----------------------
        Question on leetcode counts null nodes in the width as well if that was not the case could have just done a level order and keep max of levelCount size and return that
        Refer notebook for examples
    */
    public static int maxWidthOfBinaryTree(Node root){
        // T.C -> O(N) S.C -> O(N)
        // Doing a simple dfs only but using a deque and pair class for indexes
        // deque since need to get the last inserted element as well

        if(root == null){
            return 0;
        }
        
        Deque<Pair> q = new ArrayDeque<>();
        // using 0 based indexing
        q.offerLast(new Pair(root,0));
        
        // if not empty will have a width of 1 atleast
        int res = 1;

        while(q.isEmpty() == false){
            int levelCount = q.size();

            // get previous level sizes 
            // last node must have been inserted at the last and first node at first in the deque of the previous level
            int startIdx = q.peekFirst().val;
            int endIdx = q.peekLast().val;

            res = Math.max(res,endIdx - startIdx + 1);

            // traverse the previous level nodes and add their children to the queue with their indexes 

            for(int i = 0;i < levelCount;i++){
                Pair current = q.peekFirst();
                Node leftChild = current.node.left;
                Node rightChild = current.node.right;

                /*
                    we are not inserting null nodes to the deque but using indexing so that each node will have correct value 
                    ex.
                                            3 idx = 4
                    null(agle vaala ka apne app)    5 idx = (2 * 4 + 2 = 10)
                */
                if(leftChild != null){
                    q.offerLast(new Pair(leftChild,2 * current.val + 1));
                }
                if(rightChild != null){
                    q.offerLast(new Pair(rightChild,2 * current.val + 2));
                }

                // remove the parent node
                q.pollFirst();
            }
        }

        return res;
    }

    /* --------------------------NODES AT DISTANCE K--------------------------- */
    public static List<Integer> getNodesAtDistanceK(Node root,Node target,int k){
        // T.C -> O(N) S.C -> O(N)
        List<Integer> res = new ArrayList<>();

        /* 
            Get the path from root to node and reverse it to make it easier for levels
        */

        List<Node> path = getRootToNodePath(root,target);
        
        Collections.reverse(path);

        // for each node inside our paths print at kth level down
        // ex. if node = 7 path will be [7,3,1] after reversing
        // add nodes of 2 levels down for 7 , 1 level down for 3, 0 level down for 1
        // do a dry run for better understanding why works
        // abhi ke liye 7 ke liye jo 2 level down h woh 3 ke 1 level kam valle 7 ke liye utne distance par hi hoge
        for(int i = 0;i < path.size();i++){
            getKthLevelNodes(path.get(i),k,res,i == 0 ? null : path.get(i - 1));
            k--;
        }

        return res;
    }

    private static void getKthLevelNodes(Node root,int level,List<Integer> res,Node blocker){
        if(root == null || level < 0 || root == blocker){
            return;
        }   

        if(level == 0){
            res.add(root.data);
            return;
        }

        getKthLevelNodes(root.left,level - 1,res,blocker);
        getKthLevelNodes(root.right,level - 1,res,blocker);
    }

    private static List<Node> getRootToNodePath(Node root,Node node){
        List<Node> res = new ArrayList<>();
        getRootToNodePathHelper(root,node,res);
        return res;
    }

    private static boolean getRootToNodePathHelper(Node root,Node node,List<Node> res){
        if(root == null){
            return false;
        }

        // add current nodes data to the result
        res.add(root);

        // see if it is at the end of path
        if(root.data == node.data){
            return true;
        }

        // check if its left or right make a path to the end node
        if(getRootToNodePathHelper(root.left,node,res) || getRootToNodePathHelper(root.right,node,res)){
            return true;
        }
        
        // remove it from the path since can't form a path
        res.remove(res.size() - 1);

        // this node can't form a path to the given node
        return false;
    }

    /* -------------------------MINIMUM TIME TO BURN A TREE-------------------- */
    public static int minTimeToBurnLeaf(Node root,int target){
        // root ki depth initially
        Ref ans = new Ref(0);
        traverse(root,target,ans);
        return ans.val;
    }

    private static int traverse(Node root,int target,Ref ans){
        if(root == null){
            return 0;
        }

        if(root.data == target){
            // update answer to whichever side has the higher number of nodes
            int ld = getDepth(root.left);
            int rd = getDepth(root.right);

            ans.val = Math.max(ans.val, ld);
            ans.val = Math.max(ans.val, rd);

            // return the height
            return 1;
        }

        // search on the left node
        // if don't get a 0 means value was found in one of the nodes
        int distanceTillTarget = traverse(root.left,target,ans);

        if(distanceTillTarget != 0){
            // agar left mein mila toh root se kitna distance target ka aur root ke right mein kaha tak jaa sakte h
            ans.val = Math.max(ans.val,distanceTillTarget + getDepth(root.right));

            // root se target tak ki height
            return distanceTillTarget + 1;
        }

        distanceTillTarget = traverse(root.right,target,ans);

        if(distanceTillTarget != 0){
            ans.val = Math.max(ans.val,distanceTillTarget + getDepth(root.left));
            return distanceTillTarget + 1;
        }

        return 0;
    }

    private static int getDepth(Node node){
        if(node == null) return 0;
        return (1 + Math.max(getDepth(node.left),getDepth(node.right)));
    }

    /* ----------------------COUNT TOTAL NODES IN COMPLETE BINARY TREE-------------------- 
        Need to do in less than O(N) time
    */
    public static int countNodes(Node root){
        // T.C -> At max hum height of tree nodes tak hi traverse karege
        // T.C -> O(log n)(traverse ke liey) * O(log n)(height calculion)
        // T.C -> O((log n)^2) & S.C -> O(H)
        /* 
            Complete binary tree height -> O(log n)
            Agar ek perfect tree hota h toh nodes = 2^height - 1
            Complete mein last ke ilava toh baaki filled hote hi h
         */

        if(root == null){
            return 0;
        }
        
        // get left & right height
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        // inhi se islie check ho sakta h kyuki khaali last level hi filled nahi ho sakta aur jo hoge voh left ki side hoge right ki heigh mein last node jo left pe h voh count nahi hoga
        // if they are same means the tree is perfect as well and then
        // the no of nodes = 2^h -1
        if(leftHeight == rightHeight){
            return (((int) Math.pow(2,leftHeight)) - 1);
        }

        // current se nahi pata chala toh get nodes from left and right and add 1 for current
        int nodesFromLeft = countNodes(root.left);
        int nodesFromRight = countNodes(root.right);

        return (1 + nodesFromLeft + nodesFromRight);
    }

    private static int getLeftHeight(Node root){
        int count = 0;

        while(root != null){
            count++;
            // keep going towards left
            root = root.left;
        }

        return count;
    }

    private static int getRightHeight(Node root){
        int count = 0;

        while(root != null){
            count++;
            // keep going towards right
            root = root.right;
        }

        return count;
    }

    /* -----------------------CONSTRUCT BT FROM PREORDER & INORDER-------------------------
        Refer notebook for example and dry run
        Postorder mein bas index change ho jaaega root end mein hota h usmein
     */
    public static Node buildTree(int[] preorder,int[] inorder){
        // T.C -> O(N) S.C -> O(N)
        // used this to reduce this to O(N) from O(N^2)
        Map<Integer,Integer> keyMap = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            keyMap.put(inorder[i],i);
        }
        return buildTreeHelper(preorder,inorder,0,preorder.length - 1,new Ref(0),keyMap);
    }

    private static Node buildTreeHelper(int[] preorder,int[] inorder,int inStart,int inEnd,Ref preIdx,Map<Integer,Integer> keyMap){
        if(inStart > inEnd){
            return null;
        }

        // get the root node from preorder
        Node root = new Node(preorder[preIdx.val]);
        // agli call jab bhi hogi usmein agli value root hogi preorder ki
        preIdx.val++;

        // find the index of root node from preorder in inorder
        int inIdx = keyMap.get(root.data); 

        // Doing this will make the algorithm O(N^2) since for each call doing a O(N) linear serach as well
        // int inIdx = inStart;
        // for(int i = inStart;i <= inEnd;i++){
        //     if(inorder[i] == root.data){
        //         inIdx = i;
        //         break;
        //     }
        // }

        // inorder ke left vaale nodes root ke left hoge and right vaale nodes preorder mein right mein aaege
        // add left and right subtrees  
        root.left = buildTreeHelper(preorder,inorder,inStart,inIdx - 1,preIdx,keyMap);
        root.right = buildTreeHelper(preorder,inorder,inIdx + 1,inEnd,preIdx,keyMap);

        // return the root node
        return root; 
    }

    /* ----------------------CONVERT BINARY TREE TO DOUBLY LINKED LIST---------------------
        Linked list should be in the same order as a inorder traversal GFG
    */
    private static Node prev = null;
    public static Node convertBTToDLL(Node root){
        if(root == null){
            return root;
        }

        // doing a inorder traversal so keep going left
        Node head = convertBTToDLL(root.left);

        // process the current node

        if(prev == null){
            // at the initial node
            head = root;
        } else{
            // current left should be previous
            root.left = prev;
            // previous right should be current
            prev.right = root;
        }
        // update previous to current root for next iteration
        prev = root;

        // go right as in inorder traversal
        convertBTToDLL(root.right);

        // return the head of linked list
        return head;
    }

    /* ----------------------CONVERT BINARY TREE TO LINKED LIST----------------------------
        Linked list should be in the same order as a pre order traversal LC
    */
    public static void convertBTToLL(Node root){
        // T.C -> O(N) S.C -> O(N)
        // for iterative can do a iterative preorder traversal and after insert add previous peek right to current stack peek and previous peek left to null

        if(root == null) return; 
        
        // right left root kind reverse postorder
        convertBTToLL(root.right); 
        convertBTToLL(root.left); 
        
        // update root
        // prev will have technically the next node in the linked list
        root.right = prev;
        root.left = null; 
        prev = root; 
    }

    /* ----------------------SERIALIZE AND DESERIALIZE BINARY TREE------------------------
        Check this -> https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
     */
}
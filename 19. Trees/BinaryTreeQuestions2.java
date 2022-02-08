import java.util.*;

/* 
    Contains ->
        1. Zig Zag Traversal
        2. Boundary Traversal
        3. Vertical Order Traversal

*/

public class BinaryTreeQuestions2 {
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

        // System.out.println(zigZagTraversal(root));
        // System.out.println(printBoundaryTraversal(root));
    }

    /* ----------------------ZIG ZAG TRAVERSAL----------------------- */

    public static List<List<Integer>> zigZagTraversal(Node root){
        // T.C -> O(N) S.C -> O(N)
        // similar to level order traversal with a flag variable
        List<List<Integer>> wrapList = new ArrayList<List<Integer>>();
        if(root == null){
            return wrapList;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        // flag = 0 (left to right)
        // flag = 1 (right to left)
        int flag = 0;

        while(q.isEmpty() == false){
            // get number of nodes on the current level
            int levelCount = q.size();

            // level will store all the nodes at the current level according to the flag variable
            // using a linked list since O(1) time for insert at end and start
            LinkedList<Integer> level = new LinkedList<>();

            // for each node on the current level add their children if exists to the end of the queue and add parent according to the flag to a level
            for(int i = 0;i < levelCount;i++){
                Node leftChild = q.peek().left;
                Node rightChild = q.peek().right;

                // the adding & removing logic is same since we are just doing a level order traversal only difference is how we add it to the final answer

                // if child exists add them to the queue
                if(leftChild != null){
                    q.offer(leftChild);
                }
                if(rightChild != null){
                    q.offer(rightChild);
                }

                int parent = q.poll().data;

                /* 
                    if flag is 0 that means add left to right add normally
                    if flag is 1 however then need to add the current to the last of the overall level
                    if used a arraylist then add(0,parent) will take O(n) time therefore using a linked list based implementation since it will do these operations in O(1) 
                */
                if(flag == 0){
                    level.addLast(parent);
                } else {
                    level.addFirst(parent);
                }

            }

            // update flag value when the current level has changed
            flag = flag == 0 ? 1 : 0;

            // add list of current levels to the main list
            wrapList.add(level);
        }

        return wrapList;
    }

    /* -----------------------BOUNDARY TRAVERSAL-------------------------  */
    public static List<Integer> printBoundaryTraversal(Node root){
        // T.C -> O(h) + O(n) + O(h) -> O(N)
        // S.C -> O(N)

        /* 
            Boundary will contain
            left boundary without the leaf nodes
            leaf nodes
            reversed right boundary without the leaf nodes         
         */
         
        List<Integer> res = new ArrayList<Integer>();

        if(root == null){
            return res;
        }

        // only add the root node if not a leaf
        if(isLeaf(root) == false){
            res.add(root.data);
        }

        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);

        return res;
    }

    private static void addLeftBoundary(Node root,List<Integer> res){
        Node curr = root.left;

        while(curr != null){
            // only add the current node if not a leaf
            if(isLeaf(curr) == false){
                res.add(curr.data);
            }

            // if exists a left keep moving to the left 
            // only move to the right if left not exists
            if(curr.left != null){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static void addRightBoundary(Node root,List<Integer> res){
        // similar to add left boundary but keeps on adding the right

        Node curr = root.right;
        // the right boundary needs to be reversed in order to get the boundary traversal
        Stack<Integer> temp = new Stack<>();

        while(curr != null){
            if(isLeaf(curr) == false){
                temp.push(curr.data);
            }

            if(curr.right != null){
                curr = curr.right;
            } else{
                curr = curr.left;
            }
        }

        // since stack is LIFO last inserted will be the first ones to be added to the list
        while(temp.isEmpty() == false){
            res.add(temp.pop());
        }
        
    }

    private static void addLeaves(Node root,List<Integer> res){
        // basically doing a preorder traversal of the entire tree and if at any point node is a leaf add to the res
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }

        // checking for null safety since in base case directly checking root node and will lead to null pointer exception if not checked
        if(root.left != null){
            addLeaves(root.left,res);
        }

        if(root.right != null){
            addLeaves(root.right,res);
        }

    }

    private static boolean isLeaf(Node node){
        // to be a leaf node left and right should be null
        return (node.left == null && node.right == null);
    }

    /* -----------------------VERTICAL ORDER TRAVERSAL--------------------- */
    public static List<List<Integer>> verticalOrderTraversal(Node root){
        
    }
}
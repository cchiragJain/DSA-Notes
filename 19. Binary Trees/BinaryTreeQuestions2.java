import java.util.*;

/*  Refer notebook for question examples/ definitions
    Contains ->
        1. Zig Zag Traversal
        2. Boundary Traversal
        3. Left / Right View
        4. Check Symmetric 
        5. Print root to node path
        6. Lowest Common Ancestor
        7. Children Sum Property


        
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
        // printLeftView(root);

        // System.out.println(checkSymmetric(root));
        // System.out.println(printRootToNodePath(root,10));

        // System.out.println(lowestCommonAncestor(root,root.left.left,root.left.right.left).data);
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

    /* -----------------------BOUNDARY TRAVERSAL---------------------  */
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
            // leaf nodes are handles seperately
            if(isLeaf(curr) == false){
                res.add(curr.data);
            }

            // if exists a left keep moving to the left 
            // only move to the right if left not exists since then the boundary will include right 
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
        // basically doing a preorder traversal of the entire tree and if at any point node is a leaf node add to the res
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

    /* ----------------------LEFT VIEW OF BINARY TREE------------------- */
    public static void printLeftView(Node root){
        // ITERATIVE using a queue
        // Do a level order traversal but print only when on the left most node of a level
        // for right just print at i == levelCount - 1
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(q.isEmpty() == false){
            int levelCount = q.size();
            for(int i = 0;i < levelCount;i++){
                Node leftChild = q.peek().left;
                Node rightChild = q.peek().right;

                if(leftChild != null){
                    q.offer(leftChild);
                }

                if(rightChild != null){
                    q.offer(rightChild);
                }

                int parent = q.poll().data;

                // only print if at the left most node means starting of the level
                if(i == 0){
                    System.out.print(parent);
                }
            }
        }

        System.out.println();

        // RECURSIVE
        // keep a maxLevelReached till now global variable and only print if current level is greater than the maxLevel
        printLeftViewRecursiveHelper(root,1);
    }

    private static int maxLevelReached = 0; // will start from 0 since need to print the root node

    private static void printLeftViewRecursiveHelper(Node root,int currentLevel){
        if(root == null){
            return;
        }

        // in essence this is just a preorder traversal in which we are only printing if condition matches

        if(currentLevel > maxLevelReached){
            System.out.print(root.data);
            maxLevelReached = currentLevel;
        }

        printLeftViewRecursiveHelper(root.left,currentLevel + 1);
        printLeftViewRecursiveHelper(root.right,currentLevel + 1);
    }

    /* ----------------------CHECK BINARY TREE SYMMETRIC----------------------- */
    public static boolean isSymmetric(Node root){
        // T.C -> O(N) S.C -> O(N)
        if(root == null){
            return true;
        }

        // root ka left and root ka right se hi check hona start hoga
        return isSymmetricHelper(root.left,root.right);
    }

    private static boolean isSymmetricHelper(Node left,Node right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        /* 
                        1
                2               2
            3       4       4       3
        */
        // 2 aur 2 check ho raha idhar
        if(left.data != right.data){
            return false;
        }

        // pure ko symmetric hone ke liye left ke left aur right ke right && left ke right aur right ke left ko equal hona padega 
        return (
            isSymmetricHelper(left.left,right.right) && 
            isSymmetricHelper(left.right,right.left)
        );

        /* ITERATIVE
            Stack null hold kar sakta h varna check karna padta
            public boolean isSymmetric(TreeNode root) {
                if(root == null) return true;
                Stack<TreeNode> stack = new Stack<TreeNode>();
                stack.push(root.left);
                stack.push(root.right);
                while(!stack.empty()) {
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    if (left == null && right == null) continue;
                    else if (left == null || right == null || right.val != left.val) return false;
                    stack.push(left.left);
                    stack.push(right.right);
                    stack.push(left.right);
                    stack.push(right.left);
                }
                return true;
            }
         */
    }

    /* ------------------------PRINT ROOT TO NODE PATH------------------------- */
    public static List<Integer> printRootToNodePath(Node root,int val){
        // T.C -> O(N) S.C -> O(H)
        List<Integer> res = new ArrayList<>();
        printRootToNodePathHelper(root,val,res);

        return res;
    }

    private static boolean printRootToNodePathHelper(Node root,int val,List<Integer> res){
        if(root == null){
            return false;
        }

        // add current nodes data to the result
        res.add(root.data);

        // see if it is at the end of path
        if(root.data == val){
            return true;
        }

        // check if its left or right make a path to the end node
        if(printRootToNodePathHelper(root.left,val,res) || printRootToNodePathHelper(root.right,val,res)){
            return true;
        }
        
        // remove it from the path since can't form a path
        res.remove(res.size() - 1);

        // this node can't form a path to the given node
        return false;
    }

    /* ----------------------LOWEST COMMON ANCESTOR---------------------------- */
    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        // T.C -> O(N) & S.C -> O(N) for recursive call stack only
        // even though same Comp. this will be a better solution overall.

        /* 
            if at a null node return that
            if p == root return p no need to check further and same for q
         */
        if(root == null || root == p || root == q){
            return root;
        }

        // have written it in a such a way that will only return the answer else will return null
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);

        if(left == null){
            return right;
        } else if(right == null){
            return left;
        } else {
            // both left and right not null means got the answer
            return root;
        }

        /* NAIVE T.C -> O(N) S.C -> O(N) but still need to do 2 traversals and store 2 lists
            Get the path from root node to node1 and node2 using previous question
            Iterate through the path list and keep on iterating as long as we have a common element in both at the same position and maintain it
            ex. lca(4,8) of above tree
            path4 = [1,2,4] path8 = [1,2,5,8]
            Stop at 2 that is the lowest common
         */
    }

    /* ----------------------CHILDREN SUM PROPERTY----------------------------- */
    public static boolean childrenSumProperty(Node root){
        if(root == null){
            // null node will have sum 0
            return true;
        }
        
        if(root.left == null && root.right == null){
            // acc. to question leaves follow the property
            return true;
        }
        
        // calculate current node child's sum
        int sum = 0;
        if(root.left != null){
            sum += root.left.data;
        }
        
        if(root.right != null){
            sum += root.right.data;
        }
        
        return (
            (root.data == sum)
            && (childrenSumProperty(root.left) == true)
            && (childrenSumProperty(root.right) == true)
        );
    }
}
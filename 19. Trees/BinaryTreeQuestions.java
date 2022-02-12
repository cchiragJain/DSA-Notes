import java.util.*;

/* 
    Contains ->
        1. Preorder (Recursive & Iterative)
        2. Postorder (Recursive & Iterative)
        3. Inorder (Recursive & Iterative)
        4. Levelorder (Using queue Iterative)
        5. Alltraversals in one(using pair class)
        6. Height, Size, Max/Min of binary tree
        7. Check Balanced Binary tree
        8. Get Diameter
        9. Get Maximum Path sum
        10. Check Identical Trees
*/
public class BinaryTreeQuestions {
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

        // preorder(root);
        // System.out.println();

        // inorder(root);
        // System.out.println();

        // postorder(root);
        // System.out.println();

        // System.out.print(levelOrder(root));

        // preorderIterative(root);

        // inorderIterative(root);

        // postorderIterative(root);

        // List<List<Integer>> res = allTraversalsInOne(root);
        // for(List<Integer> list: res){
        //     System.out.println(list);
        // }

        // System.out.println(isBalancedBinaryTreeNaive(root));
        // System.out.println(isBalancedBinaryTreeEfficient(root));

        // System.out.println(getDiameterNaive(root));

        // System.out.println(getMaximumPathSum(root));

    }

    /* ------------------------TRAVERSALS--------------------------- */

    /* Root left right */
    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /* left root right */
    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    /* left right root */
    public static void postorder(Node root){
        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    /* Using a list since LC uses it for their questions */
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> wrapList = new ArrayList<List<Integer>>();
        if(root == null){
            return wrapList;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(q.isEmpty() == false){
            // get number of nodes on the current level
            int levelCount = q.size();

            // level will store all the nodes at the current level
            List<Integer> level = new ArrayList<>();

            // for each node on the current level add their children if exists to the end of the queue and add parent to a level
            for(int i = 0;i < levelCount;i++){
                Node leftChild = q.peek().left;
                Node rightChild = q.peek().right;

                // if child exists add them to the queue
                if(leftChild != null){
                    q.offer(leftChild);
                }
                if(rightChild != null){
                    q.offer(rightChild);
                }

                int parent = q.poll().data;
                level.add(parent);
            }

            // add list of current levels to the main list
            wrapList.add(level);
        }

        return wrapList;
    }

    /* root left right*/
    public static void preorderIterative(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(st.isEmpty() == false){
            root = st.pop();
            System.out.print(root.data + " ");

            // push right first since this will come out later then since stack follows LIFO order
            // preorder is root left right and want right to come out later
            if(root.right != null){
                st.push(root.right);
            }

            if(root.left != null){
                st.push(root.left);
            }
        }
    }

    /* left root right */
    public static void inorderIterative(Node root){
        Stack<Node> st = new Stack<>();

        while(true){
            if(root != null){
                /* if current value is not null keep pushing values to the stack and going to the left value */
                st.push(root);
                root = root.left;
            } else{
                // could also happen that the stack becomes empty means have traversed the entire tree
                if(st.isEmpty()){
                    // break the while loop
                    break;
                }

                // will happen if there is a null value on the left
                // need to print the value whose left is null (will be the root for that subtree and go to its right)
                root = st.pop();
                System.out.print(root.data + " ");
                
                root = root.right;
            }
        }
    }

    /* left right root  */
    public static void postorderIterative(Node root){
        Stack<Node> helper = new Stack<>();
        Stack<Node> postorder = new Stack<>();

        Node node = root;
        helper.push(node);

        while(helper.isEmpty() == false){
            node = helper.pop();
            postorder.push(node);

            if(node.left != null){
                helper.push(node.left);
            }
            if(node.right != null){
                helper.push(node.right);
            }
        }

        while(postorder.isEmpty() == false){
            System.out.print(postorder.pop().data + " ");
        } 
    }

    /* traverses in all three ways using a single traversal */
    
    
    public static List<List<Integer>> allTraversalsInOne(Node root){
        List<List<Integer>> wrapList = new ArrayList<List<Integer>>();

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();

        // push the root node with val of 1
        st.push(new Pair(root,1));

        while(st.isEmpty() == false){
            Pair it = st.peek();

            if(it.val == 1){
                // add the value of the current node to preorder
                preOrder.add(it.node.data);
                // increase val to 2 to let it go for inorder
                it.val++;

                // if left exists go to
                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            } else if(it.val == 2){
                inOrder.add(it.node.data);

                it.val++;

                // if right exists
                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            } else if(it.val == 3){
                postOrder.add(it.node.data);
                st.pop();
            }
        }

        wrapList.add(preOrder);
        wrapList.add(inOrder);
        wrapList.add(postOrder);

        return wrapList;

        /* recursive implementation probably not something the interviewer would want
        public static void allTraversalsInOne(Node root,List<Integer> preorder,List<Integer> inorder,List<Integer> postorder){
            if(root == null){
                return;
            }
    
            preorder.add(root.data);
            allTraversalsInOne(root.left,preorder,inorder,postorder);
            inorder.add(root.data);
            allTraversalsInOne(root.right,preorder,inorder,postorder);
            postorder.add(root.data);
        } 
        */
    }

    /* -----------------------HEIGHT,SUM,MIN/MAX--------------------- */

    public static int getHeight(Node root){
        if(root == null){
            // think of this as if no node then the size of the tree formed will be 0
            return 0;
        }

        int heightFromLeft = getHeight(root.left);
        int heightFromRight = getHeight(root.right);

        // add 1 for the current node
        return 1 + Math.max(heightFromLeft,heightFromRight);
    }

    public static int size(Node root){
        if(root == null){
            // think of this as if no node then the size of the tree formed will be 0
            return 0;
        }

        int sizeFromLeft = size(root.left);
        int sizeFromRight = size(root.right);

        return 1 + sizeFromLeft + sizeFromRight;
    }

    /* minimum will work in a similar way */
    public static int maximumValueOfTree(Node root){
        // this is the code quality that should be used for interviews
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int maxValueFromLeftSubtree = maximumValueOfTree(root.left);
        int maxValueFromRightSubtree = maximumValueOfTree(root.right);

        // get the max value from left subtree & right subtree
        int maxValueOfSubtrees = Math.max(maxValueFromLeftSubtree,maxValueFromRightSubtree);
        
        // compare current with maxValueOfSubtrees and that will be the maximum
        return Math.max(root.data,maxValueOfSubtrees);
    }
    
    /* -------------------CHECK BALANCED BINARY TREE----------------- */

    public static boolean isBalancedBinaryTreeNaive(Node root){
        // T.C -> O(n^2)
        if(root == null){
            // a null node will be balanced since left and right diff will be 0 
            return true;
        }

        // get height of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // check if the root node is balanced or not
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        // check left and right nodes if they are balanced
        boolean isLeftBalanced = isBalancedBinaryTreeNaive(root.left);
        boolean isRightBalanced = isBalancedBinaryTreeNaive(root.right);

        if(isLeftBalanced == false || isRightBalanced == false){
            return false;
        }
        
        return true;
    }

    public static boolean isBalancedBinaryTreeEfficient(Node root){
        // T.C -> O(n)
        // helper will return -1 if any of the tree not tree balanced 
        return isBalancedBinaryTreeEfficientHelper(root) != -1;
    }

    public static int isBalancedBinaryTreeEfficientHelper(Node root){
        // T.C -> O(n)
        if(root == null){
            return 0;
        }

        // get height of left and right subtrees of the current node
        int leftHeight = isBalancedBinaryTreeEfficientHelper(root.left);
        int rightHeight = isBalancedBinaryTreeEfficientHelper(root.right);

        // if height is returned as -1 then this means that one or both of them are not balanced return -1 then.
        // if any of the subtree is not balanced then the whole tree is not balanced
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        
        // isBalancedBinaryTreeEfficientHelper if the current node is balanced or not
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        // if all balanced return the height
        return 1 + Math.max(leftHeight,rightHeight);
    }

    /* --------------------DIAMETER OF BINARY TREE------------------- */
    public static int getDiameterNaive(Node root){
        // T.C -> O(n^2)
        // in each call of getDiameterNaive also calling getHeight() which is a O(n) call in itself
        if(root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int diameter = leftHeight + rightHeight;

        int leftDiameter = getDiameterNaive(root.left);
        int rightDiameter = getDiameterNaive(root.right);

        int maximumDiameterFromSubtree = Math.max(leftDiameter,rightDiameter);

        return Math.max(diameter,maximumDiameterFromSubtree);
    }

    public static int getDiameterEfficient(Node root){
        // T.C -> O(n)

        // need to create this or use a global variable generally not preferred 
        int[] diameter = new int[1];
        getDiameterEfficientHelper(root,diameter);
        return diameter[0];
    }

    private static int getDiameterEfficientHelper(Node root,int[] d){
        if(root == null){
            return 0;
        }

        // get height of left and right subtree
        int leftHeight = getDiameterEfficientHelper(root.left,d);
        int rightHeight = getDiameterEfficientHelper(root.right,d);

        // at every node calculate the maximum of diameter found till date and of the path that passes throught the current node
        d[0] = Math.max(d[0],leftHeight + rightHeight);

        // return height normally
        return 1 + Math.max(leftHeight,rightHeight);
    }

    /* -------------------------MAXIMUM PATH SUM--------------------- */
    public static int getMaximumPathSum(Node root){
        // T.C -> O(n)

        // int[] maxSum = new int[1];
        // maxSum[0] = Integer.MIN_VALUE;

        Ref maxSum = new Ref(Integer.MIN_VALUE);
        getMaxPathSumDown(root,maxSum);
        return maxSum.val;
    }

    private static int getMaxPathSumDown(Node root,Ref maxSum){
        // for any node will return the max sum path on the down on the left or right
        if(root == null){
            return 0;
        }
        
        // get the max path sum on the left & right
        // if left or right returns 0 that means they had negative path sum and don't want to include that in the max sum
        int left = Math.max(0,getMaxPathSumDown(root.left,maxSum));
        int right = Math.max(0,getMaxPathSumDown(root.right,maxSum));

        // update maxSum if the current nodes path > maxSum
        // max sum will be always in this shape -> Λ (umbrelaa shape)
        // even if left or right 0 then 0 will be added
        maxSum.val = Math.max(maxSum.val,left + right + root.data);

        // return the max path sum on down and add the current data
        // will be the max path sum for its parent node
        return Math.max(left,right) + root.data;
    }

    /* -------------------------CHECK SAME TREE---------------------- */
    public static boolean isSameTree(Node p,Node q){
        /* 
            To have a iterative solution use two deque and add the initial nodes at the last of the deque
            while deque is not empty
                remove the front elements and send them to a check function similar to below if elses
                if this returns false return false and the while loop will break
                if p not null
                    then add the child left and right nodes to both the deque of p and q
         */
        if(p == null && q == null) return true;
        
        // since already checking for null equality above.
        if(p == null || q == null) return false;
        
        // check if the current nodes has same data
        // then check if the left nodes are same
        // then check if the right nodes are same
        // better to use this preorder traversal since best case will be O(1) in this case if the first node is different itself
        return (
            (p.data == q.data) && 
            isSameTree(p.left,q.left) &&
            isSameTree(p.right,q.right)
        );
    }
}
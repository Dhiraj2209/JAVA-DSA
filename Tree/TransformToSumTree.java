public class TransformToSumTree {
    
    static class Node { // Node of Tree

        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right= null;
        }
    }

    public static int transformTree(Node root){
        if(root == null){
            return 0;
        }

        int leftchild = transformTree(root.left);
        int rightchild = transformTree(root.right);

        int data = root.data;
        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;
        
        root.data = newleft + leftchild +newright + rightchild;

        return data;
    }   

    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static boolean isUnivalued(Node root, int val) {
        if (root == null) {
            return true;
        }
    
        if (root.data != val) {
            return false;
        }
    
        return isUnivalued(root.left, val) && isUnivalued(root.right, val);
    }
    

    public static void main(String arg[]){
        /*
                 1
               /   \
              2     3
             / \   / \
            13  5 48  6      
        */
        
        /*
        Expected output
                 77
               /    \
              18     54
             /  \   /  \
            0    0 0    0     
        */

        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.right = new Node(1);
        root.left.left = new Node(10);
        // root.right.right = new Node(6);
        // root.right.left = new Node(48);

        // transformTree(root);
        // preOrderTraversal(root);
        System.out.println(isUnivalued(root, root.data));
    }
}

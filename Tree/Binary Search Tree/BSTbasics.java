public class BSTbasics {

    static class Node {
    
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
    }

    public static Node insertNodeinBST(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data < val){
            root.right = insertNodeinBST(root.right, val);
        }
        else {
            root.left = insertNodeinBST(root.left, val);
        }

        return root;
    }

    public static boolean IsAvalibleInBST(Node root, int val){ //O(h)
        if(root == null){
            return false;
        }

        if(root.data == val){
            return true;
        }

        if(val > root.data){
            return IsAvalibleInBST(root.right, val);
        }
        else {
            return IsAvalibleInBST(root.left, val);
        }
    }

    public static Node delet(Node root, int val){ //O(n)
        if(root.data < val){
            root.right = delet(root.right, val);
        }
        else if(root.data > val){
            root.left = delet(root.left , val);
        }
        else {

            //leaf node
            if(root.right == null && root.left == null){
                return null;
            }

            //single node
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //both children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delet(root.right, IS.data);
        }
        return root;
    }
    
    public static Node findInOrderSuccessor(Node root){// most left element 
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public static void inOrderTraversal(Node root){
    
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        
        int values[] = {80,6,-1,522,-10,5,87,4};
        Node root = null;

        for(int i:values){
            root = insertNodeinBST(root, i);
        }
        inOrderTraversal(root);
        // IsAvalibleInBST(root, 6);
        System.out.println(IsAvalibleInBST(root, -100));
        delet(root, 5);
        inOrderTraversal(root);
    }
}

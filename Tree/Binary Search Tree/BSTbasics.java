
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

    public static boolean IsAvalibleInBST(Node root, int val){
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
        // for(int i = 0 ; i < values.length ;i++){
        //     root = insertNodeinBST(root, values[i]);
        // }
        inOrderTraversal(root);
        // IsAvalibleInBST(root, 6);
        System.out.println(IsAvalibleInBST(root, -10));
    }
}

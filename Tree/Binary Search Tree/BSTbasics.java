import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        
        if(root.data >= k1  && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
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

    public static void levelOrder(Node root){ //O(n)
        if(root  == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void printPath(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        
        path.add(root.data);
        
        if(root.left == null && root.right == null){
            System.out.print("\npath : " + path);
        }
        printPath(root.left, path);
        printPath(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min , Node max){

        if(root == null){ // if there is no node in tree
            return true;
        }

        if(min != null && root.data <= min.data || max != null && root.data >= max.data){
            return false;
        }
        
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max); // both left and right part are valid BST
    }

    public static void main(String[] args) {
        
        int values[] = {80,659,16,522,10,5,3,1,4};
        Node root = null;

        for(int i:values){
            root = insertNodeinBST(root, i);
        }
        inOrderTraversal(root);
        IsAvalibleInBST(root, 6);
        System.out.println("\n Is avalible in BST : " + IsAvalibleInBST(root, 80));
        delet(root, 5);
        inOrderTraversal(root);
        levelOrder(root);
        System.out.println();
        printInRange(root, 0, 87);
        printPath(root, new ArrayList<>());
        System.out.println("\n Is given binary tree is valid : "+isValidBST(root, null, null));

    }
}

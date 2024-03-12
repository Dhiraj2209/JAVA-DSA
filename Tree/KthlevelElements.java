import java.util.*;

public class KthlevelElements {
    
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

    public static void KthlevelElement(Node root, int k){ //By iteration(Level order Traversal) O(n)
        Queue<Node> q = new LinkedList<>();

        if(root == null){ // base case
            return;
        }

        q.add(root); // add root
        q.add(null); // null after every level is completed (this is for level 1 complition)
        int level = 1;

        while(!q.isEmpty()){
            Node curr =q.remove(); 

            if(curr == null){
                level++;
                if(!q.isEmpty()){
                    q.add(null); //(null for level completion)
                }
                else {
                    break;
                }
            }
            else {
                if(level == k){ // Printing Kth level Elements
                    System.out.print(curr.data + " ");
                }
                if(curr.left !=  null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            if(level == k+1){
                break;
            }
        }
    }

    private static void kLevel(Node root, int level, int k){// By recursion O(n)
        if(root == null){ // Base case
            return;
        }

        if(level == k){ //Level equals to k
            System.out.print(root.data + " ");
            return;
        }

        kLevel(root.left, level + 1, k); // recursive call to left subtree
        kLevel(root.right, level + 1, k); // recursive call to right subtree
    }

    public static void main(String arg[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(13);
        root.right.right = new Node(6);

        System.out.print("By Iteration : ");
        KthlevelElement(root,3);
        System.out.print("\nBy recursion : ");
        kLevel(root, 1, 2);
    }
}

import java.util.*;

public class LowestCommonAncestor {

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

    public static boolean getPath(Node root, int n ,ArrayList<Node> path){ // get path from root to node , storing in to arraylist
        if(root == null){ // basecase
            return false;
        }
        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundleft  = getPath(root.left, n , path); // recursive call
        boolean foundright  = getPath(root.right, n , path);

        if(foundleft || foundright){
            return true;
        }

        path.remove(path.size() - 1); // if leaf is not a final node then remove from path
        return false;
    }

    public static Node LowestCommAncestor(Node root, int n1, int n2){ //O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i= 0;
        for(; i < path1.size() &&  i < path2.size() ;i++){ // checking if there is a common ancestor availble 
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i-1);
        return lca;
    }
    public static void main(String arg[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(13);
        root.right.right = new Node(6);

        System.out.println(LowestCommAncestor(root, 13,5).data);
    }
}
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

    public static Node lca(Node root,int n1, int n2 ){ //O(n)
        if(root == null ||root.data == n1 || root.data == n2){
            return root;
        }

        Node lcaLeft = lca(root.left, n1,n2);
        Node lcaRight = lca(root.right, n1,n2);

        if(lcaRight == null){
            return lcaLeft;
        }
        if(lcaLeft == null){
            return lcaRight;
        }

        return root;
    }
    
    public static int lcaDist(Node root, int n){ // Dist betwen lca node and node n
        if(root == null){ 
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftds = lcaDist(root.left, n);
        int rightds = lcaDist(root.right, n);

        if(leftds == -1 && rightds == -1){
            return -1;
        }
        else if(leftds == -1) {
            return rightds +1;
        }
        else {
            return leftds +1;
        }
    }

    public static int minDistanceBetweenNodes(Node root, int n1, int n2){ // Min distance between two nodes. // O(n)
        Node lca = lca(root, n1, n2);
        int dis1 = lcaDist(lca,n1);
        int dis2 = lcaDist(lca,n2);

        return dis1 +dis2;
    }

    public static int KAncestor(Node root, int n , int k){
        if(root == null){
            return -1;
        }

        if(root.data ==n){
            return 0;
        }


        int leftd = KAncestor(root.left, n, k);
        
        int rightd = KAncestor(root.right, n, k);

        if(leftd == -1 && rightd == -1){
            return -1;
        }

        int max = Math.max(leftd, rightd);
        if(max+1 == k){
            System.out.println("Kth ancestor : "+root.data);
        }

        return max+1;
        
    }


    public static void main(String arg[]){
        /*
                1
               / \
              2   3
             / \   \
            13  5   6      
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(13);
        root.right.right = new Node(6);

        System.out.println("Lowest Common Ancestor : " + LowestCommAncestor(root, 13,5).data);
        System.out.println("Lowest Common Ancestor : " + lca(root, 13,6).data);
        System.out.println("Minimum distance between nodes : " + minDistanceBetweenNodes(root, 5, 6));
        // System.out.println("Kth Ancestor : " + KAncestor(root, 5, 2));

        KAncestor(root, 13, 1);
    }
}
public class BinaryTree {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.right = null;
            this.left =null;
        }
    }

    static class Binarytree {

        static int idx = -1;

        public Node buildtree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newnode = new Node(nodes[idx]);

            newnode.left = buildtree(nodes);
            newnode.right = buildtree(nodes);

            return newnode;
        }
    }

    public static void preOrder(Node root){ //O(n)
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String args[]){
        int nodes[] = {8,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Binarytree tree = new Binarytree();

        Node root = tree.buildtree(nodes);


        System.out.println(root.data);
        System.out.println(root.left.data);

        preOrder(root);
    }
}

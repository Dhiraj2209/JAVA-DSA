import java.util.LinkedList;
import java.util.Queue;

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

        public void preOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    
        public void inOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    
        public void postOrder(Node root){ //O(n)
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root){ //O(n)
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

        public int heightOfTree(Node root){ //O(n)
            if(root == null){
                return 0;
            }

            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);

            return Math.max(lh, rh) + 1 ;
        }

        public int countOfNodes(Node root){ //O(n)
            if(root == null){
                return 0;
            }

            int l = countOfNodes(root.left);
            int r = countOfNodes(root.right);

            return l + r +1;
        }

        public int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int lsum = sumOfNodes(root.left);
            int rsum = sumOfNodes(root.right);

            return lsum + rsum + root.data;
        }

        public int diameterOfTree(Node root){ //O(n^2)
            if(root == null){
                return 0;
            }

            int leftdia = diameterOfTree(root.left);
            int lh = heightOfTree(root.left);
            int rightdia = diameterOfTree(root.right);
            int rh = heightOfTree(root.right);

            int selfdia = lh + rh + 1 ;

            return Math.max(selfdia , Math.max(leftdia, rightdia));
        }

        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.ht = ht;
                this.diam = diam;
            }
        }

        public Info diamOfTree(Node root){ //  O(n)
            if(root == null){
                return new Info(0,0);
            }

            Info leftinfo = diamOfTree(root.left);
            Info rightinfo = diamOfTree(root.right);

            int diam = Math.max(leftinfo.diam , Math.max(rightinfo.diam, (leftinfo.ht + rightinfo.ht + 1)));
            int ht = Math.max(leftinfo.ht, rightinfo.ht) + 1;

            return new Info(diam, ht);
        }
    }

    

    public static void main(String args[]){
        int nodes[] = {8,2,-1,-1,4,-1,-1};

        Binarytree tree = new Binarytree();

        Node root = tree.buildtree(nodes);

        System.out.println(root.data);
        System.out.println(root.left.data);

        System.out.print("Preorder : ");
        tree.preOrder(root);
        System.out.print("\nInorder : ");
        tree.inOrder(root);
        System.out.print("\npostorder : ");
        tree.postOrder(root);

        System.out.print("\nLevelorder : \n");
        tree.levelOrder(root);

        System.out.println("Height of tree : " + tree.heightOfTree(root));
        
        System.out.println("Count of Nodes: " + tree.countOfNodes(root));
        
        System.out.println("Sum of Nodes : " + tree.sumOfNodes(root));

        System.out.println("Diameter of Tree : " + tree.diameterOfTree(root));

        System.out.println("Diameter of Tree : " + tree.diamOfTree(root).diam);
    }
}

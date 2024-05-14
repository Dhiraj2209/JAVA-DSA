import java.util.ArrayList;
import java.util.List;

// Node creation
class Node {
    int order;
    List<String> values;
    List<List<Node>> keys;
    Node nextKey;
    Node parent;
    boolean isLeaf;

    // Node constructor
    public Node(int order) {
        this.order = order;
        this.values = new ArrayList<>();
        this.keys = new ArrayList<>();
        this.nextKey = null;
        this.parent = null;
        this.isLeaf = false;
    }

    // Insert at the leaf
    public void insertAtLeaf(String value, Node key) {
        if (!this.values.isEmpty()) {
            for (int i = 0; i < this.values.size(); i++) {
                if (value.equals(this.values.get(i))) {
                    this.keys.get(i).add(key);
                    break;
                } else if (value.compareTo(this.values.get(i)) < 0) {
                    this.values.add(i, value);
                    this.keys.add(i, new ArrayList<>());
                    this.keys.get(i).add(key);
                    break;
                } else if (i + 1 == this.values.size()) {
                    this.values.add(value);
                    this.keys.add(new ArrayList<>());
                    this.keys.get(i + 1).add(key);
                    break;
                }
            }
        } else {
            this.values.add(value);
            this.keys.add(new ArrayList<>());
            this.keys.get(0).add(key);
        }
    }
}

// B plus tree
class BplusTree {
    Node root;

    // B plus tree constructor
    public BplusTree(int order) {
        this.root = new Node(order);
        this.root.isLeaf = true;
    }

    // Insert operation
    public void insert(String value, Node key) {
        Node oldNode = this.search(value);
        oldNode.insertAtLeaf(value, key);

        if (oldNode.values.size() == oldNode.order) {
            Node newNode = new Node(oldNode.order);
            newNode.isLeaf = true;
            newNode.parent = oldNode.parent;
            int mid = (int) Math.ceil(oldNode.order / 2.0) - 1;
            newNode.values = new ArrayList<>(oldNode.values.subList(mid + 1, oldNode.values.size()));
            newNode.keys = new ArrayList<>(oldNode.keys.subList(mid + 1, oldNode.keys.size()));
            newNode.nextKey = oldNode.nextKey;
            oldNode.values = new ArrayList<>(oldNode.values.subList(0, mid + 1));
            oldNode.keys = new ArrayList<>(oldNode.keys.subList(0, mid + 1));
            oldNode.nextKey = newNode;
            this.insertInParent(oldNode, newNode.values.get(0), newNode);
        }
    }

    // Search operation for different operations
    public Node search(String value) {
        Node currentNode = this.root;
        while (!currentNode.isLeaf) {
            for (int i = 0; i < currentNode.values.size(); i++) {
                if (value.equals(currentNode.values.get(i))) {
                    currentNode = currentNode.keys.get(i + 1).get(0);
                    break;
                } else if (value.compareTo(currentNode.values.get(i)) < 0) {
                    currentNode = currentNode.keys.get(i).get(0);
                    break;
                } else if (i + 1 == currentNode.values.size()) {
                    currentNode = currentNode.keys.get(i + 1).get(0);
                    break;
                }
            }
        }
        return currentNode;
    }

    // Find the node
    public boolean find(String value, Node key) {
        Node leaf = this.search(value);
        for (int i = 0; i < leaf.values.size(); i++) {
            if (leaf.values.get(i).equals(value)) {
                if (leaf.keys.get(i).contains(key)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    // Inserting at the parent
    public void insertInParent(Node n, String value, Node ndash) {
        if (this.root == n) {
            Node rootNode = new Node(n.order);
            rootNode.values.add(value);
            rootNode.keys.add(new ArrayList<>());
            rootNode.keys.add(new ArrayList<>());
            rootNode.keys.get(0).add(n);
            rootNode.keys.get(1).add(ndash);
            this.root = rootNode;
            n.parent = rootNode;
            ndash.parent = rootNode;
            return;
        }

        Node parentNode = n.parent;
        for (int i = 0; i < parentNode.keys.size(); i++) {
            if (parentNode.keys.get(i).get(0) == n) {
                parentNode.values.add(i, value);
                parentNode.keys.add(i + 1, new ArrayList<>());
                parentNode.keys.get(i + 1).add(ndash);
                if (parentNode.keys.size() > parentNode.order) {
                    Node parentdash = new Node(parentNode.order);
                    parentdash.parent = parentNode.parent;
                    int mid = (int) Math.ceil(parentNode.order / 2.0) - 1;
                    parentdash.values = new ArrayList<>(parentNode.values.subList(mid + 1, parentNode.values.size()));
                    parentdash.keys = new ArrayList<>(parentNode.keys.subList(mid + 1, parentNode.keys.size()));
                    String value_ = parentNode.values.get(mid);
                    if (mid == 0) {
                        parentNode.values = new ArrayList<>(parentNode.values.subList(0, mid + 1));
                    } else {
                        parentNode.values = new ArrayList<>(parentNode.values.subList(0, mid));
                    }
                    parentNode.keys = new ArrayList<>(parentNode.keys.subList(0, mid + 1));
                    for (int j = 0; j < parentNode.keys.size(); j++) {
                        parentNode.keys.get(j).get(0).parent = parentNode;
                    }
                    for (int j = 0; j < parentdash.keys.size(); j++) {
                        parentdash.keys.get(j).get(0).parent = parentdash;
                    }
                    this.insertInParent(parentNode, value_, parentdash);
                }
                break;
            }
        }
    }
}

public class BPlusTree {
    public static void main(String[] args) {
        BplusTree bplusTree = new BplusTree(3);
        bplusTree.insert("5", new Node(3));
        bplusTree.insert("15", new Node(3));
        bplusTree.insert("25", new Node(3));
        bplusTree.insert("35", new Node(3));
        bplusTree.insert("45", new Node(3));

        printTree(bplusTree);

        if (bplusTree.find("5", new Node(3))) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }

    // Print the tree
    public static void printTree(BplusTree tree) {
        List<Node> lst = new ArrayList<>();
        lst.add(tree.root);
        List<Integer> level = new ArrayList<>();
        level.add(0);
        Node leaf = null;
        int flag = 0;
        int lev_leaf = 0;

        while (!lst.isEmpty()) {
            Node x = lst.remove(0);
            int lev = level.remove(0);
            if (!x.isLeaf) {
                for (int i = 0; i < x.keys.size(); i++) {
                    System.out.println(x.keys.get(i).get(0).values);
                }
            } else {
                for (int i = 0; i < x.keys.size(); i++) {
                    System.out.println(x.keys.get(i).get(0).values);
                }
                if (flag == 0) {
                    lev_leaf = lev;
                    leaf = x;
                    flag = 1;
                }
            }
        }
    }
}

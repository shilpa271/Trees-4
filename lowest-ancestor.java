class Node
{
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

class Main
{
    // Recursive function to insert a key into a BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Iterative function to search a given node in a BST
    public static boolean search(Node root, Node key)
    {
        // traverse the tree and search for the key
        while (root != null)
        {
            // if the given key is less than the current node, go to the left
            // subtree; otherwise, go to the right subtree

            if (key.data < root.data) {
                root = root.left;
            }
            else if (key.data > root.data) {
                root = root.right;
            }
            // if the key is found, return true
            else if (key == root) {
                return true;
            }
            else {
                return false;
            }
        }

        // we reach here if the key is not present in the BST
        return false;
    }

    // Recursive function to find the lowest common ancestor of given nodes
    // `x` and `y`, where both `x` and `y` are present in the BST
    public static Node LCARecursive(Node root, Node x, Node y)
    {
        // base case: empty tree
        if (root == null) {
            return null;
        }

        // if both `x` and `y` is smaller than the root, LCA exists in the
        // left subtree
        if (root.data > Integer.max(x.data, y.data)) {
            return LCARecursive(root.left, x, y);
        }

        // if both `x` and `y` are greater than the root, LCA exists in the
        // right subtree
        else if (root.data < Integer.min(x.data, y.data)) {
            return LCARecursive(root.right, x, y);
        }

        // if one key is greater (or equal) than the root and one key is
        // smaller (or equal) than the root, then the current node is LCA
        return root;
    }

    // Print lowest common ancestor of two nodes in the BST
    public static void LCA(Node root, Node x, Node y)
    {
        // return if the tree is empty or `x` or `y` is not present
        // in the tree
        if (root == null || !search(root, x) || !search(root, y)) {
            return;
        }

        // `lca` stores the lowest common ancestor of `x` and `y`
        Node lca = LCARecursive(root, x, y);

        // if the lowest common ancestor exists, print it
        if (lca != null) {
            System.out.println("LCA is " + lca.data);
        }
        else {
            System.out.println("LCA does not exist");
        }
    }

    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };


        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        LCA(root, root.left.left, root.left.right);
    }
}
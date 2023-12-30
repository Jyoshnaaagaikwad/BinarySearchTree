import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        char ch;
        do {
            System.out.println("Enter integer to insert: ");
            int value = scanner.nextInt();
            tree.insert(value);

            System.out.println("Do you want to continue (Type y or n)?");
            ch = scanner.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

        System.out.println("Inorder traversal:");
        tree.inorder();
        System.out.println();

        System.out.println("Enter integer to search: ");
        int keyToSearch = scanner.nextInt();
        if (tree.search(keyToSearch))
            System.out.println(keyToSearch + " found in the tree.");
        else
            System.out.println(keyToSearch + " not found in the tree.");

        scanner.close();
    }
}

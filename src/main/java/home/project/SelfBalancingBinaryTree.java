package home.project;

public class SelfBalancingBinaryTree {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public Node find(int value) {
        return findRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) { // adding value
            size++;
            return new Node(value);
        }

        if (current.value < value) {
            current.right = addRecursive(current.right, value);
        } else if (current.value > value) {
            current.left = addRecursive(current.left, value);
        } else {
            return current; // value already exists
        }

        return current;
    }

    private Node findRecursive(Node current, int value) {
        if (current == null) {
            return null;
        } else if (current.value > value) {
            return findRecursive(current.left, value);
        } else if (current.value < value) {
            return findRecursive(current.right, value);
        } else {
            return current;
        }
    }
}

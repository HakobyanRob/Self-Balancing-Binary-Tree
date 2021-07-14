package home.project;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SelfBalancingBinaryTree {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

/*    public void add(int value) {
        root = addRecursive(root, value);
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
    }*/

    public Node find(int value) {
        return findRecursive(root, value);
    }

    public Node addIteratively(int value) {
        Node current = root;
        Node temp = null;

        while (current != null) {
            temp = current;
            if (current.value < value) {
                current = current.right;
            } else if (current.value > value) {
                current = current.left;
            } else {
                return temp;
            }
        }

        if (temp == null) {
            root = new Node(value);
        } else if (temp.value > value) {
            temp.left = new Node(value);
        } else {
            temp.right = new Node(value);
        }
        size++;
        return temp;
    }

    public Node findIteratively(int value) {
        Node current = root;

        while (current != null) {
            if (current.value == value) {
                return current;
            } else if (current.value > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
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

    public Set<Integer> getAllNodes() {
        return getAllNodes(root);
    }

    public Set<Integer> getAllNodes(Node current) {
        Set<Integer> allNodes = new LinkedHashSet<>();

        if (current != null) {

            allNodes.addAll(getAllNodes(current.left));
            allNodes.add(current.value);
            allNodes.addAll(getAllNodes(current.right));
        }
        return allNodes;
    }
}

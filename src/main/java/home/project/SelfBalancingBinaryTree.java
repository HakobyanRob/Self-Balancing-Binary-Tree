package home.project;

import java.util.LinkedHashSet;
import java.util.Set;

public class SelfBalancingBinaryTree {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(int value) {
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
    }

    public Node find(int value) {
        return findRecursive(root, value);
    }

    public Node addIteratively(int value) {
        Node temp = root;
        Node current = null;
        boolean leftInsert = false;

        while (temp != null) {
            current = temp;
            if (temp.value < value) {
                temp = temp.right;
            } else if (temp.value > value) {
                temp = temp.left;
            } else {
                return current;
            }
        }

        if (current == null) {                     // New tree is created
            root = new Node(value);
        } else if (current.value > value) {        // Inserted value goes to the left node
            current.left = new Node(value);
            current.left.parent = current;
            leftInsert = true;
        } else {                                // Inserted value goes to the right node
            current.right = new Node(value);
            current.right.parent = current;
            leftInsert = false;
        }

        size++;

        if (current != null && current.parent != null) {
            int balanceDif = calculateBalanceDif(current);
            if (balanceDif < -1 || balanceDif > 1) {
                if (balanceDif > 1) {
                    if (leftInsert) {
                        rotateRight(current);
                    } else {
                        rotateLeftRight(current);
                    }
                }
                if (balanceDif < -1) {
                    if (!leftInsert) {
                        rotateLeft(current);
                    } else {
                        rotateRightLeft(current);
                    }
                }
                System.out.println("PARENT UNBALANCED!" + current.value);
//                balance(current, balanceDif);
            }
        }

        return current;
    }

    private void rotateLeftRight(Node current) {
        Node child = current.right;
        child.parent = current.parent;
        current.parent.left = child;
        child.left = current;
        current.parent = child;
        current.right = null;

        rotateRight(child);
    }

    private void rotateRightLeft(Node current) {
        Node child = current.left;
        child.parent = current.parent;
        current.parent.right = child;
        child.right = current;
        current.parent = child;
        current.left = null;

        rotateLeft(child);
    }

    private void rotateRight(Node current) {
        Node parent = current.parent;
        current.right = parent;
        parent.left = null;
        if (parent.parent != null) {
            current.parent = parent.parent;
        } else {
            current.parent = null;
            root = current;
        }
        parent.parent = current;
    }

    private void rotateLeft(Node current) {
        Node parent = current.parent;
        current.left = parent;
        parent.right = null;
        if (parent.parent != null) {
            current.parent = parent.parent;
        } else {
            current.parent = null;
            root = current;
        }
        parent.parent = current;
    }

    private int calculateBalanceDif(Node current) {
        return longestBranch(current.parent.left) - longestBranch(current.parent.right);
    }

    private int longestBranch(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(longestBranch(node.left), longestBranch(node.right));
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

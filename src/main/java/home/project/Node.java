package home.project;

public class Node {
    int value;
    Node parent;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        parent = null;
        right = null;
        left = null;
    }
}
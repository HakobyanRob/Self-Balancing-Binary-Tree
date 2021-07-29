/*
 * Copyright (c) 2021.
 * @Author https://github.com/HakobyanRob
 */

package com.home;

import java.util.LinkedHashSet;
import java.util.Set;

public class SelfBalancingBinaryTree {

    private Node root;
    private int size;

    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    public void addRecursively(int value) {
        root = addRecursively(root, value);
    }

    private Node addRecursively(Node current, int value) {
        if (current == null) { // adding value
            size++;
            return new Node(value);
        }

        if (current.value < value) {
            current.right = addRecursively(current.right, value);
        } else if (current.value > value) {
            current.left = addRecursively(current.left, value);
        } else {
            return current; // value already exists
        }

        return current;
    }

    public Node findRecursively(int value) {
        return findRecursively(root, value);
    }

    public Node addIteratively(int value) {
        Node temp = root;
        Node parent = null;
        boolean leftInsert;

        while (temp != null) {
            parent = temp;
            if (temp.value < value) {
                temp = temp.right;
            } else if (temp.value > value) {
                temp = temp.left;
            } else {
                return parent;
            }
        }

        size++;
        if (parent == null) {                     // New tree is created
            root = new Node(value);
            return root;
        } else if (parent.value > value) {        // Inserted value goes to the left node
            parent.left = new Node(value);
            parent.left.parent = parent;
            leftInsert = true;
        } else {                                // Inserted value goes to the right node
            parent.right = new Node(value);
            parent.right.parent = parent;
            leftInsert = false;
        }


        Node insertedNode = leftInsert ? parent.left : parent.right;
        boolean isUnbalanced = true;
        if (parent.parent != null) {
            while (parent.parent != null && isUnbalanced) {
                Node current = parent;
                parent = parent.parent;
                int balanceDif = calculateBalanceDif(parent);
                isUnbalanced = balanceDif < -1 || balanceDif > 1;
                if (isUnbalanced) {
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
                    System.out.println("PARENT UNBALANCED!" + insertedNode.value);
                }
            }
        }
        return insertedNode;
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
        if (current.right != null) {
            current.left.right = current.right;
        }
        Node parent = current.parent;
        current.right = parent;
        parent.left = null;
        if (parent.parent != null) {
            current.parent = parent.parent;
            current.parent.left = current;
        } else {
            current.parent = null;
            root = current;
        }

        parent.parent = current;
    }

    private void rotateLeft(Node current) {
        if (current.left != null) {
            current.right.left = current.left;
        }
        Node parent = current.parent;
        current.left = parent;
        parent.right = null;
        if (parent.parent != null) {
            current.parent = parent.parent;
            current.parent.right = current;
        } else {
            current.parent = null;
            root = current;
        }
        parent.parent = current;
    }

    private int calculateBalanceDif(Node current) {
        return longestBranch(current.left) - longestBranch(current.right);
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


    private Node findRecursively(Node current, int value) {
        if (current == null) {
            return null;
        } else if (current.value > value) {
            return findRecursively(current.left, value);
        } else if (current.value < value) {
            return findRecursively(current.right, value);
        } else {
            return current;
        }
    }

    public Set<Integer> getAllNodes() {
        return getAllNodes(root);
    }

    private Set<Integer> getAllNodes(Node current) {
        Set<Integer> allNodes = new LinkedHashSet<>();

        if (current != null) {

            allNodes.addAll(getAllNodes(current.left));
            allNodes.add(current.value);
            allNodes.addAll(getAllNodes(current.right));
        }
        return allNodes;
    }
}

/*
 * Copyright (c) 2021.
 * @Author https://github.com/HakobyanRob
 */

package com.home;

import lombok.Getter;

import java.util.Objects;

@Getter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value && Objects.equals(parent, node.parent) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, parent, left, right);
    }
}
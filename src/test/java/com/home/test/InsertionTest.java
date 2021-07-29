/*
 * Copyright (c) 2021.
 * @Author https://github.com/HakobyanRob
 */

package com.home.test;

import com.home.Node;
import com.home.SelfBalancingBinaryTree;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InsertionTest {

    private SelfBalancingBinaryTree selfBalancingBinaryTree;

    @BeforeClass
    public void createSampleTree() {
        selfBalancingBinaryTree = new SelfBalancingBinaryTree();

        int value = 0;
        selfBalancingBinaryTree.addIteratively(value);
        Assert.assertEquals(selfBalancingBinaryTree.findIteratively(value), selfBalancingBinaryTree.getRoot());
        Assert.assertNull(selfBalancingBinaryTree.findIteratively(value).getRight());
        Assert.assertNull(selfBalancingBinaryTree.findIteratively(value).getLeft());
    }

    @Test
    public void addIterativelyTest() {
        int value = 1;
        System.out.println("Adding Iteratively value: " + value);
        Node node = selfBalancingBinaryTree.addIteratively(value);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.getValue(), value);
        Node foundNodeIteratively = selfBalancingBinaryTree.findIteratively(value);
        Assert.assertNotNull(foundNodeIteratively);
        Assert.assertEquals(foundNodeIteratively.getValue(), node.getValue());
        Node foundNodeRecursively = selfBalancingBinaryTree.findRecursively(value);
        Assert.assertNotNull(foundNodeRecursively);
        Assert.assertEquals(foundNodeRecursively.getValue(), node.getValue());
        System.out.println("Added value Iteratively successfully: " + value);

        value = -1;
        System.out.println("Adding value Iteratively: " + value);
        node = selfBalancingBinaryTree.addIteratively(value);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.getValue(), value);
        foundNodeIteratively = selfBalancingBinaryTree.findIteratively(value);
        Assert.assertNotNull(foundNodeIteratively);
        Assert.assertEquals(foundNodeIteratively.getValue(), node.getValue());
        foundNodeRecursively = selfBalancingBinaryTree.findRecursively(value);
        Assert.assertNotNull(foundNodeRecursively);
        Assert.assertEquals(foundNodeRecursively.getValue(), node.getValue());
        Assert.assertEquals(foundNodeRecursively, foundNodeIteratively);
        System.out.println("Added value Iteratively successfully: " + value);
    }

    @Test(dependsOnMethods = "addIterativelyTest", enabled = false)
    public void addRecursivelyTest() {
        int value = 2;
        System.out.println("Adding value Recursively: " + value);
        selfBalancingBinaryTree.addRecursively(value);
        Node node = selfBalancingBinaryTree.findRecursively(value);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.getValue(), value);
        Node parent = selfBalancingBinaryTree.findRecursively(1);
        Assert.assertNotNull(node.getParent());
        Assert.assertEquals(node.getParent(), parent);
        Assert.assertEquals(node, parent.getRight());
        Assert.assertNull(node.getLeft());
        Assert.assertNull(node.getRight());
        System.out.println("Added value Recursively successfully: " + value);

        value = -2;
        System.out.println("Adding value Recursively: " + value);
        selfBalancingBinaryTree.addRecursively(value);
        node = selfBalancingBinaryTree.findRecursively(value);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.getValue(), value);
        parent = selfBalancingBinaryTree.findRecursively(-1);
        Assert.assertEquals(node.getParent(), parent);
        Assert.assertEquals(node, parent.getLeft());
        Assert.assertNull(node.getLeft());
        Assert.assertNull(node.getRight());
        System.out.println("Added value Recursively successfully: " + value);
    }
}

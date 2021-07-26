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

        selfBalancingBinaryTree.addIteratively(1);
    }

    @Test
    public void addUniqueValue() {
        int uniqueValue = 2;
        System.out.println("Adding unique value: " + uniqueValue);
        Node node = selfBalancingBinaryTree.addIteratively(uniqueValue);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.getValue(), uniqueValue);
        Node foundNodeIteratively = selfBalancingBinaryTree.findIteratively(uniqueValue);
        Assert.assertNotNull(foundNodeIteratively);
        Assert.assertEquals(foundNodeIteratively.getValue(), node.getValue());
        Node foundNodeRecursively = selfBalancingBinaryTree.find(uniqueValue);
        Assert.assertNotNull(foundNodeRecursively);
        Assert.assertEquals(foundNodeRecursively.getValue(), node.getValue());
        System.out.println("Added unique value successfully: " + uniqueValue);

        uniqueValue = -5;
        System.out.println("Adding unique value: " + uniqueValue);
        node = selfBalancingBinaryTree.addIteratively(uniqueValue);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.getValue(), uniqueValue);
        foundNodeIteratively = selfBalancingBinaryTree.findIteratively(uniqueValue);
        Assert.assertNotNull(foundNodeIteratively);
        Assert.assertEquals(foundNodeIteratively.getValue(), node.getValue());
        foundNodeRecursively = selfBalancingBinaryTree.find(uniqueValue);
        Assert.assertNotNull(foundNodeRecursively);
        Assert.assertEquals(foundNodeRecursively.getValue(), node.getValue());
        System.out.println("Added unique value successfully: " + uniqueValue);
    }

    @Test
    public void addDuplicateValue() {
        int duplicateValue = 1;
        System.out.println("Adding duplicate value: " + duplicateValue);
        Node node = selfBalancingBinaryTree.addIteratively(duplicateValue);
        Assert.assertNotNull(node);
        Assert.assertEquals(node.getValue(), duplicateValue);
        Node foundNodeIteratively = selfBalancingBinaryTree.findIteratively(duplicateValue);
        Assert.assertNotNull(foundNodeIteratively);
        Assert.assertEquals(foundNodeIteratively.getValue(), node.getValue());
        Node foundNodeRecursively = selfBalancingBinaryTree.find(duplicateValue);
        Assert.assertNotNull(foundNodeRecursively);
        Assert.assertEquals(foundNodeRecursively.getValue(), node.getValue());
    }
}

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

public class InsertionBalancingTest {

    private SelfBalancingBinaryTree selfBalancingBinaryTree;
    private Node root;

    @BeforeClass
    public void createSampleTree() {
        selfBalancingBinaryTree = new SelfBalancingBinaryTree();

        root = selfBalancingBinaryTree.addIteratively(50);
    }

    @Test
    public void leftRotationTest() {
        int value = 60;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        value = 70;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        Node node = selfBalancingBinaryTree.findIteratively(60);
        Assert.assertNotNull(node);
        Assert.assertNotNull(node.getLeft());
        Assert.assertEquals(node.getLeft(), root);

        Assert.assertNotNull(node.getRight());
        Assert.assertEquals(node.getRight(), selfBalancingBinaryTree.findIteratively(70));
    }

    @Test
    public void rightRotationTest() {
        int value = 40;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        value = 30;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        Node node = selfBalancingBinaryTree.findIteratively(40);
        Assert.assertNotNull(node);
        Assert.assertNotNull(node.getParent());
        Assert.assertEquals(node.getParent(), root);

        Assert.assertNotNull(node.getLeft());
        Assert.assertEquals(node.getLeft(), selfBalancingBinaryTree.findIteratively(30));

        Assert.assertNotNull(node.getRight());
        Assert.assertEquals(node.getRight(), selfBalancingBinaryTree.findIteratively(50));
    }
}

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

    @BeforeClass
    public void createSampleTree() {
        selfBalancingBinaryTree = new SelfBalancingBinaryTree();
        selfBalancingBinaryTree.addIteratively(50);
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
        Assert.assertEquals(node, selfBalancingBinaryTree.getRoot());

        Assert.assertNotNull(node.getLeft());
        Assert.assertEquals(node.getLeft(), selfBalancingBinaryTree.findIteratively(50));

        Assert.assertNotNull(node.getRight());
        Assert.assertEquals(node.getRight(), selfBalancingBinaryTree.findIteratively(70));

        System.out.println("Left Rotation Test Successful");
    }

    @Test(dependsOnMethods = "leftRotationTest")
    public void rightRotationTest() {
        int value = 40;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        value = 30;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        Assert.assertEquals(selfBalancingBinaryTree.findIteratively(60), selfBalancingBinaryTree.getRoot());

        Node node = selfBalancingBinaryTree.findIteratively(40);
        Assert.assertNotNull(node);
        Assert.assertNotNull(node.getParent());
        Assert.assertEquals(node.getParent(), selfBalancingBinaryTree.findIteratively(60));

        Assert.assertNotNull(node.getLeft());
        Assert.assertEquals(node.getLeft(), selfBalancingBinaryTree.findIteratively(30));

        Assert.assertNotNull(node.getRight());
        Assert.assertEquals(node.getRight(), selfBalancingBinaryTree.findIteratively(50));

        System.out.println("Right Rotation Test Successful");
    }

    @Test(dependsOnMethods = "rightRotationTest")
    public void leftRightRotationTest() {
        int value = 90;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        value = 80;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        Assert.assertEquals(selfBalancingBinaryTree.findIteratively(60), selfBalancingBinaryTree.getRoot());

        Node node = selfBalancingBinaryTree.findIteratively(80);
        Assert.assertNotNull(node);
        Assert.assertNotNull(node.getParent());
        Assert.assertEquals(node.getParent(), selfBalancingBinaryTree.findIteratively(60));

        Assert.assertNotNull(node.getLeft());
        Assert.assertEquals(node.getLeft(), selfBalancingBinaryTree.findIteratively(70));

        Assert.assertNotNull(node.getRight());
        Assert.assertEquals(node.getRight(), selfBalancingBinaryTree.findIteratively(90));

        System.out.println("Left-Right Rotation Test Successful");
    }

    @Test(dependsOnMethods = "leftRightRotationTest")
    public void rightLeftRotationTest() {
        int value = 10;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        value = 20;
        selfBalancingBinaryTree.addIteratively(value);
        System.out.println("Added value: " + value);

        Assert.assertEquals(selfBalancingBinaryTree.findIteratively(60), selfBalancingBinaryTree.getRoot());

        Node node = selfBalancingBinaryTree.findIteratively(20);
        Assert.assertNotNull(node);
        Assert.assertNotNull(node.getParent());
        Assert.assertEquals(node.getParent(), selfBalancingBinaryTree.findIteratively(40));

        Assert.assertNotNull(node.getLeft());
        Assert.assertEquals(node.getLeft(), selfBalancingBinaryTree.findIteratively(10));

        Assert.assertNotNull(node.getRight());
        Assert.assertEquals(node.getRight(), selfBalancingBinaryTree.findIteratively(30));

        System.out.println("Left-Right Rotation Test Successful");
    }
}

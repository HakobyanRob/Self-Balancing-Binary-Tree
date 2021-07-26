/*
  Copyright (c) 2021.
  @Author https://github.com/HakobyanRob
 */

import com.home.SelfBalancingBinaryTree;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        SelfBalancingBinaryTree selfBalancingBinaryTree = new SelfBalancingBinaryTree();

        selfBalancingBinaryTree.addIteratively(1);
        selfBalancingBinaryTree.addIteratively(12);
        selfBalancingBinaryTree.addIteratively(45);
        selfBalancingBinaryTree.addIteratively(5);
        selfBalancingBinaryTree.addIteratively(4);
        selfBalancingBinaryTree.addIteratively(10);

        System.out.println(selfBalancingBinaryTree.getSize());

        selfBalancingBinaryTree.findIteratively(3);

        Set<Integer> allNodes = selfBalancingBinaryTree.getAllNodes();
        System.out.println(allNodes);
    }
}

import home.project.SelfBalancingBinaryTree;

public class Main {
    public static void main(String[] args) {
        SelfBalancingBinaryTree selfBalancingBinaryTree = new SelfBalancingBinaryTree();

        selfBalancingBinaryTree.add(1);
        selfBalancingBinaryTree.add(12);
        selfBalancingBinaryTree.add(45);
        selfBalancingBinaryTree.add(5);
        selfBalancingBinaryTree.add(4);
        selfBalancingBinaryTree.add(9);
        selfBalancingBinaryTree.add(3);
        selfBalancingBinaryTree.add(12);
        selfBalancingBinaryTree.add(56);

        System.out.println(selfBalancingBinaryTree.getSize());

        selfBalancingBinaryTree.find(3);
    }
}

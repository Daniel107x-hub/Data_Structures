package com.problems.trees.binary;

public class BinaryTreeDiameter {
    public static void main(String[] args) {
        BinaryTree root=
            new BinaryTree(1,
                new BinaryTree(1,
                        new BinaryTree(1,
                                new BinaryTree(1,
                                        new BinaryTree(1,
                                                new BinaryTree(1),
                                                null),
                                        null),
                                new BinaryTree(1,
                                        null,
                                        new BinaryTree(1))),
                        new BinaryTree(1,
                                null,
                                new BinaryTree(1,
                                        null,
                                        new BinaryTree(1,
                                                null,
                                                new BinaryTree(1))))),
                new BinaryTree(1,
                        null,
                        new BinaryTree(1,
                                null,
                                new BinaryTree(1))));
        System.out.println(binaryTreeDiameter(root));
    }

    public static int binaryTreeDiameter(BinaryTree tree) {
        if(tree == null) return 0;
        int left = binaryTreeDiameter(tree.left);
        int right = binaryTreeDiameter(tree.right);
        int leftHeight = height(tree.left);
        int rightHeight = height(tree.right);
        return Math.max(Math.max(left, right), leftHeight + rightHeight );
    }

    public static int height(BinaryTree root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree left, BinaryTree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

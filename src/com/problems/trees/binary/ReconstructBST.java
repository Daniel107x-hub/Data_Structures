package com.problems.trees.binary;
import com.datastructures.stack.IStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReconstructBST {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, -10, -5, 6, 9, 7));
        BST root = reconstructBst(list);
        System.out.println();
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        BST root = null;
        BST current = null;
        Stack<BST> s = new Stack<>();
        for(int e : preOrderTraversalValues){
            if(root == null){
                root = new BST(e);
                current = root;
                s.push(current);
            }else{
                if(e < current.value){
                    current.left = new BST(e);
                    current = current.left;
                    s.push(current);
                }else{
                    current = s.pop();
                    while(!s.isEmpty() && e > current.value && e > s.peek().value) current = s.pop();
                    current.right = new BST(e);
                    current = current.right;
                    s.push(current);
                }
            }
        }
        return root;
    }
}

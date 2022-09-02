package com.problems.trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class TreeTraversal {
    private static final Scanner scanner = new Scanner(System.in);

    private static Node root;

    public static void main(String[] args){
//        test();
        readInputs(scanner);
        traverseTree();
    }

    public static void test(){
        readFromFile();
        traverseTree();
    }

    private static void readFromFile(){
        try{
            File inputFile = new File("inputs/trees/TreeTraversalInput");
            Scanner fileScanner = new Scanner(inputFile);
            readInputs(fileScanner);
            fileScanner.close();
        }catch(FileNotFoundException e){
            System.out.println("Error ocurred");
            e.printStackTrace();
        }
    }

    public static void traverseTree(){
        inorderTraversal(root);
        System.out.println();
        preorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }

    private static void readInputs(Scanner scanner){
        int nodes = scanner.nextInt();
        scanner.nextLine();
        Node[] temporalStore = new Node[nodes];
        for(int i=0;i<nodes;i++){
            String[] values = scanner.nextLine().split(" ");
            long key = Long.parseLong(values[0]);
            int leftIndex = Integer.parseInt(values[1]);
            int rightIndex = Integer.parseInt(values[2]);
            Node node = new Node(key, leftIndex, rightIndex);
            temporalStore[i] = node;
        }
        populateTree(temporalStore);
    }

    private static void populateTree(Node[] nodes){
        for (Node currentNode : nodes) {
            int leftIndex = currentNode.leftIndex;
            int rightIndex = currentNode.rightIndex;
            if (leftIndex != -1) {
                currentNode.left = nodes[leftIndex];
            }
            if (rightIndex != -1) {
                currentNode.right = nodes[rightIndex];
            }
        }
        root = nodes[0];
    }

    private static void inorderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);
        while(!stack.isEmpty()){
            if(current.left != null){
                current = current.left;
                stack.push(current);
            }else{
                do{
                    if(stack.isEmpty()) return;
                    current = stack.pop();
                    System.out.print(current.key + " ");
                }while(current.right == null);
                current = current.right;
                stack.push(current);
            }
        }
    }

    private static void preorderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);
        System.out.print(current.key + " ");
        while(!stack.isEmpty()){
            if(current.left != null){
                current = current.left;
                stack.push(current);
                System.out.print(current.key + " ");
            }else{
                do{
                    if(stack.isEmpty()) return;
                    current = stack.pop();
                }while(current.right == null);
                current = current.right;
                stack.push(current);
                System.out.print(current.key + " ");
            }
        }
    }

    private static void postorderTraversal(Node root){
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);
        while(!stack.isEmpty()){
            if(current.left != null){
                current = current.left;
                stack.push(current);
            }else{
                Node removed = null;
                do{
                    if(stack.isEmpty()) return;
                    current = stack.pop();
                    if(current.right == null || current.right == removed ){
                        System.out.println(current.key + " ");
                        removed = current;
                    }else{
                        stack.push(current);
                    }
                }while(current.right == null || current.right == removed || current.left == removed);
                current = current.right;
                stack.push(current);
            }
        }
    }

    private static class Node{
        public long key;
        public Node left;
        public Node right;
        public int leftIndex;
        public int rightIndex;

        public Node(long key, int leftIndex, int rightIndex) {
            this.key = key;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }
}

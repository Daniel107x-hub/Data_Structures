package com.problems.trees.binary;

import java.util.*;
import java.util.stream.Collectors;

public class SwapNodes {
    public static void main(String[] args) {
        List<List<Integer>> indices = new ArrayList<>();
        indices.add(Arrays.asList(2, 3));
        indices.add(Arrays.asList(-1, 4));
        indices.add(Arrays.asList(-1, 5));
        indices.add(Arrays.asList(-1, -1));
        indices.add(Arrays.asList(-1, -1));
        List<Integer> queries = Arrays.asList(2);
        List<List<Integer>> results = swapNodes(indices, queries);
        for(List<Integer> result : results){
            for(int value : result) System.out.print(value + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries){
        Node root = buildNode(indexes, 1, 1);
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int maxDepth = getMaxDepth(root);
        for(int query : queries){
            Set<Integer> depths = getSwapDepths(query, maxDepth);
            List<Integer> currentResult = new ArrayList<>();
            swapTraverse(root, depths, currentResult);
            result.add(currentResult);
        }
        return result;
    }

    public static Node buildNode(List<List<Integer>> indexes, int index, int depth){
        if(index == -1) return null;
        Node node = new Node(index, depth);
        node.left = buildNode(indexes, indexes.get(index - 1).get(0), depth + 1);
        node.right = buildNode(indexes, indexes.get(index - 1).get(1), depth + 1);
        return node;
    }

    public static int getMaxDepth(Node root){
        if(root == null) return 0;
        return 1 + Math.max(
                getMaxDepth(root.left),
                getMaxDepth(root.right)
        );
    }

    public static Set<Integer> getSwapDepths(int query, int maxDepth){
        Set<Integer> set = new HashSet<>();
        int i = 1;
        int value = query;
        while(value < maxDepth){
            set.add(value);
            i++;
            value = query * i;
        }
        return set;
    }

    public static void swapTraverse(Node root, Set<Integer> depths, List<Integer> result){
        if(root == null) return;
        if(depths.contains(root.depth)) swap(root);
        swapTraverse(root.left, depths, result);
        result.add(root.value);
        swapTraverse(root.right, depths, result);
    }

    public static void swap(Node root){
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static class Node{
        public int value;
        public int depth;
        public Node left;
        public Node right;
        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}

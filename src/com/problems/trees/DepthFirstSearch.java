package com.problems.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Node root = new Node("A").setChildren(
                Arrays.asList(
                        new Node("B").setChildren(Arrays.asList(
                            new Node("E"),
                            new Node("F").setChildren(Arrays.asList(
                                new Node("I"),
                                new Node("J"))))),
                        new Node("C"),
                        new Node("D").setChildren(Arrays.asList(
                                new Node("G").setChildren(Arrays.asList(
                                    new Node("K")
                                )),
                                new Node("H")
                        ))));
        List<String> dfs = new ArrayList<>();
        root.depthFirstSearch(dfs);
        for(String e : dfs) System.out.println(e);
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node setChildren(List<Node> children){
            this.children = children;
            return this;
        }

        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            array.add(this.name);
            for(Node e : this.children) e.depthFirstSearch(array);
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

package com.problems.trees;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Node root = new Node("A",
                Arrays.asList(
                        new Node("B",
                                Arrays.asList(
                                        new Node("E"),
                                        new Node("F", Arrays.asList(new Node("I"), new Node("J")))
                                )
                        ),
                        new Node("C"),
                        new Node("D",
                                Arrays.asList(
                                        new Node("G", List.of(new Node("K"))),
                                        new Node("H")
                                )
                        )
                )
        );
        List<String> result = new ArrayList<>();
        for(String name : root.breadthFirstSearch(result)) System.out.print(name + " ");
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node(String name, List<Node> children) {
            this.name = name;
            this.children = children;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> q = new LinkedList<>();
            q.add(this);
            while(!q.isEmpty()){
                Node current = q.poll();
                array.add(current.name);
                q.addAll(current.children);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

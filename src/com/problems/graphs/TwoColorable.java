package com.problems.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TwoColorable {
    public static void main(String[] args) {
        int[][] edges = {
                {1},
                {0, 2},
                {1}
        };
        System.out.println(twoColorable2(edges));
    }

    public static boolean twoColorable2(int[][] edges){
        Stack<Integer> s = new Stack<>();
        Boolean[] colors = new Boolean[edges.length];
        colors[0] = true;
        s.push(0);
        while(!s.isEmpty()){
            int node = s.pop();
            int[] connections = edges[node];
            if(colors[node] == null) colors[node] = true;
            for(int connection : connections){
                if(colors[connection] == null){
                    colors[connection] = !colors[node];
                    s.push(connection);
                }else if(colors[connection] == colors[node]) return false;
            }
        }
        return true;
    }

    public static boolean twoColorable(int[][] edges) {
        Node[] nodes = new Node[edges.length];
        for(int i = 0 ; i < nodes.length ; i++) nodes[i] = new Node();
        for(int i = 0 ; i < edges.length ; i++){
            int[] connections = edges[i];
            for(int connection : connections){
                if(connection == i) return false;
                nodes[i].addSibling(nodes[connection]);
            }
        }
        for(Node node : nodes){
            if(node.getColor() == null) node.setColor(false);
            for(Node sibling : node.getSiblings()){
                if(sibling.getColor() == null) sibling.setColor(!node.getColor());
                if(sibling.getColor() == node.getColor()) return false;
            }
        }
        return true;
    }

    private static class Node{
        private Boolean color;
        private List<Node> siblings;

        public Node() {}

        public void addSibling(Node sibling){
            if(this.siblings == null) this.siblings = new ArrayList<>();
            this.siblings.add(sibling);
        }

        public List<Node> getSiblings(){
            return this.siblings;
        }

        public Boolean getColor() {
            return color;
        }

        public void setColor(Boolean color) {
            this.color = color;
        }
    }
}

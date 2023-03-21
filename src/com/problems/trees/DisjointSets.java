package com.problems.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DisjointSets {
    public static void main(String[] args) {
        UnionFind set = new UnionFind();
        set.createSet(5);
        set.createSet(10);
        System.out.println(set.find(5));
        System.out.println(set.find(10));
        set.union(5, 10);
        System.out.println(set.find(5));
        System.out.println(set.find(10));
        set.createSet(20);
        System.out.println(set.find(20));
        set.union(20, 10);
        System.out.println(set.find(5));
        System.out.println(set.find(10));
        System.out.println(set.find(20));
    }

    static class UnionFind {
        private Map<Integer, Integer> parents;
        private Map<Integer, Integer> ranks;

        public UnionFind() {
            parents = new HashMap<>();
            ranks = new HashMap<>();
        }

        public void createSet(int value) {
            if(parents.containsKey(value)) return;
            parents.put(value, null);
            ranks.put(value, 0);
        }

        public Integer find(int value) {
            if(!parents.containsKey(value)) return null;
            Integer parent = value;
            while(parents.get(value) != null){
                parent = parents.get(value);
                Integer grandpa = parents.get(parent);
                if(grandpa != null) parents.put(value, grandpa);
                value = parent;
            }
            return parent;
        }

        public void union(int valueOne, int valueTwo) {
            Integer root1 = this.find(valueOne);
            Integer root2 = this.find(valueTwo);
            if(root1 == null || root2 == null || Objects.equals(root1, root2)) return;
            if(ranks.get(root1) < ranks.get(root2)) parents.put(root1, root2);
            else if(ranks.get(root1) > ranks.get(root2)) parents.put(root2, root1);
            else{
                parents.put(root1, root2);
                ranks.put(root2, ranks.get(root1) + 1);
            }
        }
    }
}

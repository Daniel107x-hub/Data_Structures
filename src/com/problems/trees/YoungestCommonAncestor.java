package com.problems.trees;

import java.util.Stack;

public class YoungestCommonAncestor {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        Stack<AncestralTree> oneAncestors = descendantOne.getAncestors();
        Stack<AncestralTree> twoAncestors = descendantTwo.getAncestors();
        AncestralTree common = null;
        while(!oneAncestors.isEmpty() && !twoAncestors.isEmpty()){
            if(oneAncestors.peek() == twoAncestors.peek()){
                common = oneAncestors.peek();
                oneAncestors.pop();
                twoAncestors.pop();
                continue;
            }
            break;
        }
        return common;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        public Stack<AncestralTree> getAncestors(){
            Stack<AncestralTree> result = new Stack<>();
            result.push(this);
            AncestralTree next = this.ancestor;
            while(next != null){
                result.push(next);
                next = next.ancestor;
            }
            return result;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}

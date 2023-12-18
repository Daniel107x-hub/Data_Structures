package com.problems.trees.binary;

public class BSTConstruction {
    public static void main(String[] args) {
        BST root = new BST(10);
        root.insert(5);
        root.insert(15);
        root.insert(2);
        root.insert(5);
        root.insert(13);
        root.insert(22);
        root.insert(1);
        root.insert(14);
        root.insert(12);
        root.remove(5);
        root.remove(5);
        root.remove(12);
        root.remove(13);
        root.remove(14);
        root.remove(22);
        root.remove(2);
        root.remove(1);
        System.out.println(root.contains(15));
        System.out.println();
    }
    static class BST{
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST(int value, BST left, BST right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BST insert(int value){
            if(value < this.value){
                if(this.left == null){
                    this.left = new BST(value);
                    return this;
                }
                this.left.insert(value);
            }else{
                if(this.right == null){
                    this.right = new BST(value);
                    return this;
                }
                this.right.insert(value);
            }
            return this;
        }

        public boolean contains(int value){
            if(this.value == value) return true;
            if(value < this.value && this.left != null) return this.left.contains(value);
            else if(this.right != null) return this.right.contains(value);
            return false;
        }

        public BST remove(int value){
            BST root = this;
            BST current = this;
            BST next = this;
            while(next != null && next.value != value){
                current = next;
                if(value < current.value) next = current.left;
                else next = current.right;
            }
            if(next == null) return root; // Not found
            if(next.left == null && next.right == null){ //Leaf node
                if(current.left == next) current.left = null;
                if(current.right == next) current.right = null;
                return root;
            }
            if(current == next){ //Root node
                BST replacement = next.getReplacement();
                if(replacement.right != null) this.right = replacement.right;
                if(replacement.left != null) this.left = replacement.left;
                this.value = replacement.value;
                return this;
            }
            // Any other node
            BST replacement = next.getReplacement();
            if(replacement.right != null) next.right = replacement.right;
            if(replacement.left != null) next.left = replacement.left;
            next.value = replacement.value;
            return root;
        }

        private BST getReplacement(){
            if(this.right != null){
                BST current = this.right;
                if(current.left != null){
                    BST next = current.left;
                    while(next.left != null){
                        current = next;
                        next = current.left;
                    }
                    current.left = next.right;
                    return next;
                }
                this.right = null;
                return current;
            }
            if(this.left != null){
                BST current = this.left;
                if(current.right != null){
                    BST next = current.right;
                    while(next.right != null){
                        current = next;
                        next = current.right;
                    }
                    current.right = next.left;
                    return next;
                }
                this.left = null;
                return current;
            }
            return null;
        }
    }
}



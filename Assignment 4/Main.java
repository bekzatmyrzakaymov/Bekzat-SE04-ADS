package com.company.practise;

public class Main<T extends Comparable<T>> {

    private static class Node<T> implements Comparable<T> {
        T key;
        Node left, right;
        public Node(T item)
        {
            key = item;
            left = right = null;
        }

        @Override
        public int compareTo(T o) {
            return 0;
        }
    }

    private Node root;
    public static int sum = 0;
    public static int deepestLevel = Integer.MIN_VALUE;

    public Main() {
        root = null;
    }

    public void insert(T key) {
        root = insertElement(root, key);
    }

    Node insertElement(Node root, T key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.compareTo((T) root.key) <= 0)
            root.left = insertElement(root.left, key);
        else if (key.compareTo((T) root.key) >= 0)
            root.right = insertElement(root.right, key);

        return root;
    }

 //--------------Deepest Leaves Sum method-------------------------//

    public static void deepestLeavesSum(Node root, int level) {
        if(root == null)
            return;
        if(level > deepestLevel) {
            sum = (int) root.key;
            deepestLevel = level;
        }
        else if(level == deepestLevel) {
            sum +=  (int) root.key;
        }

        deepestLeavesSum(root.left, level + 1);
        deepestLeavesSum(root.right, level + 1);
    }

//--------------------------------------------------------------//
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public void print() {
        inorder(root);
    }

    public static void main(String[] args) {

        System.out.println("Binary Search Tree ");
        Main binaryTree = new Main();

        System.out.println("Insert elements: ");
        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(20);
        binaryTree.insert(40);
        binaryTree.insert(70);
        binaryTree.insert(60);
        binaryTree.insert(80);
        binaryTree.insert(10);
        binaryTree.insert(85);
        binaryTree.print();

        System.out.println();
        System.out.println("Deepest leaves sum:");
        deepestLeavesSum(binaryTree.root, 0);
        System.out.println(sum);
    }
}

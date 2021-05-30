package com.company;

public class BinarySearch<T extends Comparable<T>> {

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

    public BinarySearch() {
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

    public void delete(T key) { root = deleteKey(root, key); }

    public Node deleteKey(Node root, T key) {
        if (root == null)
            return root;

        if (key.compareTo((T) root.key) < 0)
            root.left = deleteKey(root.left, key);
        else if (key.compareTo((T) root.key) > 0)
            root.right = deleteKey(root.right, key);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteKey(root.right, (T) root.key);
        }

        return root;
    }

    public Object minValue(Node root) {
        Object minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public Node search(Node root, T key) {
        if (root==null || root.key==key)
            return root;
        if (key.compareTo((T) root.key) > 0)
            return search(root.right, key);

        return search(root.left, key);
    }

    public void search1(T key) { root = search(root, key); }

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
        BinarySearch binarySearch = new BinarySearch();

        System.out.println("Insert: ");
        binarySearch.insert(50);
        binarySearch.insert(30);
        binarySearch.insert(20);
        binarySearch.insert(40);
        binarySearch.insert(70);
        binarySearch.insert(60);
        binarySearch.insert(80);
        binarySearch.insert(10);
        binarySearch.insert(75);
        binarySearch.print();

        System.out.println("\n" + "Delete: ");
        binarySearch.delete(10);
        binarySearch.print();

        System.out.println("\n"+"Search: ");
        binarySearch.search1(30);

        binarySearch.print();

    }
}

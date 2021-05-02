package com.company;

public class MyHeap<T> {

    private int[] MyHeap;
    private int size;

    public MyHeap(){
        int capacity = 20;
        MyHeap=new int[capacity];
    }
                //Method 1
    public boolean empty(){
        return size() == 0;
    }

                //Method 2
    public int size() {
        return size;
    }

                //Method 3
    public int getMax(){
        return get(0);
    }

                //Method 4
    public T extractMax() {
        MyHeap[0] = MyHeap[size--];
        heapify(0);
        return null;
    }

    private void heapify(int index){
        if (MyHeap[index] < MyHeap[leftChild(index)]
                || MyHeap[index] < MyHeap[rightChild(index)]) {

            if (MyHeap[leftChild(index)] <= MyHeap[rightChild(index)]) {
                swap(index, rightChild(index));
                heapify(rightChild(index));
            }

            swap(index, leftChild(index));
            heapify(leftChild(index));
        }
    }

                    //Method 5
    public T insert(int newItem) {
        MyHeap[++size] = newItem;
        int current = size;
        while (MyHeap[current] > MyHeap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        return null;
    }

    private void swap(int index1, int index2) {
        int temp = MyHeap[index1];
        MyHeap[index1] = MyHeap[index2];
        MyHeap[index2] = temp;
    }

    public int get(int index){
        return  MyHeap[index];
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index){
        return 2*index;
    }

    private int rightChild(int index){
        return 2*index+1;
    }

}

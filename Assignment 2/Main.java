package com.company;

public class Main {

    public static void main(String[] args) {

             MyHeap<Integer> heap = new MyHeap<>();
              System.out.println("Heap operation: ");
              System.out.println("Add elements: ");
             heap.insert(6);
             heap.insert(9);
             heap.insert(13);
             heap.insert(20);
             heap.insert(15);
             heap.insert(7);
             heap.insert(8);

             for(int i =0; i< heap.size(); i++) {
                 System.out.print(heap.get(i) + " ");
             }

             System.out.println();
             System.out.print("Maximum element: ");
             System.out.println(heap.getMax());


             System.out.print("Extract Max: ");
             heap.extractMax();
             for(int i =0; i< heap.size(); i++){
                 System.out.print(heap.get(i) + " ");
            }

             System.out.println();
             System.out.print("Size of heap: ");
             System.out.println(heap.size());

             System.out.print("Check is it empty or not: ");
             System.out.println(heap.empty());

    }

}



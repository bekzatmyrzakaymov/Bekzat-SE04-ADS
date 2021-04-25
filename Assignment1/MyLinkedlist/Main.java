package com.company;

public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        System.out.println("Linkedlist elements:");

        System.out.println("Add element: ");
        for(int i=0; i<5;i++){
          list.add(i);
        }

        for(int i=1; i<list.getSize();i++){
            System.out.println(list.get(i));
        }


        System.out.println("Add elements with index: ");
        list.addWithIndex(3,3);
        list.addWithIndex(2,4);

        for(int i=0; i< list.getSize();i++){
            System.out.println(list.get(i));
        }


        System.out.println("Find index of element: ");
        System.out.println(list.find(4));


        System.out.println("Remove element by index: ");
        list.remove(2);

        for(int i=1; i<list.getSize();i++){
            System.out.println(list.get(i));
        }

        System.out.println("Reverse operation: ");
        list.reverse();
        for(int i=0; i<list.getSize();i++){
            System.out.println(list.get(i) + " ");
        }



    }

}

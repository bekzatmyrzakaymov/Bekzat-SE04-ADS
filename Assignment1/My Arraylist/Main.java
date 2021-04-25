package com.company;


public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Arraylist operation: ");

        System.out.println("Add elements: ");
        for(int i=0; i<4; i++){
            list.add(i);
        }

        for(int i=0; i< list.getSize(); i++){
            System.out.println(list.get(i) + "");
        }

        System.out.println("Add With element:");
        list.addWithElement(2,1);
        for(int i=0; i< list.getSize(); i++){
            System.out.println(list.get(i));
        }

        System.out.println("Find index of element: ");
        System.out.println("index:" +list.find(3));

          System.out.println("Remove element by index: ");
          list.remove(3);
          for(int i=0; i< list.getSize(); i++){
                System.out.println(list.get(i));
          }

        System.out.println("Reverse: ");
        list.reverse();
        for(int i=0; i< list.getSize(); i++){
            System.out.println(list.get(i) );
        }


    }
}

package com.company;

public class MyLinkedList<T> {

    //I use example code MyLinkedList Lecture 3
    //There are created 4 method: addWithIndex, find, remove, reverse

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;


    public MyLinkedList(){
            head=null;
            size=0;
    }

    public void add(T newItem){
        MyNode<T> newNode = new MyNode<>(newItem);
        if(head==null){
            head = tail= newNode;
        }

        else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

                    //Method-1
    public void addWithIndex( T newItem, int index) {
        if (index == getSize()) {
            add(newItem);
            size++;
        }

        else if (index == 0) {
            head = new MyNode<>(newItem);//add newIem for head
            size++;
        }

        else {
            // add in the middle
             MyNode<T> before = head;
            for (int i = 0; i < index + 1; i++) {
                before = before.next;
            }
            before.next = new MyNode<>(newItem);
            size++;
        }
    }


            //Method 2
    public int find(T keyItem){
        MyNode<T> current = head;
        current=current.next;

        for (int i=1; i<size; i++){
            //Check data with KeyItem
            if (current.data == keyItem) {
                System.out.println("index: "+i);
            }
            current=current.next;
        }
        return -1;
    }

            //Method 3
    public void reverse(){
        MyNode<T> prev = null;
        MyNode<T> next;
        MyNode<T> current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void remove(int index) {
        MyNode<T> item = head;

        if (head == null)//Linked list is empty
            return;

        if (index != 0) {
            for (int i = 0; item != null && i < index - 1; i++)
                item = item.next;

            if (item == null || item.next == null)  //if there is no such element in the index
                return;
            item.next = item.next.next;
            size--;
        }

        else {                  //remove head
            head = item.next;   //change element head

        }
    }



    public T get(int index){
        MyNode<T> current=head;
        for(int i=0;i<index;i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getSize() {
        return size;
    }

}

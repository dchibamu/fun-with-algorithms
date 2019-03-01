package org.chibamuio.datastructures.list;

public class LinkedListU<T> {

    Node<T> head;

    public LinkedListU(){
        head = null;
    }

    public void add(T value){
        Node<T> newNode = new Node<T>(value, null);
        if(head != null){
            newNode.next = head;
            head = newNode;
        }else{
            head = newNode;
        }
    }

    public void find(T value){

        Node<T> current = head;
        while(current != null && !value.equals(current.next.getData())){
            current = current.next;
        }
    }

    public void deleteFrist(){
        head = head.next;
    }

    static  class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void reverseList(Node<T> head){
        Node<T> current = head, previous = null, next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }

    public void printList(Node head){
        Node<T> current = head;
        while(current != null){
            System.out.print(String.format("%s\t", current.data));
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node<Integer> twentyThree = new Node<Integer>(23, null);
        Node<Integer> thirtySeven = new Node<Integer>(37, twentyThree);
        Node<Integer> four = new Node<Integer>(4, thirtySeven);
        Node<Integer> eleven = new Node<Integer>(11, four);
        Node<Integer> twentyNine = new Node<Integer>(29, eleven);
        Node<Integer> head = new Node<Integer>(13, twentyNine);

        LinkedListU linkedListU = new LinkedListU();
        linkedListU.reverseList(head);
        linkedListU.printList(twentyThree);
    }
}

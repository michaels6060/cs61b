package deque;

import sun.awt.image.ImageWatched;

public class LinkedListDeque<T> {

    @Override
    public String toString(){
        String output ="";
        Node temp = sentinel;
        while(temp.next!=null){
            output+=" " + temp.next.item;
            temp = temp.next;
        }
        return output;
    }

    private class Node{
        public T item;
        public Node next;
        public Node prev;


        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty LLD. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next =newNode;
        size += 1;
    }

    /** Adds x to the end of the list. */
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /** Returns the ith item in the list. */
    public T get(int index) {
        int count = 0;
        Node curr = sentinel;
        while (curr.next != sentinel) {
            curr = curr.next;
            if(count == index){
                return curr.item;
            }
            count++;
        }
        return null;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    public T removeFirst(){
        if(size==0){
            return null;
        }
        Node first = sentinel.next;
        T output =  first.item;
        sentinel.next = first.next;
        sentinel.next.prev = sentinel;

        size -= 1;
        return output;
    }

    public void printDeque(){
        Node curr = sentinel.next;
        while (curr != sentinel) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public T removeLast(){
        if(size==0){
            return null;
        }

        Node lastNode = sentinel.prev;
        T output =  lastNode.item;
        sentinel.prev = lastNode.prev;
        sentinel.prev.next = sentinel;

        size -= 1;
        return output;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof LinkedListDeque){
            LinkedListDeque deque = (LinkedListDeque)o;
            if(deque.size() == this.size()){
                Node curr1 = sentinel.next;
                Node curr2 = deque.sentinel.next;
                while (curr1 != sentinel) {
                    //System.out.println(curr1 + " " + curr2);
                    if(!curr1.item.equals(curr2.item)){
                        return false;
                    }
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                }
                return true;
            }
        }
        return false;
    }

//    public Iterator<T> iterator(){
//        return
//    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int i = 0;
        Node curr = sentinel.next;
        return getRecursiveHelp(i, index, curr);
    }

    private T getRecursiveHelp(int i, int index, Node curr) {
        if (i == index) {
            return curr.item;
        }
        return getRecursiveHelp(i+1, index, curr.next);
    }


    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
//        SLList L = new SLList();
//        L.addLast(20);
//        System.out.println(L.size());
    }
}
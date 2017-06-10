package com.training.collections;

/**
 * Created by vasya on 09/06/17.
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private int count;


    public T get(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return tmp.getT();
    }

    public void add(T t) {
        Node<T> node = new Node<>(t);
        node.setNext(head);
        head = node;
        count++;
    }

    public void addToEnd(T t){
        Node<T> node = new Node<>(t);
        if (count == 0){
            head = node;
        }else {
            Node<T> tmp = head;
            while (tmp.getNext()!= null){
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }
        count++;
    }
    
    public int size() {
        return count;
    }

    public boolean contains(T t) {
        Node<T> mn = this.head;
        while (mn != null) {
            if (mn.getT().equals(t)) {
                return true;
            }
            mn = mn.getNext();
        }
        return false;
    }


    public T remove(T t) {
        Node<T> mn = this.head;
        if (mn.getT().equals(t)) {
            head = mn.getNext();
            mn.setNext(null);
            count--;
            return t;
        }

        while (mn.getNext() != null) {
            if (mn.getNext().getT().equals(t)) {
                if (mn.getNext().getNext() == null) {
                    mn.setNext(null);
                    count--;
                    return t;
                }
                mn.setNext(mn.getNext().getNext());
                count--;
                return t;
            }

            mn = mn.getNext();
        }
        return null;
    }

    public void printList() {
        Node mn = this.head;
        while (mn != null) {
            System.out.print(mn.getT() + " ");
            mn = mn.getNext();

        }
    }


    public void reverse() {

        Node<T> right = null;
        Node<T> current = head;
        Node<T> left = head.getNext();

        while (left != null) {
            current.setNext(right);
            right = current;
            current = left;
            left = left.getNext();
            current.setNext(right);
        }
        head = current;

    }

}

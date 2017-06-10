package com.training.collections;

/**
 * Created by vasya on 09/06/17.
 */
public class SinglyLinkedList<T> {
    private Node<T> last;
    private int count;


    public T get(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> tmp = last;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getPrevious();
        }
        return tmp.getT();
    }

    public void add(T t) {
        Node<T> node = new Node<>(t);
        node.setPrevious(last);
        last = node;
        count++;
    }
    
    public int size() {
        return count;
    }

    public boolean contains(T t) {
        Node<T> mn = this.last;
        while (mn != null) {
            if (mn.getT().equals(t)) {
                return true;
            }
            mn = mn.getPrevious();
        }
        return false;
    }


    public T remove(T t) {
        Node<T> mn = this.last;
        if (mn.getT().equals(t)) {
            last = mn.getPrevious();
            mn.setPrevious(null);
            count--;
            return t;
        }

        while (mn.getPrevious() != null) {
            if (mn.getPrevious().getT().equals(t)) {
                if (mn.getPrevious().getPrevious() == null) {
                    mn.setPrevious(null);
                    count--;
                    return t;
                }
                mn.setPrevious(mn.getPrevious().getPrevious());
                count--;
                return t;
            }

            mn = mn.getPrevious();
        }
        return null;
    }

    public void printList() {
        Node mn = this.last;
        while (mn != null) {
            System.out.print(mn.getT() + " ");
            mn = mn.getPrevious();

        }
    }


    public void reverse() {

        Node<T> right = null;
        Node<T> current = last;
        Node<T> left = last.getPrevious();

        while (left != null) {
            current.setPrevious(right);
            right = current;
            current = left;
            left = left.getPrevious();
            current.setPrevious(right);
        }
        last = current;

    }

}

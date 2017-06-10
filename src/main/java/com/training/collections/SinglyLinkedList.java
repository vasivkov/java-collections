package com.training.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by vasya on 09/06/17.
 */
public class SinglyLinkedList<T> implements List<T> {
    private Node<T> head;
    private int count;

    @Override
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

    @Override
    public T set(int index, T element) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        T oldT = tmp.getT();
        tmp.setT(element);
        return oldT;
    }

    @Override
    public void add(int index, T element) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> elem = new Node<T>(element);
        if (index == 0) {
            elem.setNext(head);
            head = elem;

        } else {

            Node<T> tmp = head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.getNext();
            }
            Node<T> left = tmp;
            elem.setNext(tmp.getNext());
            left.setNext(elem);
        }
        count++;
    }

    @Override
    public T remove(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        Node<T> toBeRemoved;
        if(index == 0){
            head = head.getNext();
            node.setNext(null);
            toBeRemoved = node;
        }else {
            for (int i = 0; i < index - 1; i++) {
                node = node.getNext();
            }
            toBeRemoved = node.getNext();

            node.setNext(toBeRemoved.getNext());
            toBeRemoved.setNext(null);
        }
        count--;
        return toBeRemoved.getT();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> node = new Node<>(t);
        if (count == 0) {
            head = node;
        } else {
            Node<T> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(node);
        }
        count++;
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public void addToHead(T t) {
        Node<T> node = new Node<>(t);
        node.setNext(head);
        head = node;
        count++;
    }


    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean contains(Object t) {
        Node<T> mn = this.head;
        while (mn != null) {
            if (mn.getT().equals(t)) {
                return true;
            }
            mn = mn.getNext();
        }
        return false;
    }


    @Override
    public boolean remove(Object t) {
        Node<T> mn = this.head;
        if (mn.getT().equals(t)) {
            head = mn.getNext();
            mn.setNext(null);
            count--;
            return true;
        }

        while (mn.getNext() != null) {
            if (mn.getNext().getT().equals(t)) {
                if (mn.getNext().getNext() == null) {
                    mn.setNext(null);
                    count--;
                    return true;
                }
                mn.setNext(mn.getNext().getNext());
                count--;
                return true;
            }

            mn = mn.getNext();
        }
        return false;
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

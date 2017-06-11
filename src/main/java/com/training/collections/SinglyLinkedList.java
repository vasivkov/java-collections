package com.training.collections;

import java.util.*;

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
        Node<T> elem = new Node<>(element);
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
        if (index == 0) {
            head = head.getNext();
            node.setNext(null);
            toBeRemoved = node;
        } else {
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

        Node<T> node = head;
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (Objects.equals(o, node.getT())) {
                index = i;
                break;
            }
            node = node.getNext();
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> node = head;
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (Objects.equals(o, node.getT())) {
                index = i;
            }
            node = node.getNext();
        }
        return index;

    }

    @Override
    public ListIterator<T> listIterator() {
        throw new RuntimeException("listIterator is not supported Single Lincked List");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new RuntimeException("listIterator is not supported Single Lincked List");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> list = new SinglyLinkedList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(this.get(i));
        }
        return list;
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

        for (Object elem : c) {
            if (!this.contains(elem)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        for (T elem : c) {
            this.add(elem);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int i = index;
        for (T elem : c) {
            this.add(i, elem);
            i++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int currentCount = count;
        for (Object o : c) {
            this.remove(o);
        }
        return currentCount != count;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int currentCount = count;
        List<T> listForRemoved = new ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            if (!c.contains(node.getT())) {
                listForRemoved.add(node.getT());
            }
            node = node.getNext();
        }
        this.removeAll(listForRemoved);
        return currentCount != count;
    }

    @Override
    public void clear() {
        head.setNext(null);
        head = null;
        count = 0;

    }

    public void addToHead(T t) {
        Node<T> node = new Node<>(t);
        node.setNext(head);
        head = node;
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {

        return count == 0;
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Node<T> innerHead = head;

            @Override
            public boolean hasNext() {

                return innerHead != null;
            }

            @Override
            public T next() {
                T t = innerHead.getT();
                innerHead = innerHead.getNext();
                return t;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[count];
        Node<T> node = head;
        int i = 0;
        while (node != null) {
            arr[i] = node.getT();
            i++;
            node = node.getNext();
        }
        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        Node<T> node = head;
        int i = 0;
        while (node != null) {
            a[i] = (T1) node.getT();
            i++;
            node = node.getNext();
        }
        return a;
    }

    @Override
    public boolean contains(Object t) {
        Node<T> mn = this.head;
        while (mn != null) {
            if (Objects.equals(t, mn.getT())) {
                return true;
            }
            mn = mn.getNext();
        }
        return false;
    }


    @Override
    public boolean remove(Object t) {
        Node<T> mn = this.head;
        if (Objects.equals(t, mn.getT())) {
            head = mn.getNext();
            mn.setNext(null);
            count--;
            return true;
        }

        while (mn.getNext() != null) {
            if (Objects.equals(t, mn.getNext().getT())) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while (node.getNext() != null) {
            sb.append(node.getT()).append(" ");
            node = node.getNext();
        }
        sb.append(node.getT());
        return sb.toString();
    }

}

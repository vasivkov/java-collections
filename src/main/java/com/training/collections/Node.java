package com.training.collections;

/**
 * Created by vasya on 07/06/17.
 */
class Node<T> {
    private T t;
    private Node<T> next;

    public void setT(T t) {
        this.t = t;
    }

    Node(T t) {
        this.t = t;
        next = null;
    }


    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    T getT() {
        return t;
    }

    @Override
    public String toString() {
        return "data: " + t;
    }
}



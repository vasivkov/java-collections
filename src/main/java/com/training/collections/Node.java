package com.training.collections;

/**
 * Created by vasya on 07/06/17.
 */
class Node<T> {
    private T t;
    private Node<T> previous;

    Node(T t) {
        this.t = t;
        previous = null;
    }


    Node<T> getPrevious() {
        return previous;
    }

    void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    T getT() {
        return t;
    }


    public String toString() {
        return "data: " + t; //+ ", previouse node:" + previous;
    }
}



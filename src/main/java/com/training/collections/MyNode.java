package com.training.collections;

/**
 * Created by vasya on 07/06/17.
 */
class MyNode <T> {
    private T t;
    MyNode previous;

    public void setT(T t) {
        this.t = t;
    }

    MyNode getPrevious() {
        return previous;
    }

    void setPrevious(MyNode previous) {
        this.previous = previous;
    }

    T getT() {
        return t;
    }


    MyNode(T t) {
        this.t = t;
        previous = null;
    }


    public String toString() {
        return "data: " + t; //+ ", previouse node:" + previous;
    }
}



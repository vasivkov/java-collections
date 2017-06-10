package com.training.collections;

/**
 * Created by vasya on 09/06/17.
 */
public class Link<T> {
    MyNode<T> last;
    private int count;


    public void add(T t) {
        MyNode<T> myNode = new MyNode<>(t);
        myNode.previous = last;
        last = myNode;
        count++;
    }

    public int size() {
        return count;
    }

    public boolean contains(String str) {
        MyNode mn = this.last;
        while (mn != null) {
            if (mn.getT().equals(str)) {
                return true;
            }
            mn = mn.previous;
        }
        return false;
    }


    public void remove(T t) {
        MyNode mn = this.last;
        if (mn.getT().equals(t)) {
            last = mn.previous;
            mn.setPrevious(null);
            count--;
        }

        while (mn.previous != null) {
            if (mn.previous.getT().equals(t)) {
                if (mn.previous.previous == null) {
                    mn.setPrevious(null);
                    count--;
                    return;
                }
                mn.setPrevious(mn.previous.previous);
                count--;
                return;
            }

            mn = mn.previous;
        }

    }

    public void printList() {
        MyNode mn = this.last;
        while (mn != null) {
            System.out.print(mn.getT() + " ");
            mn = mn.previous;

        }
    }


    public void reverse() {

        MyNode post;
        MyNode cur;
        MyNode prev;

        post = last;
        cur = last.previous;
        prev = cur.previous;
        cur.setPrevious(post);


        prev = cur;


    }

}

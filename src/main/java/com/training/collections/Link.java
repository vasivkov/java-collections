package com.training.collections;

/**
 * Created by vasya on 09/06/17.
 */
public class Link {
    MyNode last;
    private int count;


    public void add(String str) {
        MyNode myNode = new MyNode(str);
        myNode.previous = last;
        last = myNode;
        count++;
    }

    public int size() {
        return count;
    }

    public boolean containValue(String str) {
        MyNode mn = this.last;
        while (mn != null) {
            if (mn.getDataStr().equals(str)) {
                return true;
            }
            mn = mn.previous;
        }
        return false;
    }



    public void removeValue(String str) {
        MyNode mn = this.last;
        if (mn.getDataStr().equals(str)) {
            last = mn.previous;
            mn.setPrevious(null);
            count--;
        }

        while (mn.previous != null) {
            if (mn.previous.getDataStr().equals(str)) {
                if (mn.previous.previous == null){
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
            System.out.print(mn.getDataStr() + " ");
            mn = mn.previous;

        }
    }


    public void reverse() {
    }

}

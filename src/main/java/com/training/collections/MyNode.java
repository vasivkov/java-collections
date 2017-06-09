package com.training.collections;

/**
 * Created by vasya on 07/06/17.
 */
class MyNode {
    private String dataStr;
    MyNode previous;

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    MyNode getPrevious() {
        return previous;
    }

    void setPrevious(MyNode previous) {
        this.previous = previous;
    }

    String getDataStr() {
        return dataStr;
    }


    MyNode(String dataStr) {
        this.dataStr = dataStr;
        previous = null;
    }


    public String toString() {
        return "data: " + dataStr; //+ ", previouse node:" + previous;
    }
}



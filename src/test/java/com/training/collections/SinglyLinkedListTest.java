package com.training.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vasya on 09/06/17.
 */
public class SinglyLinkedListTest {
    private SinglyLinkedList<String> singlyLinkedList;

    @Before
    public void setup() {
        singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("a");
        singlyLinkedList.add("b");
        singlyLinkedList.add("c");
        singlyLinkedList.add("d");
        singlyLinkedList.add("e");

    }

    @Test
    public void getElementTest() throws Exception {
        assertEquals("c", singlyLinkedList.get(2));
    }

    @Test
    public void getFirstTest() throws Exception {
        assertEquals("e", singlyLinkedList.get(0));

    }

    @Test
    public void getLastTest() throws Exception {
        assertEquals("a", singlyLinkedList.get(4));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOfBoundTest() throws Exception {
        singlyLinkedList.get(5);
    }


    @Test
    public void containsTest() throws Exception {
        assertTrue(singlyLinkedList.contains("b"));
        assertFalse(singlyLinkedList.contains("f"));
    }

    @Test
    public void size() throws Exception {
        assertEquals(5, singlyLinkedList.size());
    }

    @Test
    public void removeTest() throws Exception {
        singlyLinkedList.remove("c");
        assertEquals(4, singlyLinkedList.size());
        assertEquals("b", singlyLinkedList.get(2));
    }

    @Test
    public void removeTestFirstElem() throws Exception {
        singlyLinkedList.remove("a");
        String firstElem = singlyLinkedList.get(0);
        assertNotEquals("a", firstElem);
    }


    @Test
    public void reverseTest() throws Exception {
        singlyLinkedList.reverse();
        assertEquals("a", singlyLinkedList.get(0));
        assertEquals("b", singlyLinkedList.get(1));
        assertEquals("e", singlyLinkedList.get(4));
        assertEquals(5, singlyLinkedList.size());
    }

    @Test
    public void addToEndTest() throws Exception{
        SinglyLinkedList<String> sLL = new SinglyLinkedList<>();
        sLL.addToEnd("a");
        sLL.addToEnd("b");
        sLL.addToEnd("c");
        sLL.addToEnd("d");

        assertEquals("a", sLL.get(0));
        assertEquals(4, sLL.size());

    }

}
package com.training.collections;

import org.junit.Assert;
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
        assertEquals("a", singlyLinkedList.get(0));

    }

    @Test
    public void getLastTest() throws Exception {
        assertEquals("e", singlyLinkedList.get(4));

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
        assertEquals("d", singlyLinkedList.get(2));
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
        assertEquals("e", singlyLinkedList.get(0));
        assertEquals("d", singlyLinkedList.get(1));
        assertEquals("a", singlyLinkedList.get(4));
        assertEquals(5, singlyLinkedList.size());
    }

    @Test
    public void addTest() throws Exception{
        SinglyLinkedList<String> sLL = new SinglyLinkedList<>();
        sLL.add("a");
        sLL.add("b");
        sLL.add("c");
        sLL.add("d");

        assertEquals("a", sLL.get(0));
        assertEquals(4, sLL.size());

    }

    @Test
    public void doubleAdd() throws Exception{

        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.addToHead("1");
        list.addToHead("2");
        list.addToHead("3");


        assertEquals(6, list.size());
        assertEquals("a",list.get(3));
        assertEquals("c",list.get(5));
        assertEquals("3",list.get(0));
    }


    @Test
    public void setTest()throws Exception{
        String oldValue =  singlyLinkedList.set(0, "z" );
        assertEquals("z", singlyLinkedList.get(0));
        assertEquals("a", oldValue);
        assertEquals(5, singlyLinkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWithExceptionTest () throws Exception{
        singlyLinkedList.set(8, "z");
    }

    @Test
    public void addWithIndexTest() throws Exception{
        singlyLinkedList.add(1,"z");
       assertEquals("z",singlyLinkedList.get(1));
        assertEquals("b",singlyLinkedList.get(2));
        assertEquals(6, singlyLinkedList.size());
    }

    @Test
    public void addWithIndexFirstElementTest() throws Exception{
        singlyLinkedList.add(0,"z");
        assertEquals("z",singlyLinkedList.get(0));
        assertEquals("a",singlyLinkedList.get(1));
    }

    @Test
    public void addWithIndexLastElementTest() throws Exception{
        singlyLinkedList.add(5,"z");
        assertEquals("z",singlyLinkedList.get(5));
        assertEquals("e",singlyLinkedList.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithExceptionTest () throws Exception{
        singlyLinkedList.set(6, "z");
    }


    @Test
    public void removeByIndexTest() throws Exception{
        String deletedValue =  singlyLinkedList.remove(2);
        assertEquals("d", singlyLinkedList.get(2));
        assertEquals("c", deletedValue);
        assertEquals(4, singlyLinkedList.size());

    }

    @Test
    public void removeByIndexFirstElementTest() throws Exception{
        String deletedValue =  singlyLinkedList.remove(0);
        assertEquals("b", singlyLinkedList.get(0));
        assertEquals("a", deletedValue);
        assertEquals(4, singlyLinkedList.size());

    }


}
package com.training.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    public void addTest() throws Exception {
        SinglyLinkedList<String> sLL = new SinglyLinkedList<>();
        sLL.add("a");
        sLL.add("b");
        sLL.add("c");
        sLL.add("d");

        assertEquals("a", sLL.get(0));
        assertEquals(4, sLL.size());

    }

    @Test
    public void doubleAdd() throws Exception {

        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.addToHead("1");
        list.addToHead("2");
        list.addToHead("3");


        assertEquals(6, list.size());
        assertEquals("a", list.get(3));
        assertEquals("c", list.get(5));
        assertEquals("3", list.get(0));
    }


    @Test
    public void setTest() throws Exception {
        String oldValue = singlyLinkedList.set(0, "z");
        assertEquals("z", singlyLinkedList.get(0));
        assertEquals("a", oldValue);
        assertEquals(5, singlyLinkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWithExceptionTest() throws Exception {
        singlyLinkedList.set(8, "z");
    }

    @Test
    public void addWithIndexTest() throws Exception {
        singlyLinkedList.add(1, "z");
        assertEquals("z", singlyLinkedList.get(1));
        assertEquals("b", singlyLinkedList.get(2));
        assertEquals(6, singlyLinkedList.size());
    }

    @Test
    public void addWithIndexFirstElementTest() throws Exception {
        singlyLinkedList.add(0, "z");
        assertEquals("z", singlyLinkedList.get(0));
        assertEquals("a", singlyLinkedList.get(1));
    }

    @Test
    public void addWithIndexLastElementTest() throws Exception {
        singlyLinkedList.add(5, "z");
        assertEquals("z", singlyLinkedList.get(5));
        assertEquals("e", singlyLinkedList.get(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithExceptionTest() throws Exception {
        singlyLinkedList.set(6, "z");
    }


    @Test
    public void removeByIndexTest() throws Exception {
        String deletedValue = singlyLinkedList.remove(2);
        assertEquals("d", singlyLinkedList.get(2));
        assertEquals("c", deletedValue);
        assertEquals(4, singlyLinkedList.size());

    }

    @Test
    public void removeByIndexFirstElementTest() throws Exception {
        String deletedValue = singlyLinkedList.remove(0);
        assertEquals("b", singlyLinkedList.get(0));
        assertEquals("a", deletedValue);
        assertEquals(4, singlyLinkedList.size());

    }

    @Test
    public void indexOfTest() throws Exception {
        assertEquals(1, singlyLinkedList.indexOf("b"));
        assertEquals(-1, singlyLinkedList.indexOf("z"));
        assertEquals(-1, singlyLinkedList.indexOf(null));

    }

    @Test
    public void indexOfNullElementTest() throws Exception {
        singlyLinkedList.set(1, null);
        assertEquals(1, singlyLinkedList.indexOf(null));
        assertEquals(3, singlyLinkedList.indexOf("d"));
    }

    @Test
    public void lastIndexOfTest() throws Exception {
        singlyLinkedList.set(3, "a");
        assertEquals(3, singlyLinkedList.lastIndexOf("a"));
        assertEquals(-1, singlyLinkedList.lastIndexOf("z"));

    }

    @Test
    public void lastIndexOfNullElementTest() throws Exception {
        singlyLinkedList.set(1, null);
        assertEquals(1, singlyLinkedList.lastIndexOf(null));
        assertEquals(3, singlyLinkedList.lastIndexOf("d"));
    }

    @Test
    public void subListTest() throws Exception {
        List<String> sList = singlyLinkedList.subList(1, 3);
        assertEquals(2, sList.size());
        assertEquals("b", sList.get(0));
    }

    @Test
    public void containsAllPositiveTest() throws Exception {
        List<String> list = Arrays.asList("b", "c", "d");
        assertTrue(singlyLinkedList.containsAll(list));
    }

    @Test
    public void containsAllNegativeTest() throws Exception {
        List<String> list = Arrays.asList("b", "c", "z");
        assertFalse(singlyLinkedList.containsAll(list));
    }

    @Test
    public void addAllTest() throws Exception {
        List<String> list = Arrays.asList("1", "2", "3");
        singlyLinkedList.addAll(1, list);
        assertEquals(8, singlyLinkedList.size());
        assertEquals("2", singlyLinkedList.get(2));
    }


    @Test
    public void removeAllTest() throws Exception {
        List<String> list = Arrays.asList("d", "z", "b");
        assertTrue(singlyLinkedList.removeAll(list));
        assertEquals(3, singlyLinkedList.size());
        assertEquals("c", singlyLinkedList.get(1));
        assertFalse(singlyLinkedList.contains("d"));
        singlyLinkedList.printList();
    }

    @Test
    public void retainAllTest() throws Exception {
        List<String> list = Arrays.asList("d", "z", "b");
        assertTrue(singlyLinkedList.retainAll(list));
        assertEquals(2, singlyLinkedList.size());
        assertEquals("d", singlyLinkedList.get(1));
        assertFalse(singlyLinkedList.contains("c"));

    }

}
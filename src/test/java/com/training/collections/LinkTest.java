package com.training.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vasya on 09/06/17.
 */
public class LinkTest {
    private Link<String> link;
    @Before
    public void setup() {
        link = new Link<>();
        link.add("a");
        link.add("b");
        link.add("c");
        link.add("d");
        link.add("e");

    }

    @Test
    public void containValueTest()throws Exception{
        assertTrue(link.contains("b"));
        assertFalse(link.contains("f"));
    }

    @Test
    public void size() throws  Exception{
        assertEquals(5, link.size());
    }

    @Test
    public void removeValueTest () throws Exception{
        link.remove("c");
        assertEquals(4, link.size());
        assertEquals(link.last.getPrevious().getPrevious().getT(), "b");

    }

    @Test
    public void removeValueTest_firstElem () throws Exception{
        link.remove("a");
        MyNode myNode = link.last.previous.previous.previous.previous;
        assertEquals(null, myNode);
    }


    @Test
    public void reverseTest() throws Exception{
        link.reverse();
        assertEquals("a", link.last.getT());
        assertEquals(5, link.size());
        assertEquals(link.last.getPrevious().getT(), "b");
        assertEquals(link.last.getPrevious().getPrevious().getT(), "c");
    }

    @Test
    public void testForTest() throws Exception{
        link.printList();
        System.out.println();
//        link.remove("a");
//        link.printList();

        link.reverse();
        link.printList();
    }

}
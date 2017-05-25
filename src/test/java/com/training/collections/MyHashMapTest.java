package com.training.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by vasya on 22/04/17.
 */
public class MyHashMapTest {
    private MyHashMap<Integer, String> myHashMap;

    @Before
    public void setup() {
        myHashMap = new MyHashMap<>();
        myHashMap.put(1, "a");
        myHashMap.put(null, "b");
        myHashMap.put(3, "c");
        myHashMap.put(4, null);
        myHashMap.put(1, "d");

    }

    @Test
    public void get() throws Exception {

        String result = myHashMap.get(5);
        assertNull(result);
    }

    @Test
    public void testSize() throws Exception {

        assertEquals(4, myHashMap.size());

    }
    @Test
    public void testIsEmpty() throws Exception{
        assertEquals(false, myHashMap.isEmpty());
    }

    @Test
    public void testContainsKey() throws  Exception{
        assertEquals(false, myHashMap.containsKey(2));
    }
    @Test
    public void testContainsKey2() throws  Exception{
        assertEquals(true, myHashMap.containsKey(1));
    }


    @Test
    public void testContainsValue() throws  Exception{
        assertEquals(true, myHashMap.containsValue("c"));
    }
    @Test
    public void testContaisValue2() throws Exception{
        assertEquals(true, myHashMap.containsValue(null));
    }

    @Test
    public void testGet() throws Exception{
        assertEquals("d", myHashMap.get(1));
    }
    @Test
    public void testGet2() throws Exception{
        assertEquals(null, myHashMap.get(2));
    }

    @Test
    public void testPut(){
        myHashMap.put(5, "e");
        myHashMap.put(null, "f");
        assertEquals("f", myHashMap.get(null));
        assertEquals(true, myHashMap.containsValue("f"));
        assertEquals(5, myHashMap.size());

    }



    @Test
    public void testContainsNullValue() throws Exception {
        MyHashMap<String, Integer> mhm = new MyHashMap<>();
        mhm.put("key", null);
        assertFalse(mhm.containsValue("key2"));
    }

    @Test
    public void testRemoveSizeDescreased() throws Exception {
        assertEquals(4, myHashMap.size());
        assertEquals("b", myHashMap.remove(null));
        assertEquals(3, myHashMap.size());
        assertNull(myHashMap.remove(null));

    }

    @Test //TODO
    public void testClear(){
        myHashMap.clear();
        assertEquals(0, myHashMap.size());
    }

    @Test
    public void testKeySet(){
        Set<Integer> keys = new HashSet<>();
        keys.add(1);
        keys.add(3);
        keys.add(4);
        keys.add(null);
        assertEquals(myHashMap.keySet(), keys);
    }

    @Test
    public void testValues(){
        List<String> listOfValues = new ArrayList<>();
        listOfValues.add("b");
        listOfValues.add("d");
        listOfValues.add("c");
        listOfValues.add(null);
        assertEquals(listOfValues, myHashMap.values());
    }
}
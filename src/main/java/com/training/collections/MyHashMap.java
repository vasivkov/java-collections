package com.training.collections;

/**
 * Created by vasya on 22/04/17.
 */

import java.util.*;

/**
 * Created by vasya on 13/04/17.
 */
public class MyHashMap<K, V> implements Map<K, V> {
    private List<List<Entry<K, V>>> buckets = new ArrayList<>(16);
    private int capacity;
    private final int startCapacity ;
    private final double LOAD_FACTOR = 0.75;
    private int count = 0;

    public MyHashMap() {
        this(16);
    }


    public MyHashMap(int myCapacity) {
        this.capacity = myCapacity;
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<Entry<K, V>>());
        }
        startCapacity = capacity;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null){
            for(int i = 0; i < buckets.get(0).size(); i++){
                if (buckets.get(0).get(i).getKey() == null){
                    return true;
                }
            }
            return false;
        }

        int indexOfBucket = Math.abs(key.hashCode()) % capacity;
        if (buckets.get(indexOfBucket).isEmpty()) {
            return false;
        }
        List<Entry<K, V>> innerBuckets = buckets.get(indexOfBucket);
        for (Entry<K, V> innerBucket : innerBuckets) {
            if ( innerBucket.getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null){
            for (List<Entry<K, V>> bucket : buckets) {
                for (Entry<K, V> aBucket : bucket) {
                    if (aBucket.getValue() == null) {
                        return true;
                    }
                }

            }
            return false;
        }

        for (List<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> aBucket : bucket) {
                if (value.equals(aBucket.getValue())) {
                    return true;
                }
            }

        }

        return false;
    }

    @Override
    public V get(Object key) {

        if (key == null){
            if (buckets.get(0).isEmpty()){
                return null;
            } else {
                for(Entry<K, V> entry: buckets.get(0)){
                    if(entry.getKey() == null){
                        return entry.getValue();
                    }
                }
                return null;
            }
        }

        if (buckets.isEmpty()) {
            return null;
        }
        int indexOfBucket = Math.abs(key.hashCode()) % capacity;


        if (buckets.get(indexOfBucket).isEmpty()) {
            return null;
        } else {
            List<Entry<K, V>> bucket = buckets.get(indexOfBucket);
            for (Entry<K, V> aBucket : bucket) {
                if (aBucket.getKey().equals(key)) {
                    return aBucket.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {

        if (key == null){
            if (buckets.get(0).isEmpty()){
                buckets.get(0).add(new AbstractMap.SimpleEntry<K, V>(key, value));
                count++;

            }else{
                List<Entry<K, V>> innerList = buckets.get(0);
                for (Entry<K, V> entry : innerList) {
                    if (entry.getKey() == null){
                        V previousValue = entry.getValue();
                        entry.setValue(value);
                        return previousValue;
                    }
                }
                innerList.add((new AbstractMap.SimpleEntry<K, V>(key, value)));
                count++;

            }
            return null;
        }

        int indexOfBuckets = Math.abs(key.hashCode())  % capacity;

        if (buckets.get(indexOfBuckets).isEmpty()) {
            buckets.get(indexOfBuckets).add(new AbstractMap.SimpleEntry<K, V>(key, value));
            count++;
        } else {
            List<Entry<K, V>> innerList = buckets.get(indexOfBuckets);
            for (Entry<K, V> entry : innerList) {
                if (key.equals(entry.getKey())) {
                    V previousValue = entry.getValue();
                    entry.setValue(value);
                    return previousValue;
                }

            }
            innerList.add(new AbstractMap.SimpleEntry<K, V>(key, value));
            count++;

        }
        return null;
    }

    @Override
    public V remove(Object key) {

        if (key == null){
            if (buckets.get(0).isEmpty()){
                return null;
            }
            for(int i = 0; i < buckets.get(0).size(); i++){
                if (buckets.get(0).get(i).getKey() == null){
                    count--;
                    return buckets.get(0).remove(i).getValue();
                }
            }
            return null;
        }

        int indexOfBucket = key.hashCode() % capacity;
        List<Entry<K, V>> innerList = buckets.get(indexOfBucket);
        for (int i = 0; i < innerList.size(); i++) {
            if (innerList.get(i).getKey().equals(key)) {
                V delValue = innerList.get(i).getValue();
                innerList.remove(i);
                count--;
                return delValue;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if(m.isEmpty()){
            return;
        }

        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }

    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.size(); i++) {
            if (i > startCapacity) {
                buckets.remove(i);
            } else {
                buckets.get(i).clear();
            }
        }

        count = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();

        for (List<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> aBucket : bucket) {
                keys.add(aBucket.getKey());
            }

        }

        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<V>();
        for (List<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> aBucket : bucket) {
                values.add(aBucket.getValue());
            }

        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (List<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> aBucket : bucket) {
                entries.add(new AbstractMap.SimpleEntry<K, V>(aBucket.getKey(), aBucket.getValue()));
            }

        }

        return entries;
    }
}


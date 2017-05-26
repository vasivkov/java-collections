package com.training.collections;

/**
 * Created by vasya on 22/04/17.
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vasya on 13/04/17.
 */
public class MyHashMap<K, V> implements Map<K, V> {
    private List<List<Entry<K, V>>> buckets = new ArrayList<>(16);
    private int capacity;
    private static final double LOAD_FACTOR = 0.75;
    private int count;

    public MyHashMap() {
        this(16);
    }


    public MyHashMap(int myCapacity) {
        this.capacity = myCapacity;
        initWithEmptyLists();
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

        int indexOfBucket = (key == null) ? 0 : Math.abs(key.hashCode()) % capacity;
        return buckets.get(indexOfBucket).stream().anyMatch(k -> Objects.equals(key, k.getKey()));
    }

    @Override
    public boolean containsValue(Object value) {
        return buckets.stream().flatMap(bucket -> bucket.stream()).anyMatch(v -> Objects.equals(value, v.getValue()));
    }

    @Override
    public V get(Object key) {


        int indexOfBucket = (key == null) ? 0 : Math.abs(key.hashCode()) % capacity;
        return buckets.get(indexOfBucket).stream()
                .filter(k -> Objects.equals(k.getKey(), key))
                .map(entry -> entry.getValue())
                .findFirst().orElse(null);
    }

    @Override
    public V put(K key, V value) {


        int indexOfBuckets = (key == null) ? 0 :  Math.abs(key.hashCode()) % capacity;

        if (buckets.get(indexOfBuckets).isEmpty()) {
            buckets.get(indexOfBuckets).add(new AbstractMap.SimpleEntry<K, V>(key, value));
            count++;
            if (capacity * LOAD_FACTOR < count) {
                reHash();
            }

        } else {
            List<Entry<K, V>> innerList = buckets.get(indexOfBuckets);
            for (Entry<K, V> entry : innerList) {
                if (Objects.equals(key, entry.getKey())) {
                    V previousValue = entry.getValue();
                    entry.setValue(value);
                    return previousValue;
                }

            }
            innerList.add(new AbstractMap.SimpleEntry<K, V>(key, value));
            count++;
            if (capacity * LOAD_FACTOR < count) {
                reHash();
            }


        }
        return null;
    }

    @Override
    public V remove(Object key) {
        
        int indexOfBucket = (key == null) ? 0 : key.hashCode() % capacity;
        List<Entry<K, V>> innerList = buckets.get(indexOfBucket);
        for (int i = 0; i < innerList.size(); i++) {
            if (Objects.equals(innerList.get(i).getKey(),key) ) {
                count--;
                return innerList.remove(i).getValue();
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (m.isEmpty()) {
            return;
        }

        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }

    }

    @Override
    public void clear() {
        buckets.clear();
        initWithEmptyLists();
        count = 0;
    }

    @Override
    public Set<K> keySet() {
       return buckets.stream().flatMap(list -> list.stream()).map(entry -> entry.getKey()).collect(Collectors.toSet());

    }

    @Override
    public Collection<V> values() {
       return buckets.stream().flatMap(list -> list.stream()).map(val -> val.getValue()).collect(Collectors.toList());

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return buckets.stream().flatMap(list -> list.stream()).collect(Collectors.toSet());

    }

    private void reHash() {
        List<Entry<K, V>> tempList = new ArrayList<>();
        for (List<Entry<K, V>> bucket : buckets) {
            tempList.addAll(bucket);
        }
        clear();
        capacity *= 2;
        for (Entry<K, V> aTempList : tempList) {
            put(aTempList.getKey(), aTempList.getValue());
        }

    }

    private void initWithEmptyLists() {
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }


}


package com.studying.datastructures.list;

import java.util.StringJoiner;

public abstract class AbstractList<T> implements List<T>{
    protected int size;
    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for(T value : this){
            result.add(String.valueOf(value));
        }
        return result.toString();
    }

}

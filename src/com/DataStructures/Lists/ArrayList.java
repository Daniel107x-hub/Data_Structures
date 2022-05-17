package com.DataStructures.Lists;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> implements IList<T>{
    private static final int INITIAL_CAPACITY = 2;
    private static final int MAX_CAPACITY = 1024;
    private static final int RESIZE_FACTOR = 2;
    private static final int LOAD_FACTOR = 3;

    private T[] array;

    private int size;
    private int capacity;
    private Class<T> clazz;

    public ArrayList(Class<T> clazz){
        this.array = (T[]) Array.newInstance(clazz, INITIAL_CAPACITY);
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
        this.clazz = clazz;
    }

    @Override
    public boolean add(T element) {
        if(this.size + 1 == this.capacity){
            if(this.capacity == MAX_CAPACITY){
                return false;
            }
            this.expand();
        }
        this.array[size] = element;
        this.size++;
        return true;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size){
            return null;
        }
        return this.array[index];
    }

    @Override
    public boolean remove(int index) {
        if(index < 0 || index >= this.size){
            return false;
        }
        this.reacommodate(index);
        this.size--;
        if(this.size <= this.capacity / LOAD_FACTOR){
            this.shrink();
        }
        return true;
    }

    @Override
    public boolean set(int index, T newElement) {
        if(index < 0 || index >= this.size){
            return false;
        }
        this.array[index] = newElement;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder("List: [");
        for(int i = 0 ; i < this.size ; i++){
            if(this.array[i] != null) {
                elements.append(this.array[i]);
            }
            if(this.array[i + 1] != null){
                elements.append(", ");
            }
        }
        elements.append("]");
        return elements.toString();
    }

    public int getSize() {
        return size;
    }

    private void expand(){
        T[] oldArray = this.array;
        this.array = (T[]) Array.newInstance(this.clazz, this.capacity * RESIZE_FACTOR);
        this.capacity *= RESIZE_FACTOR;
        for(int i = 0 ; i < this.size ; i++){
            this.array[i] = oldArray[i];
        }
    }

    private void reacommodate(int index){
        for(int i = index ; i < size ; i++){
            this.array[i] = this.array[i + 1];
        }
    }

    private void shrink(){
        T[] oldArray = this.array;
        this.array = (T[]) Array.newInstance(this.clazz, this.capacity / RESIZE_FACTOR);
        this.capacity /= RESIZE_FACTOR;
        for(int i = 0 ; i < this.size ; i++){
            this.array[i] = oldArray[i];
        }
    }
}

package com.datastructures.list;

public interface IList<T> {
    public boolean add(T element);
    public T get(int index);
    public boolean remove(int index);
    public boolean set(int index, T newElement);
    public int getSize();
}

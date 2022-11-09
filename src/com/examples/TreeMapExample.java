package com.examples;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        simpleTreeMap();
    }

    public static void simpleTreeMap(){
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(10, "Hello");
        map.put(5, "World");
        map.put(14, "This");
        map.put(16, "rules");

        System.out.println(map);
    }


}

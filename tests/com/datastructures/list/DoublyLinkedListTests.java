package com.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class DoublyLinkedListTests {
    private class Student{
        private Integer id;
        private String name;

        public Student(Integer id) {
            this.id = id;
        }

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Student student = (Student) o;
            return Objects.equals(id, student.getId());
        }
    }

    @Test
    public void storePrimitiveList(){
        IListExtended<Integer> list = new DoublyLinkedList<>();
        for(int i=0;i<10;i++){
            list.pushFront(i);
            Assertions.assertEquals(i + 1, list.getSize());
        }
        for(int i=9;i>=0;i--){
            Integer element = list.topFront();
            Assertions.assertEquals(i, element);
            list.popFront();
            Assertions.assertEquals(i, list.getSize());
        }
        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void storeCustomClassList(){
        Student student1 = new Student(1, "Daniel");
        Student student2 = new Student(2, "Carl");
        Student student3 = new Student(3, "Miranda");
        IListExtended<Student> list = new DoublyLinkedList<>();
        list.pushFront(student1);
        list.pushFront(student2);
        list.pushFront(student3);
        list.remove(new Student(3));
        System.out.println(list.getSize());
    }
}

package com.wzy.genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericityExtendsDemo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

//        print(integerList);
    }

//    public static void print(List<? super Student> studentList) {
//        Student student;
//        for (int i = 0; i < studentList.size(); i++) {
//            student = studentList.get(i);
//        }
//    }

    public static class Person<T> {
        protected String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class Student extends Person {
        private String stuNo;

        public String getStuNo() {
            return stuNo;
        }

        public void setStuNo(String stuNo) {
            this.stuNo = stuNo;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", stuNo='" + stuNo + '\'' +
                    '}';
        }
    }
}

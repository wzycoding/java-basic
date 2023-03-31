package com.wzy.genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericityExtendsDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Student());

        print(personList);

        List<Student> studentList = new ArrayList<>();

        // 这样主要找不到这个T是什么，T要是Student的子类，Person的父类
        // Student的子类没有也就是下限没有，Person的父类就是Object,上限是Object
//        Collections.copy(studentList, personList);
    }

    public static void print(List<? super Student> studentList) {
//        使用类似<? super Integer>通配符作为方法参数时表示：
//
//        方法内部可以调用传入Integer引用的方法，例如：obj.setFirst(Integer n);；
//
//        方法内部无法调用获取Integer引用的方法（Object除外），例如：Integer n = obj.getFirst();。
//
//        即使用super通配符表示只能写不能读。
//        Student object = studentList.get(1);

    }

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

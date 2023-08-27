package com.wzy.reflect;

public class ParentClass {

    protected Integer parentAge;

    public Integer parentName;

    public ParentClass() {
    }

    public ParentClass(Integer parentAge) {
        this.parentAge = parentAge;
    }

    static {
        System.out.println("ParentClass类已经被加载了");
    }

    public static void staticParentClassMethod() {
        System.out.println("执行了ParentClass类的静态方法");
    }

    public void publicParentClassMethod() {
        System.out.println("执行了ParentClass类的public方法");
    }

    protected void protectedParentClassMethod() {
        System.out.println("执行了ParentClass类的protected方法");
    }

    void defaultParentClassMethod() {
        System.out.println("执行了ParentClass类的default方法");
    }

    private void privateParentClassMethod() {
        System.out.println("执行了ParentClass类的private方法");
    }

}
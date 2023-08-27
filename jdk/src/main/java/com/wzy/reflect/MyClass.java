package com.wzy.reflect;

public class MyClass extends ParentClass {

    private Integer myClassAge;

    private MyClass(String myClassAge) {
        this.myClassAge = Integer.valueOf(myClassAge);
        System.out.println("执行了MyClass的私有含参构造函数");
    }

    public MyClass() {
        System.out.println("执行了MyClass的公有无参构造函数");
    }

    public MyClass(Integer myClassAge) {
        this.myClassAge = myClassAge;
        System.out.println("执行了MyClass的公有含参构造函数");
    }

    static {
        System.out.println("MyClass类已经被加载了");
    }

    public static void staticMyClassMethod() {
        System.out.println("执行了MyClass类的静态方法");
    }

    public void publicMyClassMethod() {
        System.out.println("执行了MyClass类的public方法");
    }

    protected void protectedMyClassMethod() {
        System.out.println("执行了MyClass类的protected方法");
    }

    void defaultMyClassMethod() {
        System.out.println("执行了MyClass类的default方法");
    }

    private void privateMyClassMethod() {
        System.out.println("执行了MyClass类的private方法");
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "myClassAge=" + myClassAge +
                '}';
    }
}
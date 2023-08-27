package com.wzy.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射用法案例
 *
 * @author wzy
 * @date 2023-08-26 10:05:41
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 1、获取class对象
//        Class<MyClass> myClassClass1 = MyClass.class;
//        Class<?> myClassClass2 = Class.forName("com.wzy.reflect.MyClass");
//        Class<? extends MyClass> myClassClass3 = new MyClass().getClass();
//
//        System.out.println(myClassClass1 == myClassClass2);
//        System.out.println(myClassClass2 == myClassClass3);

        // 2、创建对象使用反射
//        Class<MyClass> myClassClass1 = MyClass.class;
//
//        Constructor<?>[] constructors = myClassClass1.getConstructors();
//        Constructor<?>[] declaredConstructors = myClassClass1.getDeclaredConstructors();
//
//        for (Constructor<?> constructor : constructors) {
//            System.out.println(constructor);
//        }
//
//        System.out.println("======================");
//
//        for (Constructor<?> declaredConstructor : declaredConstructors) {
//            System.out.println(declaredConstructor);
//        }

//
//        Class<MyClass> myClassClass1 = MyClass.class;
//        // 获取构造函数
//        Constructor<MyClass> constructor1 = myClassClass1.getConstructor(Integer.class);
//        // 对象的创建
//        MyClass myClassInstance = constructor1.newInstance(20);
//        myClassInstance.publicMyClassMethod();

//        Class<? extends MyClass> myClassClazz = MyClass.class;
//        Field[] fields = myClassClazz.getFields();
//        Field[] declaredFields = myClassClazz.getDeclaredFields();
//        System.out.println("======getFields=====");
//        for (Field field : fields) {
//            System.out.println(field);
//        }
//
//        System.out.println("=====declaredFields======");
//
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField);
//        }
//
//        Field parentNameField = myClassClazz.getField("parentName");
//        Field myClassAgeField = myClassClazz.getDeclaredField("myClassAge");
//
//        System.out.println("======getField=====");
//        System.out.println(parentNameField);
//        System.out.println("======getDeclaredField=====");
//        System.out.println(myClassAgeField);

//        MyClass myClass = new MyClass(20);
//        Field myClassAgeField = myClass.getClass().getDeclaredField("myClassAge");
//
//        // 不进行Java语言访问权限检查
//        myClassAgeField.setAccessible(true);
//        Integer myClassAge = (Integer) myClassAgeField.get(myClass);
//        System.out.println("反射获取myClassAge属性的值：" + myClassAge);
//        myClassAgeField.set(myClass, 40);
//        Integer modifyMyClassAge = (Integer) myClassAgeField.get(myClass);
//        System.out.println("反射获取myClassAge属性的值：" + modifyMyClassAge);

//        Class<? extends MyClass> myClassClazz = MyClass.class;
//        Method[] methods = myClassClazz.getMethods();
//        Method[] declaredMethods = myClassClazz.getDeclaredMethods();
//        System.out.println("======getMethods=====");
//        for (Method method : methods) {
//            System.out.println(method);
//        }
//
//        System.out.println("=====declaredMethods======");
//
//        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
//        }
//
//        Method publicMyClassMethod = myClassClazz.getMethod("publicMyClassMethod");
//        Method privateMyClassMethod = myClassClazz.getDeclaredMethod("privateMyClassMethod");
//
//        System.out.println("======getMethod=====");
//        System.out.println(publicMyClassMethod);
//        System.out.println("======getDeclaredMethod=====");
//        System.out.println(privateMyClassMethod);

//        MyClass myClass = new MyClass();
//        Class<? extends MyClass> myClassClazz = myClass.getClass();
//        Method privateMyClassMethod = myClassClazz.getDeclaredMethod("privateMyClassMethod");
//
//        // 不进行Java语言访问权限检查
//        privateMyClassMethod.setAccessible(true);
//        // 反射调用方法
//        privateMyClassMethod.invoke(myClass);
//        Method method;
//        Class clazz;
//        Constructor constructor;
//        Field field;
//        constructor.isAnnotationPresent(Autowired.class);
//        method.isAnnotationPresent(Autowired.class);
//        field.isAnnotationPresent(Autowired.class);
//        clazz.isAnnotationPresent(Component.class);
//
//
//        Method method;
//        Class clazz;
//        Constructor constructor;
//        Field field;
//        constructor.getAnnotation(Autowired.class);
//        method.getAnnotation(Autowired.class);
//        field.getAnnotation(Autowired.class);
//        clazz.getAnnotation(Component.class);


        Class<?>[] interfaces = MyClass.class.getInterfaces();

        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }


    }
}

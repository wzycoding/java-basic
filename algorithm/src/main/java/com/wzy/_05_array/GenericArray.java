package com.wzy._05_array;

/**
 * 实现一个支持泛型的可变长度的数组
 *
 * @param <T>
 * @author wzy
 * @date 2023-07-31 23:11:32
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T e) {
        if (e == null) {
            return;
        }
        ensureCapacity(size + 1);
        this.data[size] = e;
        size++;
    }

    private void ensureCapacity(int targetSize) {
        if (targetSize > this.data.length) {
            resize();
        }
    }

    private void resize() {
        System.out.println("内部进行扩容，扩容前容量：" + this.data.length);
        T[] oldData = this.data;
        this.data = (T[]) new Object[this.data.length * 2];
        for (int i = 0; i < size(); i++) {
            this.data[i] = oldData[i];
        }
        System.out.println("扩容后容量：" + this.data.length);
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        // 将最后一个元素置空
        this.data[size - 1] = null;
        size--;
        return index;
    }

    public int remove(T e) {
        if (e == null) {
            return -1;
        }
        // 这里只做了删除第一个出现的元素
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (e.equals(data[i])) {
                index = i;
            }
        }

        // 没找到直接返回
        if (index == -1) {
            return index;
        }

        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        // 将最后一个元素置空
        this.data[size - 1] = null;
        size--;
        return index;
    }

    public int find(T e) {
        if (e == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return this.data[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GenericArray{" +
                "data=[");

        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(this.data[i].toString());
            if (i != size - 1) {
                stringBuilder.append(",");
            } else {
                stringBuilder.append("]");
            }
        }

        stringBuilder.append(", size:" + size + "}");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        GenericArray<String> stringGenericArray = new GenericArray<>(4);

        stringGenericArray.add("小王");
        stringGenericArray.add("小李");
        stringGenericArray.add("小赵");
        stringGenericArray.add("小红");
        stringGenericArray.add("小绿");

        System.out.println("集合内容：" + stringGenericArray);

        System.out.println("第三个元素：" + stringGenericArray.get(2));
        System.out.println("小红的元素在哪个位置：" + stringGenericArray.find("小红"));
        System.out.println("删除小红元素：" + stringGenericArray.remove("小红"));
        System.out.println("集合内容：" + stringGenericArray);
        System.out.println("删除第二个元素：" + stringGenericArray.remove(1));
        System.out.println("集合内容：" + stringGenericArray);
    }
}

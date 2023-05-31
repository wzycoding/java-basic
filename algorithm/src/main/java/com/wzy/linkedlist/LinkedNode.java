package com.wzy.linkedlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LinkedNode<T> {
    private T data;
    private LinkedNode<T> next;

    public LinkedNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public LinkedNode<T> setNext(LinkedNode<T> next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "data=" + data +
                '}';
    }
}

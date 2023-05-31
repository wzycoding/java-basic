package com.wzy.linkedlist;

/**
 * @author wzy
 */
public class LinkedListMain {

    /**
     * 获取单向链表的倒数第几个节点
     *
     * @param headNode 头结点
     * @param k        倒数第几个节点
     */
    public static <T> LinkedNode<T> getLinkedListReciprocalWhichElement(LinkedNode<T> headNode, int k) {
        // 求链表长度
        LinkedNode<T> currentNode = headNode;
        int i = 1;
        while (currentNode.getNext() != null) {
            i++;
            currentNode = currentNode.getNext();
        }

        // 计算正数第几个元素
        int num = i - k + 1;

        // 获取指定元素
        LinkedNode<T> nowNode = headNode;
        for (int j = 1; j < num; j++) {
            nowNode = nowNode.getNext();
        }

        return nowNode;
    }

    public static void main(String[] args) {
        LinkedNode<String> headNode = new LinkedNode<>("a");
        headNode.setNext(new LinkedNode<>("b"));
        headNode.getNext().setNext(new LinkedNode<>("c"))
                .setNext(new LinkedNode<>("d"))
                .setNext(new LinkedNode<>("e"))
                .setNext(new LinkedNode<>("f"))
                .setNext(new LinkedNode<>("g"))
                .setNext(new LinkedNode<>("h"))
                .setNext(new LinkedNode<>("i"))
                .setNext(new LinkedNode<>("j"))
                .setNext(new LinkedNode<>("k"));

        LinkedNode<String> targetNode = getLinkedListReciprocalWhichElement(headNode, 3);

        System.out.println(targetNode);
    }
}

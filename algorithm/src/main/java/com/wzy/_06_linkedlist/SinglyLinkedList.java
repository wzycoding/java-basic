package com.wzy._06_linkedlist;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 * <p>
 *
 * @author wzy
 * @date 2023-08-01 08:26:41
 */
public class SinglyLinkedList {
    /**
     * 链表头结点
     */
    private Node head;

    /**
     * 单链表结构定义
     */
    public static class Node {
        /**
         * 节点数据
         */
        private int data;
        /**
         * 指向下一个节点的指针
         */
        private Node next;

        public int getData() {
            return data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 通过值来查找链表节点
     *
     * @param value 值
     * @return 节点对象
     */
    public Node findByValue(int value) {
        if (head == null) {
            return null;
        }

        Node currentNode = head;
        while (currentNode != null && currentNode.data != value) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    /**
     * 通过索引来进行查询元素
     *
     * @param index index
     * @return 元素对象
     */
    public Node findByIndex(int index) {
        Node currentNode = head;

        int pos = 0;

        while (currentNode != null && pos < index) {
            currentNode = currentNode.next;
            pos++;
        }
        return currentNode;
    }

    /**
     * 在链表头部插入指定值的节点(头插法)
     *
     * @param value 值
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    /**
     * 在链表头部插入节点（头插法）
     *
     * @param newNode 节点对象
     */
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 在链表的尾部插入指定值的节点
     *
     * @param value 指定值
     */
    public void insertTail(int value) {
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            // 遍历找到最后一个节点
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }
    }

    /**
     * 在某个节点之后插入
     *
     * @param p     指定节点
     * @param value 插入节点的值
     */
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    /**
     * 在某个节点后插入新的节点
     *
     * @param p       指定节点
     * @param newNode 新节点
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
    }

    /**
     * 插入节点在指定节点之前
     *
     * @param p     指定节点
     * @param value 插入节点的值
     */
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    /**
     * 插入新的节点在指定节点之前
     *
     * @param p       指定节点
     * @param newNode 插入节点的值
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        // 如果p是头结点
        if (p == head) {
            insertToHead(newNode);
            return;
        }

        // 找到p的前一个节点
        Node currentNode = head;
        while (currentNode != null && currentNode.next != p) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return;
        }

        newNode.next = p;
        currentNode.next = newNode;
    }

    /**
     * 删除指定节点
     *
     * @param p 指定节点
     */
    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        // 如果是头节点
        if (p == head) {
            head = head.next;
        } else {
            // 找到删除节点的前一个节点
            Node currentNode = head;
            while (currentNode != null && currentNode.next != p) {
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                return;
            }

            currentNode.next = p.next;
        }
    }

    /**
     * 删除指定节点通过节点的值
     *
     * @param value 节点值
     */
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node currentNode = head;
        Node preNode = null;

        while (currentNode != null && currentNode.data != value) {
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        // 如果为空说明没找到直接返回
        if (currentNode == null) {
            return;
        }

        // 为空说明要删除的是头节点
        if (preNode == null) {
            head = head.next;
        } else {
            preNode.next = currentNode.next;
            currentNode.next = null;
        }
    }

    /**
     * 输出链表元素
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.insertToHead(new SinglyLinkedList.Node(1, null));
        singlyLinkedList.insertToHead(new SinglyLinkedList.Node(2, null));
        singlyLinkedList.insertToHead(new SinglyLinkedList.Node(3, null));
        singlyLinkedList.printAll();

        Node secondNode = singlyLinkedList.findByIndex(1);
        System.out.println("链表中第二个元素：" + secondNode);
        Node value2Node = singlyLinkedList.findByValue(2);
        System.out.println("链表中值等于2的元素：" + value2Node);

        singlyLinkedList.insertToHead(4);
        singlyLinkedList.printAll();

        singlyLinkedList.insertTail(0);
        singlyLinkedList.printAll();

        singlyLinkedList.insertAfter(secondNode, -1);
        singlyLinkedList.printAll();

        singlyLinkedList.insertAfter(secondNode, new Node(-2, null));
        singlyLinkedList.printAll();

        singlyLinkedList.insertBefore(secondNode, new Node(6, null));
        singlyLinkedList.insertBefore(secondNode, 7);
        singlyLinkedList.printAll();

        singlyLinkedList.deleteByNode(secondNode);
        singlyLinkedList.deleteByValue(0);
        singlyLinkedList.printAll();

    }

}

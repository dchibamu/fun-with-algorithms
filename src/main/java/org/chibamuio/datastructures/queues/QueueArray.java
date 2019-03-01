package org.chibamuio.datastructures.queues;

public class QueueArray<T> {

    Node<T> [] arrayQueue;
    int rear;
    int front;
    int size;

    public QueueArray(int size) {
        this.size = size;

    }

    public Node<T>[] getArrayQueue() {
        return arrayQueue;
    }

    public void setArrayQueue(Node<T>[] arrayQueue) {
        this.arrayQueue = arrayQueue;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    class Node<T> {
        T data;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}

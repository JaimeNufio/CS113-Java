import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = Math.random() < 0.5 ? new AStack<Integer>() :
                                                     new RStack<Integer>();
        int n = Integer.parseInt(args[0]);
        long start, stop;

        System.out.println(stack);
        System.out.println("push");

        start = System.currentTimeMillis();

        for (int i = 0; i < n; ++i) {
            stack.push(i);
            System.out.print(i + ": ");
            for (Integer j : stack) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("pop");

        Integer i;

        while ((i = stack.pop()) != null) {
            System.out.print(i + ": ");
            for (Integer j : stack) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        stop = System.currentTimeMillis();

        System.out.println("time: " + (stop - start));
    }
}

interface Stack<E> extends Iterable<E> {
    E pop();
    void push(E data);
}

class AStack<E> implements Stack<E> {

    private class StackIterator<E> implements Iterator<E> {
        public boolean hasNext() {
            return curr > 0;
        }
        public E next() {
            return (E)stack[--curr];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        private int curr = top;
    }

    private void grow() {

        Object[] temp = new Object[stack.length * 2];

        for (int i = 0; i < stack.length; ++i) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

    public Iterator<E> iterator() {

        return new StackIterator<E>();
    }

    public E pop() {

        if (stack.length > 10 && top <= stack.length / 3) {
            shrink();
        }

        if (top > 0) {
            return (E)stack[--top];
        }

        return null;
    }

    public void push(E data) {

        if (top >= stack.length) {
            grow();
        }

        if (top < stack.length) {
            stack[top++] = data;
        }
    }

    private void shrink() {

        Object[] temp = new Object[stack.length / 2];

        for (int i = 0; i < temp.length; ++i) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

    private Object[] stack = new Object[10];
    private int top;
}

class RStack<E> implements Stack<E> {

    private class Node<T> {
        private Node(T data) {
            this.data = data;
        }
        private T data;
        private Node<T> next;
    }

    public Iterator<E> iterator() {

        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
            private Node<E> curr = head;
        };
    }

    public E pop() {

        E temp = null;

        if (head != null) {
            temp = head.data;
            head = head.next;
        }

        return temp;
    }

    public void push(E data) {

        Node<E> temp = new Node<E>(data);

        temp.next = head;
        head = temp;
    }

    private Node<E> head;
}

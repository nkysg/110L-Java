import java.util.Stack;

public class LinkedList<T extends  Comparable<T>> implements Cloneable, Comparable<LinkedList<T>> {
    public int get_size() {
        return size;
    }

    public boolean is_empty() {
        return size == 0;
    }

    public void push_front(T value) {
        Node<T> node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    public T pop_front() {
        if (size == 0) {
            return null;
        }
        T value = head.value;
        Node<T> node = head;
        node = null;
        head = head.next;
        size--;
        return value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            sb.append(node.toString());
            node = node.next;
        }
        return sb.toString();
    }

    @Override
    public Object clone() {
        Stack<T> stk = new Stack<>();
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            stk.push(node.value);
            node = node.next;
        }

        LinkedList<T> list = new LinkedList<>();
        while (!stk.empty()) {
            T ele = stk.pop();
            list.push_front(ele);
        }
        return list;
    }

    @Override
    public int compareTo(LinkedList<T> o) {
        int len = Math.min(size, o.size);
        Node<T> l = head;
        Node<T> r = o.head;
        for (int i = 0; i < len; i++) {
            if (l.value.compareTo(r.value) == 0) {
                continue;
            }
            return l.value.compareTo(r.value)  > 0 ? 1 : -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }

        LinkedList<T> rhs = (LinkedList<T>) o;
        if (rhs.get_size() != get_size()) {
            return false;
        }
        Node<T> l = head;
        Node<T> r  = rhs.head;
        for (int i= 0; i < size; ++i) {
            if (l.value != r.value) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;
    }

    private Node<T> head;
    private int size;



    private static class Node<T> {
        public Node(T value) {
            this.value = value;
            next = null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.append(",");
            return sb.toString();
        }
        private T value;
        private Node<T> next;
    }
}

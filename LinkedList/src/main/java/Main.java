

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.push_front(new Integer(i));
        }
        System.out.println("list is " + list);

        LinkedList<Integer> r = (LinkedList<Integer>) list.clone();
        System.out.println("list2 is " + r);

        System.out.println("equal " + r.equals(list));
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 12, 18, 11, 5, 20};
        List list = new ArrayList<>(Arrays.asList(a));

        int num_threads = Runtime.getRuntime().availableProcessors();

        Parallel_map map = new Parallel_map<Integer, Long>();

        long start = System.currentTimeMillis();

        List newList = map.parallel(list, num_threads,new Square());

        for (int i = 0; i < newList.size(); i++) {
            System.out.print(" " + newList.get(i));
        }

        System.out.println("\ncost " + ( System.currentTimeMillis() - start));
    }
}

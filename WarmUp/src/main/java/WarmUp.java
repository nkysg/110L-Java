import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WarmUp {
    static List<Integer> add(List<Integer> v, int n) {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(" " + v.get(i));
        }
        System.out.println("");
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) + n);
        }

        for (int i = 0; i < v.size(); i++) {
            System.out.print(" " + v.get(i));
        }
        System.out.println("");
        return v;
    }

    static void  add_inplace(ArrayList<Integer> v, int n) {
        for (int i = 0; i < v.size(); i++) {
            v.set(i, v.get(i) + n);
        }
    }

    static List<Integer> dedup(List<Integer> v) {
        List<Integer> v1 = new ArrayList<>();
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < v.size(); ++i) {
            if (hash.contains(v.get(i))) {
                continue;
            } else {
               // System.out.println("this ", (Integer)(v.get(i)).intValue());
                System.out.print("this " + v.get(i));
                hash.add(v.get(i));
                v1.add(v.get(i));
            }
        }
        v =  v1;
    }

   public  static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 4};
        List v = new ArrayList<>(Arrays.asList(arr));


        v = dedup(v);

       for (int i = 0; i < v.size(); i++) {
           System.out.print(" " + v.get(i));
       }
       System.out.println("");

    }

}

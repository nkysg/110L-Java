import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.*;

public class farm {
    private static boolean isPrime(int num) {
        if (num == 1) return false;
        if (num == 2) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void factor_number(int num) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb.append(" = ");
        if (num == 1 || isPrime(num)) {
            System.out.println("is prime " + num);
            sb.append(num);
            sb.append(" time ");
            sb.append(System.currentTimeMillis() - start);
            System.out.println(sb);
            return;
        }
        List<Integer> factors = new ArrayList<>();
        int curr_num = num;
        for (int factor = 2; factor <= curr_num; factor++) {
            while (curr_num % factor == 0) {
                factors.add(factor);
                curr_num /= factor;
            }
        }
        Collections.sort(factors);

        for (int i = 0; i < factors.size(); i++) {
            sb.append(factors.get(i));
            sb.append("*");
        }
        sb.append(" time ");
        sb.append(System.currentTimeMillis() - start);
        System.out.println(sb);
    }

    private static BlockingQueue<Integer> get_input_numbers(String[] args) {
        BlockingQueue<Integer> numbs = new ArrayBlockingQueue<Integer>(args.length);
        for (int i = 0; i < args.length; i++) {
            numbs.add(Integer.parseInt(args[i]));
        }
        return numbs;
    }

    private static List<Integer> get_input_numbers2(String[] args) {
        List<Integer> numbs = new ArrayList<>(args.length);
        for (int i = 0; i < args.length; i++) {
            numbs.add(Integer.parseInt(args[i]));
        }
        return numbs;
    }

    public static void main(String[] args) {

        int numbs_thread = Runtime.getRuntime().availableProcessors();

        // todo use threadpool
        List<Integer> numbs = get_input_numbers2(args);

        long start = System.currentTimeMillis();
/*
        BlockingQueue<Integer> numbs =  get_input_numbers(args);
        for (int i = 0; i < numbs_thread; ++i) {
           new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            int num = numbs.take();
                            factor_number(num);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println("cost "  + cost); */
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(numbs_thread);
        for (int i = 0; i < numbs.size(); i++) {
            pool.execute(new Handler(numbs.get(i)));
        }
    }

    private static class Handler implements Runnable {
        public Handler(int value) {
            this.value = value;
        }

        public void run() {
          factor_number(value);
        }

        private int value;
    }
}

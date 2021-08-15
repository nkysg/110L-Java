import java.util.*;
import java.util.concurrent.*;

public class Parallel_map<T extends Number , U extends Number> {
    public Parallel_map() {

    }

    public  List<U> parallel(List<T> list, int num_threads,  Calc<T, U> calc)  {

        Object[] arr = new Object[list.size()];
        List newList = new ArrayList<>(Arrays.asList(arr));

        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(num_threads);

        Collection<Future<?>> futures = new LinkedList<Future<?>>();

        for (int i = 0; i < list.size(); i++) {
            futures.add(pool.submit(new Handler<T, U>(i, list.get(i), newList, calc)));
        }

        for (Future<?> future:futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
        return newList;
    }

    private static class Handler<T, U> implements Runnable {
        Handler(int index, T value, List<U> result, Calc<T,U> calc) {
            this.index = index;
            this.value = value;
            this.result = result;
            this.calc = calc;
        }
        @Override
        public void run() {
            result.set(index, calc.compute(value));
        }

        private int index;
        private T value;
        private List<U> result;
        private Calc<T, U> calc;
    }
}
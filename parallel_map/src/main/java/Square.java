

public class Square implements Calc<Integer,Long>{

    @Override
    public Long compute(Integer value) {
       int v = value;
       Long result = Long.valueOf(v * v);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}

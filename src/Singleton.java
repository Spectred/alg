import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == instance) {
            synchronized (Singleton.class) {
                if (null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(int i = 0; i < 100; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName() + ":" + Singleton.getInstance().toString()));
        }

        executorService.shutdown();
    }
}
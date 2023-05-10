
public class MainDueThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DueThread("*"));
        Thread t2 = new Thread(new DueThread("#"));
        t1.start();
        t2.start();
    }
}

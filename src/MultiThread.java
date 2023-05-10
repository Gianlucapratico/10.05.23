
import java.util.Random;

public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        int ARRAY_SIZE = 3000;
        int PARTITION_SIZE = 1000;
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        // genera l'array di 3000 valori numerici casuali
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        // crea 3 thread e assegna ad ogni thread una partizione dell'array
        SumThread[] threads = new SumThread[3];
        for (int i = 0; i < 3; i++) {
            int start = i * PARTITION_SIZE;
            int end = start + PARTITION_SIZE;
            threads[i] = new SumThread(array, start, end);
            threads[i].start();
        }

        // sincronizza il thread main sulla terminazione dei thread figli
        for (int i = 0; i < 3; i++) {
            threads[i].join();
        }

        // somma i risultati parziali e li stampa su console
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += threads[i].getResult();
        }
        System.out.println("La somma totale è: " + sum);
    }

    static class SumThread extends Thread {
        private int[] array;
        private int start;
        private int end;
        private int result;

        public SumThread(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        public int getResult() {
            return result;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                result += array[i];
            }
        }
    }
}

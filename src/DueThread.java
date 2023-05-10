
class DueThread implements Runnable {
    private String symbol;
    
    public DueThread(String symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(symbol);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class EvenThread extends Thread {
    @Override
    public void run() {
        System.out.println("Even numbers:");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(100); // Small delay for better output readability
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println();
    }
}

class OddThread extends Thread {
    @Override
    public void run() {
        System.out.println("Odd numbers:");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(100); // Small delay for better output readability
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println();
    }
}

public class Lab6a {
    public static void main(String[] args) {
        Thread evenThread = new EvenThread();
        Thread oddThread = new OddThread();
        try {
            evenThread.start();
            evenThread.join();  // Wait for even thread to finish

            oddThread.start();
            oddThread.join();
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Finished printing even and odd numbers.");
    }
}

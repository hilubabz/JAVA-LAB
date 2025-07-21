class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // synchronized method to prevent race conditions
    public synchronized void withdraw(int amount, String threadName) {
        System.out.println(threadName + " tries to withdraw: " + amount);
        if (amount <= balance) {
            System.out.println(threadName + " is processing withdrawal...");
            // Simulate processing time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            balance -= amount;
            System.out.println(threadName + " withdrew " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println(threadName + " cannot withdraw " + amount + ". Insufficient balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    private int amount;

    public WithdrawThread(BankAccount account, int amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount, getName());
    }
}

public class Lab5 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        // Create multiple threads that withdraw money
        Thread t1 = new WithdrawThread(account, 700, "Thread-1");
        Thread t2 = new WithdrawThread(account, 500, "Thread-2");
        Thread t3 = new WithdrawThread(account, 300, "Thread-3");

        // Start the threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}

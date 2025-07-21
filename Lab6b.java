class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // synchronized deposit method
    public synchronized void deposit(int amount, String threadName) {
        System.out.println(threadName + " is depositing: " + amount);
        balance += amount;
        System.out.println(threadName + " completed deposit. New balance: " + balance);
        notifyAll(); // notify waiting threads in case they are waiting for funds
    }

    // synchronized withdraw method
    public synchronized void withdraw(int amount, String threadName) {
        System.out.println(threadName + " attempts to withdraw: " + amount);
        while (balance < amount) {
            System.out.println(threadName + " waiting to withdraw " + amount + ". Insufficient balance: " + balance);
            try {
                wait(); // wait until notified that balance may have changed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        balance -= amount;
        System.out.println(threadName + " completed withdrawal of " + amount + ". Remaining balance: " + balance);
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private int amount;

    public DepositThread(BankAccount account, int amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount, getName());
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

public class Lab6b {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);

        Thread t1 = new WithdrawThread(account, 700, "WithdrawThread-1");
        Thread t2 = new DepositThread(account, 300, "DepositThread-1");
        Thread t3 = new WithdrawThread(account, 400, "WithdrawThread-2");
        Thread t4 = new DepositThread(account, 500, "DepositThread-2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}

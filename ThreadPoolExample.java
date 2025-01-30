import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amt) {
        balance += amt;
        System.out.println("Deposited: " + amt + " | Total Balance: " + balance);
    }

    public synchronized boolean withdraw(int withdrawalAmt, String holderName) {
        if (withdrawalAmt <= balance) {
            balance -= withdrawalAmt;
            System.out.println(holderName + " withdrew: " + withdrawalAmt + " | Remaining Balance: " + balance);
            return true;
        } else {
            System.out.println(holderName + " attempted to withdraw: " + withdrawalAmt + " | Insufficient funds! Balance: " + balance);
            return false;
        }
    }
}

class WithdrawTask implements Runnable {
    private BankAccount account;
    private String holderName;
    private int withdrawalAmt;

    public WithdrawTask(BankAccount acc, String name, int amt) {
        this.account = acc;
        this.holderName = name;
        this.withdrawalAmt = amt;
    }

    @Override
    public void run() {
        System.out.println(holderName + " attempting to withdraw: " + withdrawalAmt);
        account.withdraw(withdrawalAmt, holderName);
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);

        // Create a thread pool with a fixed number of worker threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit multiple withdrawal tasks dynamically instead of creating new threads manually
        executorService.submit(new WithdrawTask(account, "Alice", 400));
        executorService.submit(new WithdrawTask(account, "Bob", 300));
        executorService.submit(new WithdrawTask(account, "Alice", 200)); // Alice withdraws again
        executorService.submit(new WithdrawTask(account, "Charlie", 500)); // Another transaction
        executorService.submit(new WithdrawTask(account, "Jana", 1500)); // Another transaction

        // Shut down the executor service gracefully
        executorService.shutdown();
    }
}

/*

Improving Real-Time Bank Transactions with a Thread Pool
Instead of creating new thread objects multiple times, a real-world approach would be to use a thread pool (ExecutorService). This ensures:

Efficient thread management.
Avoids unnecessary thread creation overhead.
Enables continuous processing of multiple transactions dynamically.

 * How This Improves Real-Time Implementation
✅ 1. Efficient Thread Management
Uses a fixed pool of reusable threads instead of creating new thread objects.
Reduces overhead compared to creating new Thread instances.
✅ 2. Dynamically Handles Transactions
Instead of manually creating threads for every transaction, we submit tasks dynamically using executorService.submit().
This approach scales better for real-time banking applications.
✅ 3. Graceful Shutdown
executorService.shutdown() ensures all transactions are completed before stopping.
Prevents memory leaks from unmanaged threads.

Key Takeaways for an Interview
Instead of creating Thread objects manually, use ExecutorService for better performance.
Executors.newFixedThreadPool(n) ensures only n threads are active at a time, reducing system strain.
Real-time banking systems queue transactions rather than handling them in isolated threads.
🚀 This approach mirrors real-world banking transaction processing!
 * 
 * 
 */
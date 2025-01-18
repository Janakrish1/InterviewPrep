class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class Bank {
    private double balance;
    private int userId;

    public Bank(int userId) {
        this.userId = userId;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount <= balance) {
            balance -= amount;
        }
        else {
            double requiredAmt = amount - balance;
            throw new InsufficientFundsException(requiredAmt);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class ExceptionExample {
    
    public static void main(String args[]) {
        Bank user = new Bank(1);
        user.deposit(1000);
        System.out.println("User balance: " + user.getBalance());

        try {
            System.out.println("Withdrawing amount 700");
            user.withdraw(700);  

            System.out.println("User balance: " + user.getBalance());
            System.out.println("Withdrawing amount 850");
            user.withdraw(850);  
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, you are short of " + e.getAmount());
        } finally {
            System.out.println("Transaction Completed");
        }
    }
}

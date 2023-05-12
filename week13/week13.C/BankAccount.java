public class BankAccount {
    private int balance;
    public BankAccount(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    public synchronized void deposit(int amount) {
        synchronized (this) {
            balance += amount;
        }
    }
    public synchronized void withdraw(int amount) {
        synchronized (this) {
            balance -= amount;
        }
    }
}
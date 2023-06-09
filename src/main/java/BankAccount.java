public class BankAccount {
    private double balance;
    private double minimumBalance;
    private boolean isActive = true;
    private String holderName;

    public double getBalance() {
        return balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public BankAccount(double balance, double minimumBalance){
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }

    public double withdraw(double amount){
        if(balance - amount > minimumBalance){
            balance -= amount;
            return amount;
        } else{
            throw new RuntimeException();
        }
    }

    public double deposit(double amount){
        /*
        try {
            Thread.sleep(5);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        */

        return balance += amount;

    }

    public boolean isActive() {
        return isActive;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holdername) {
        this.holderName = holdername;
    }
}

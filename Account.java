public class Account {
    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean checkDeposit(double x){
        return (x > 0);
    }
    public void depositMoney(double x){
        if (checkDeposit(x)){
            balance += x;
            System.out.println("DEPOSIT SUCCESSFUL!");
        } else {
            System.out.println("Your balance is less than " + x + ". Transaction failed." );
        }
    }

    public boolean checkWithdraw(double x){
        return (x <= balance && x > 0);
    }
    public void withdrawMoney(double x){
        if (checkWithdraw(x)){
            balance -= x;
            System.out.println("WITHDRAWAL SUCCESSFUL!");
        } else {
            System.out.println("Not enough funds to withdraw: " + x + ". Transaction failed.");
        }
    }



}

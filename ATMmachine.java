import java.util.Scanner;


public class ATMmachine {
    public static void main(String[] args) { // driver function
        new ATMmachine().run();
    }

    private final Scanner sc = new Scanner(System.in);

    static Bank myBank = new Bank("BCA");

    private int menuGeneral() {
        do {
            System.out.println("Welcome To " + myBank.getBankName() + " \nplease insert: ");
            System.out.println("1. Register");
            System.out.println("2. Delete account");
            System.out.println("3. Log in");
            System.out.println("4. Exit");
            int option = sc.nextInt();
            if (1 <= option && option <= 4) {
                return option;
            }
            System.out.println("please re-enter a correct input");
        } while (true);
    }

    public void run() {
        do {
            int option = menuGeneral();
            switch (option) {
                case 1:
                    Customer account = register();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    account = login();
                    if (account != null){
                        System.out.println("BALANCE: $" + displayBalance(account));
                        manageAccount(account);
                    }
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    private Customer register() {
        System.out.print("Insert first name: ");
        String firstName = sc.next();
        System.out.print("Insert last name: ");
        String lastName = sc.next();

        Customer customer = new Customer(firstName, lastName, new Account(0));
        myBank.addCustomer(customer);
        System.out.println("Account number: " + customer.getAccNo());
        return customer;
    }

    private void delete(){
        System.out.print("Insert account number: ");
        String accNo = sc.next();
        Customer found = search(accNo);

        if (found == null){
            System.out.println("ACCOUNT NOT FOUND");
        } else {
            myBank.delCustomer(found);
        }

    }

    private Customer search(String accNo){
        Customer found = myBank.getCustomer(accNo);
        return found;
    }

    private Customer login() {
        System.out.print("Insert account number: ");
        String accNo = sc.next();
        Customer found = search(accNo);

        if (found == null){
            System.out.println("ACCOUNT NOT FOUND");
            return null;
        }
        return found;
    }

    private double displayBalance(Customer customer){
        return customer.getAccount().getBalance();
    }

    private int menuManageAcc() {
        do {

            System.out.println("--- MANAGE ACCOUNT---\nPress: ");
            System.out.println("1. Info");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer between accounts");
            System.out.println("5. Return to main menu");
            int option = sc.nextInt();
            if (1 <= option && option <= 5) {
                return option;
            }
            System.out.println("please re-enter a correct input");
        } while (true);
    }

    private void manageAccount(Customer customer) {
        do {
            int option = menuManageAcc();
            switch (option) {
                case 1:
                    info(customer);
                    break;
                case 2:
                    deposit(customer);
                    break;
                case 3:
                    withdraw(customer);
                    break;
                case 4:
                    transfer(customer);
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void info(Customer customer){ // displays customer's info
        System.out.println("--- CUSTOMER DETAILS ---");
        System.out.println(customer.toString());
    }

    private void deposit(Customer customer){
        System.out.print("Insert amount to deposit: ");
        double amt = sc.nextDouble();
        customer.getAccount().depositMoney(amt);
    }

    private void withdraw(Customer customer){
        System.out.print("Insert amount to withdraw: ");
        double amt = sc.nextDouble();
        customer.getAccount().withdrawMoney(amt);
    }

    private void transfer(Customer customer){
        System.out.print("Insert amount to transfer: ");
        double amt = sc.nextDouble();
        System.out.print("Insert recipient account number: ");
        String accNoRec = sc.next();
        Customer recipient = search(accNoRec);

        if (recipient == null){
            System.out.println("ACCOUNT NOT FOUND");
        } else {
            if (customer.getAccount().checkWithdraw(amt)){
                recipient.getAccount().depositMoney(amt);
                System.out.println("TRANSFER SUCCESSFUL!");
            }
        }
    }

}

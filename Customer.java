import java.util.UUID;

public class Customer {
    private String firstName, lastName, accNo;
    private Account account;

    public Customer(String f, String l, Account balance){
        this.firstName = f;
        this.lastName = l;
        this.accNo = accNoGenerator();
        this.account = balance;
    }


    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getAccNo(){
        return this.accNo;
    }

    public Account getAccount(){
        return account;
    }
  
    public void setAccount(Account updateAcc){
        this.account = updateAcc;
    }

    public static String accNoGenerator(){
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "").substring(0, 7);
    }


    @Override
    public String toString(){
        return "Name: " + getFirstName() + "\n" +
                "Last name: " +getLastName() +"\n" +
                "Balance: $ " + account.getBalance() + "\n" +
                "Account number: " + getAccNo();
    }

}

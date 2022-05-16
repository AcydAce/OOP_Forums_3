import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private int numberOfCustomers;
    private String bankName;
    public Bank(String bName){
        this.bankName = bName;
    }

    public void addCustomer(Customer newCust){
        customers.add(newCust);
    }

    public void delCustomer(Customer delCust){
        customers.remove(delCust);
    }

    public int getNumOfCustomers(){
        this.numberOfCustomers = customers.size();
        return numberOfCustomers;
    }

    public Customer getCustomer(String accNo){
        for (Customer customer: customers){
            if (customer.getAccNo().equals(accNo)){
                return customer;
            }
        };
        return null;
    }

    public String getBankName(){
        return this.bankName;
    }
}

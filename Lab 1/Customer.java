public class Customer {

    private String customerName;

    public Customer(String customerName) {

        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void showDetails() {

        System.out.printf("Customer details %s\n", customerName);
    }
}
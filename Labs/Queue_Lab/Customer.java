public class Customer {
    private int arrivalTime, transactionTime, customerNumber;

    public Customer(int arrivalTime, int transactionTime, int customerNumber) {
        this.arrivalTime = arrivalTime;
        this.transactionTime = transactionTime;
        this.customerNumber = customerNumber;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getTransactionTime() {
        return this.transactionTime;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }
}

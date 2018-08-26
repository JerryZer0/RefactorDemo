package rentalstore;

import java.util.Enumeration;

public class TextStatement extends Statement{

    private Customer customer;

    public TextStatement(Customer customer) {
        super(customer);
        this.customer = customer;
    }

    public String getHeader() {
        return "Rentals for " + customer.getName() + "\n";
    }

    public String getBody(double thisAmount, Rental each) {
        return each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
    }

    public String getFooter(double totalAmount, int frequentRenterPoints) {
        return "You owe "
                + String.valueOf(totalAmount)
                + "\n"
                + "On this rental you earned "
                + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
    }
}

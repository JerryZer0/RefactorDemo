package rentalstore;

import java.util.Enumeration;

public class HtmlStatement extends Statement {

    private Customer customer;

    public HtmlStatement(Customer customer) {
        super(customer);
        this.customer = customer;
    }

    public String getHeader() {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }

    public String getBody(double thisAmount, Rental each) {
        return each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "<BR>\n";
    }

    public String getFooter(double totalAmount, int frequentRenterPoints) {
        return "<P>You owe<EM>"
                + String.valueOf(totalAmount)
                + "</EM><P>\n"
                + "On this rental you earned <EM>"
                + String.valueOf(frequentRenterPoints)
                + "</EM> frequent renter points<P>";
    }
}

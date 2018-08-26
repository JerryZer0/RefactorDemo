package rentalstore;

import java.util.Enumeration;

public abstract class Statement {

    private Customer customer;

    public Statement(Customer customer) {
        this.customer = customer;
    }

    String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = customer.getRentals().elements();
        String result = getHeader();

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();
            thisAmount += each.getAmount();
            frequentRenterPoints = each.updateFrequentRenterPointers(frequentRenterPoints);
            result += getBody(thisAmount, each);
            totalAmount += thisAmount;
        }

        result += getFooter(totalAmount, frequentRenterPoints);
        return result;
    }

    public abstract String getHeader();
    public abstract String getBody(double thisAmount, Rental each);
    public abstract String getFooter(double totalAmount, int frequentRenterPoints);

}

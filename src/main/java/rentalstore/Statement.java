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
            //Movie movie = each.getMovie();
            thisAmount += each.getAmount();
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if ((each.getMovie().getType().getClass() == NewRelease.class) && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }

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

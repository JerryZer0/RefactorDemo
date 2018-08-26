package rentalstore;

import java.util.Enumeration;

public class HtmlStatement {

    private Customer customer;

    public HtmlStatement(Customer customer) {
        this.customer = customer;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = customer.getRentals().elements();

        String result = getHeader();

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDayRented() > 2) {
                        thisAmount += (each.getDayRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDayRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDayRented() > 3) {
                        thisAmount += (each.getDayRented() - 3) * 1.5;
                    }
                    break;
            }

            //add frequent renter points
            frequentRenterPoints++;
            //add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
                frequentRenterPoints++;
            }

            //show figures for this rental
            result += getBody(thisAmount, each);
            totalAmount += thisAmount;
        }

        result += getFooter(totalAmount, frequentRenterPoints);
        return result;
    }

    private String getBody(double thisAmount, Rental each) {
        return each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "<BR>\n";
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        return "<P>You owe<EM>"
                + String.valueOf(totalAmount)
                + "</EM><P>\n"
                + "On this rental you earned <EM>"
                + String.valueOf(frequentRenterPoints)
                + "</EM> frequent renter points<P>";
    }

    private String getHeader() {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}

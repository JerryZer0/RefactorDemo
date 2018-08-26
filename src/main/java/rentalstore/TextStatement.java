package rentalstore;

import java.util.Enumeration;

public class TextStatement {

    private Customer customer;

    public TextStatement(Customer customer) {
        this.customer = customer;
    }

    String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = customer.getRentals().elements();
        String result = "Rentals for " + customer.getName() + "\n";
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
            result += each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        //add footer lines
        result += "You owe " + String.valueOf(totalAmount) + "\n";
        result += "On this rental you earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}

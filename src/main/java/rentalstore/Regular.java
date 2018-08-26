package rentalstore;

public class Regular extends MovieType{
    public double getAmount(Rental rental) {
        double thisAmount = 2;
        if (rental.getDayRented() > 2) {
            thisAmount += (rental.getDayRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}

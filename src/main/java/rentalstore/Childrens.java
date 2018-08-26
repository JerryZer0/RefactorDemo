package rentalstore;

public class Childrens extends MovieType{
    public double getAmount(Rental rental) {
        double thisAmount = 1.5;
        if (rental.getDayRented() > 3) {
            thisAmount += (rental.getDayRented() - 3) * 1.5;
        }
        return thisAmount;
    }
}

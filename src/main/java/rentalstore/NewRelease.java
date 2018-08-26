package rentalstore;

public class NewRelease extends MovieType{
    public double getAmount(Rental rental) {
        double thisAmount = rental.getDayRented() * 3;
        return  thisAmount;
    }
}

package rentalstore;

public class NewRelease{
    public double getAmount(Rental each) {
        double thisAmount = each.getDayRented() * 3;
        return  thisAmount;
    }
}

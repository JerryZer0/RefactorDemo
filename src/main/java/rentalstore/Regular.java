package rentalstore;

public class Regular{
    public double getAmount(Rental each) {
        double thisAmount = 2;
        if (each.getDayRented() > 2) {
            thisAmount += (each.getDayRented() - 2) * 1.5;
        }
        return thisAmount;
    }
}

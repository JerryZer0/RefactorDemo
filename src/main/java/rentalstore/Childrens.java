package rentalstore;

public class Childrens{
    public double getAmount(Rental each) {
        double thisAmount = 1.5;
        if (each.getDayRented() > 3) {
            thisAmount += (each.getDayRented() - 3) * 1.5;
        }
        return thisAmount;
    }
}

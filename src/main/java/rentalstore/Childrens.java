package rentalstore;

public class Childrens extends MovieType{
    public double getAmount(int dayRented) {
        double thisAmount = 1.5;
        if (dayRented > 3) {
            thisAmount += (dayRented - 3) * 1.5;
        }
        return thisAmount;
    }
}

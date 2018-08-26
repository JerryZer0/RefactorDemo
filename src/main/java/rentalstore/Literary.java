package rentalstore;

public class Literary extends MovieType {

    public double getAmount(int dayRented) {
        double thisAmount = dayRented * 6;
        return  thisAmount;
    }

}

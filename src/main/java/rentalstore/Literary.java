package rentalstore;

public class Literary extends MovieType {

    public double getAmount(int dayRented) {
        double thisAmount = dayRented * 6;
        return  thisAmount;
    }

    public double updateFrequentRenterPointers(double frequentRenterPoints, int dayRented){
        return frequentRenterPoints+1.5;
    }
}

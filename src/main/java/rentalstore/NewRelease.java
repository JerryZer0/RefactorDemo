package rentalstore;

public class NewRelease extends MovieType{
    public double getAmount(int dayRented) {
        double thisAmount = dayRented * 3;
        return  thisAmount;
    }

    public int updateFrequentRenterPointers(int frequentRenterPoints, int dayRented){
        if (dayRented > 1) {
            frequentRenterPoints++;
        }
        return ++frequentRenterPoints;
    }
}

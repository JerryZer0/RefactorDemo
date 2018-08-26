package rentalstore;

public abstract class MovieType {
    public abstract double getAmount(int dayRented);

    public double updateFrequentRenterPointers(double frequentRenterPoints, int dayRented){
        return ++frequentRenterPoints;
    }
}

package rentalstore;

public abstract class MovieType {
    public abstract double getAmount(int dayRented);

    public int updateFrequentRenterPointers(int frequentRenterPoints, int dayRented){
        return ++frequentRenterPoints;
    }
}

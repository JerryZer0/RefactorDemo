package rentalstore;

public abstract class MovieType {
    public abstract double getAmount(int dayRented);

    public int updateFrequentRenterPointers(int frequentRenterPoints, int dayRented){
        frequentRenterPoints++;
        if (this.getClass() == NewRelease.class && dayRented > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }
}

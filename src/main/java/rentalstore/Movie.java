package rentalstore;

public class Movie {

    private String title;
    private MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getType() {
        return type;
    }

    public double getAmount(int dayRented) {
        return type.getAmount(dayRented);
    }

    public double updateFrequentRenterPointers(double frequentRenterPoints, int dayRented) {
        return type.updateFrequentRenterPointers(frequentRenterPoints,dayRented);
    }
}

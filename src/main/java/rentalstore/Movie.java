package rentalstore;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    private MovieType type;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }

    public double getAmount(Rental rental) {
        return type.getAmount(rental);
    }

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getType() {
        return type;
    }
}

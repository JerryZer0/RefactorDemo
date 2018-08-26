package rentalstore;

public class MovieType {
    public double getAmount(double thisAmount, Rental each)
    {
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += new Regular().getAmount(each);
                break;
            case Movie.NEW_RELEASE:
                thisAmount += new NewRelease().getAmount(each);
                break;
            case Movie.CHILDRENS:
                thisAmount += new Childrens().getAmount(each);
                break;
        }
        return thisAmount;
    }

}

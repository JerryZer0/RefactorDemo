package rentalstore;

public abstract class MovieType {
    public abstract double getAmount(Rental each);
    /* {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                return new Regular().getAmount(each);
            case Movie.NEW_RELEASE:
                return new NewRelease().getAmount(each);
            case Movie.CHILDRENS:
                return new Childrens().getAmount(each);
        }
        return thisAmount;
    }*/

}

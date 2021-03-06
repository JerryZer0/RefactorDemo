package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer = new Customer("Jerry");

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_has_no_films() {

        String receipt = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "<P>You owe<EM>0.0</EM><P>\n"
                + "On this rental you earned <EM>0.0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_rent_one_film_Roman_Holiday_for_one_day() {
        Movie movie = new Movie("Roman Holiday", new Regular());
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);

        String receipt = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "Roman Holiday\t2.0<BR>\n"
                + "<P>You owe<EM>2.0</EM><P>\n"
                + "On this rental you earned <EM>1.0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_rent_one_film_Roman_Holiday_for_three_days() {
        Movie movie = new Movie("Roman Holiday", new Regular());
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);

        String receipt = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "Roman Holiday\t3.5<BR>\n"
                + "<P>You owe<EM>3.5</EM><P>\n"
                + "On this rental you earned <EM>1.0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_rent_one_new_release_film_for_one_day() {
        Movie movie = new Movie("Roman Holiday", new NewRelease());
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);

        String receipt = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "Roman Holiday\t3.0<BR>\n"
                + "<P>You owe<EM>3.0</EM><P>\n"
                + "On this rental you earned <EM>1.0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_rent_one_child_film_for_one_day() {
        Movie movie = new Movie("Roman Holiday", new Childrens());
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);

        String receipt = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "Roman Holiday\t1.5<BR>\n"
                + "<P>You owe<EM>1.5</EM><P>\n"
                + "On this rental you earned <EM>1.0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_rent_two_films_for_one_day() {
        Movie movie1 = new Movie("Roman Holiday", new NewRelease());
        Movie movie2 = new Movie("Titanic", new NewRelease());
        Rental rental1 = new Rental(movie1, 1);
        Rental rental2 = new Rental(movie2, 1);
        customer.addRental(rental1);
        customer.addRental(rental2);

        String receipt = customer.htmlStatement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "Roman Holiday\t3.0<BR>\n"
                + "Titanic\t3.0<BR>\n"
                + "<P>You owe<EM>6.0</EM><P>\n"
                + "On this rental you earned <EM>2.0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_TEXT_result_as_name_is_Jerry_and_rent_two_films_for_one_day() {
        Movie movie1 = new Movie("Roman Holiday", new NewRelease());
        Movie movie2 = new Movie("Titanic", new NewRelease());
        Rental rental1 = new Rental(movie1, 1);
        Rental rental2 = new Rental(movie2, 1);
        customer.addRental(rental1);
        customer.addRental(rental2);

        String receipt = customer.textStatement();

        assertEquals("Rentals for Jerry\n"
                + "Roman Holiday\t3.0\n"
                + "Titanic\t3.0\n"
                + "You owe 6.0\n"
                + "On this rental you earned 2.0 frequent renter points", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_rent_literary_film_for_one_day() {
        Movie movie = new Movie("Roman Holiday", new Literary());
        Rental rental1 = new Rental(movie, 1);
        customer.addRental(rental1);

        String receipt = customer.textStatement();

        assertEquals("Rentals for Jerry\n"
                + "Roman Holiday\t6.0\n"
                + "You owe 6.0\n"
                + "On this rental you earned 1.5 frequent renter points", receipt);
    }
}
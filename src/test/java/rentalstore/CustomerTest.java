package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer = new Customer("Jerry");
    Movie movie1 = new Movie("Roman Holiday", 1);
    Movie movie2 = new Movie("Titanic", 1);
    Rental rental1 = new Rental(movie1, 1);
    Rental rental2 = new Rental(movie2, 1);


    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_has_no_films() {

        String receipt = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "<P>You owe<EM>0.0</EM><P>\n"
                + "On this rental you earned <EM>0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_has_one_film_Roman_Holiday() {

        customer.addRental(rental1);
        String receipt = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "\tRoman Holiday\t3.0<BR>\n"
                + "<P>You owe<EM>3.0</EM><P>\n"
                + "On this rental you earned <EM>1</EM> frequent renter points<P>", receipt);
    }
}
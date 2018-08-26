package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer = new Customer("Jerry");

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_has_no_films() {

        String receipt = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "<P>You owe<EM>0.0</EM><P>\n"
                + "On this rental you earned <EM>0</EM> frequent renter points<P>", receipt);
    }

    @Test
    public void should_return_the_HTML_result_as_name_is_Jerry_and_rent_one_film_Roman_Holiday_for_one_day() {
        Movie movie1 = new Movie("Roman Holiday", 0);
        Rental rental1 = new Rental(movie1, 1);
        customer.addRental(rental1);
        String receipt = customer.statement();

        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n"
                + "Roman Holiday\t2.0<BR>\n"
                + "<P>You owe<EM>2.0</EM><P>\n"
                + "On this rental you earned <EM>1</EM> frequent renter points<P>", receipt);
    }

}
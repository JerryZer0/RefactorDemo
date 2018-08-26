package rentalstore;

import java.util.Vector;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<Rental>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public Vector<Rental> getRentals() {
        return rentals;
    }

    public String textStatement(){
        return new TextStatement(this).statement();
    }

    public String htmlStatement(){
        return new HtmlStatement(this).statement();
    }

}

package models;

public class Payment {

    private String name;
    private Address address;



    public Payment() {
        this.name = "Vintage Bags";
        this.address = new Address();
        address.setStreetAddress("350 Du Languedoc");
        address.setPostalCode("J4B 0A4");
        address.setCountry("Canada");
        address.setState("QC");
        address.setCity("Bourcherville");
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Adress: " + address + "\n";
    }
}

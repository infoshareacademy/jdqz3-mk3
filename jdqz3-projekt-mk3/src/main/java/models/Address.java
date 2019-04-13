package models;

import static generators.AddressGenerator.*;

public class Address {
    private String streetAddress;
    private String city;
    private String country;
    private String state;
    private String postalCode;

    public Address(){
        setStreetAddress(streetGenerator());
        setCity(cityGenerator());
        setCountry(randomCountry());
        setState(stateGenerator());
        setPostalCode(postalCodeGenerator());
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return streetAddress + " " +
                city + " " +
                country + " " +
                state + " " +
                postalCode;
    }
}
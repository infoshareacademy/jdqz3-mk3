package models;

import static generators.AddressGenerator.*;

public class Adress {
    private String streetAdres;
    private String city;
    private String country;
    private String state;
    private String postalCode;

    public Adress(){
        setStreetAdres(streetGenerator());
        setCity(cityGenerator());
        setCountry(randomCountry());
        setState(stateGenerator());
        setPostalCode(postalCodeGenerator());
    }


    public String getStreetAdres() {
        return streetAdres;
    }

    public void setStreetAdres(String streetAdres) {
        this.streetAdres = streetAdres;
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
        return "Adress{" +
                "streetAdres='" + streetAdres + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Adress adres1 = new Adress();
        System.out.println(adres1);
    }
}

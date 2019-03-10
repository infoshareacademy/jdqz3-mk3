package models;

import generators.UserGenerator;

public class User {
    private String firstName;
    private String lastName;
    private String billingCompany;
    private Address address;
    private String email;
    private String phoneNumber;
    private Address shippingAddress;
    private String orderNotes;
    private String password;

    public User() {
        this.firstName = UserGenerator.firstNameGenerator();
        this.lastName = UserGenerator.lastNameGenerator();
        this.billingCompany = UserGenerator.billingCompanyGenerator();
        this.address = new Address();
        this.email = UserGenerator.emailGenerator();
        this.phoneNumber = UserGenerator.phoneNumberGenerator();
        this.shippingAddress = this.address;
        this.orderNotes = UserGenerator.orderNotesGenerator();
        this.password = UserGenerator.passwordGenerator();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBillingCompany() {
        return billingCompany;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +"\n" +
                "Last Name: " + lastName + "\n" +
                "Billing company: " + billingCompany + "\n" +
                "Address: " + address + "\n" +
                "Email: " + email + "\n" +
                "Phone number: " + phoneNumber + "\n" +
                "Shipping address: " + shippingAddress + "\n" +
                "Order notes: " + orderNotes + "\n" +
                "Password: " + password + "\n";
    }
}
package models;

public class Address {
	String postalCode;
	String street;
	Integer streetNumber;
	String complement;

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getComplement() {
        return complement;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
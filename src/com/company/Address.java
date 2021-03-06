package com.company;

public class Address {
    private int house;
    private int flat;
    private String street;

    Address(String street, Integer house, Integer flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }
    public Integer getHouse() {
        return house;
    }
    public Integer getFlat() {
        return flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Address))
            return false;
        Address other = (Address)obj;
        return other.street.equals(street) && other.house == house && other.flat == flat;
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (street != null) {
            result = 31 * result + street.hashCode();
        }
        result = (31 * result) + Integer.hashCode(house);
        result = (31 * result) + Integer.hashCode(flat);
        return result;
    }
}

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AddressBook {

    private HashMap<Person,Address> addressBook = new HashMap<>();

    Map<Person,Address> getData(){
        return addressBook;
    }

    void Add(Person person, Address address){
        addressBook.put(person,address);
    }

    void Remove(Person person){
        addressBook.remove(person);
    }

    void Change(Person person, Address address){
        if (addressBook.containsKey(person)) {
            addressBook.remove(person);
            addressBook.put(person,address);
        }
    }

    Address Find(Person person){
        return addressBook.getOrDefault(person, null);
    }

    List<Person> FindAllByStreet(String street){
        ArrayList<Person> result = new ArrayList<>();

        for ( Person key : addressBook.keySet()){
            Address address = addressBook.get(key);
            if (address.getStreet().equals(street))
                result.add(key);

        }
        return result;
    }

    List<Person> FindAllByHouse(int house){
        ArrayList<Person> result = new ArrayList<>();

        for ( Person key : addressBook.keySet()){
            Address address = addressBook.get(key);
            if (address.getHouse() == house)
                result.add(key);

        }
        return result;
    }
}

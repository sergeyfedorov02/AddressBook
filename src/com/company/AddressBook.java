package com.company;

import java.util.*;

public class AddressBook {
    HashMap<Person,Address> addressBook = new HashMap<>();

    private void validatePerson(Person person) {
        Objects.requireNonNull(person);
        if (person.getSurname() == null || person.getName() == null)
            throw new NullPointerException();
    }

    private void validateAddress(Address address) {
        Objects.requireNonNull(address);
        if (address.getStreet() == null || address.getHouse() == null || address.getFlat() == null)
            throw new NullPointerException();
    }

    /**
     * Реализовать добавление человека и его адреса в addressBook
     * Бросить исключение NullPointerException, если какое-то из полей Address или Person == null,
     * Если добавление прошло успешно, то вывести True, иначе - False
     */
    public boolean add(Person person, Address address){
        validatePerson(person);
        validateAddress(address);

        if (addressBook.containsKey(person))
            return false;

        addressBook.put(person,address);
        return true;
    }

    /**
     * Реализовать удаление человека из Адресной книги(вывести True, если удаление прошло успешно, иначе - False)
     * Бросить исключение NullPointerException, если person == null
     */
    public boolean remove(Person person) {
        Objects.requireNonNull(person);
        return addressBook.remove(person) != null;
    }

    /**
     * Реализовать изменение адреса человека(вывести True, если операция прошла успешно, иначе - False)
     * Если попытаемся изменить адрес человека которого нет в Адресной книге,
     или любая из позиций адреса отсутсвует, на который мы меняем,
     то бросить исключение throw NullPointerException
     */
    public boolean change(Person person, Address address){
        validatePerson(person);
        validateAddress(address);

        if (!addressBook.containsKey(person))
            return false;

        addressBook.put(person,address);
        return true;
    }

    /**
     * Реализовать поиск Адреса человека по его имени
     * Бросить исключение IllegalArgumentException,
     если попытаемся найти человека, которого нет в Адресной книге,
     */
    public Address find(Person person){
        return addressBook.get(person);
    }

    /**
     * Реализовать поиск всех людей, проживающих на заданной улице
     * Если таких людей не будет, то вывести пустой лист
     */
    public List<Person> findAllByStreet(String street){
        ArrayList<Person> result = new ArrayList<>();
        for ( Map.Entry<Person, Address> e: addressBook.entrySet()){
            if (e.getValue().getStreet().equals(street))
                result.add(e.getKey());
        }
        return result;
    }

    /**
     * Реализовать поиск всех людей, проживающих в заданном доме
     * Если таких людей не будет, то вывести пустой лист
     */
    public List<Person> findAllByHouse(int house){
        ArrayList<Person> result = new ArrayList<>();
        for ( Map.Entry<Person, Address> e: addressBook.entrySet()){
            if (e.getValue().getHouse() == house)
                result.add(e.getKey());
        }
        return result;
    }
}

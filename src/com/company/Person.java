package com.company;

public class Person {
    private String name;
    private String surname;

    Person(String surname, String name) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return surname + " " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person)obj;
        return other.name.equals(name) && other.surname.equals(surname);
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        if (surname != null) {
            result = (31 * result) + surname.hashCode();
        }
        return result;
    }
}

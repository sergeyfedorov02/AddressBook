package com.company;

public class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Person))
            return false;
        Person other = (Person)obj;
        return other.name.equals(name);
    }

    @Override
    public final int hashCode() {
        int result = 17;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        return result;
    }
}

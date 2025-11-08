package dev.lukaculjak20.HotelMgmtSys.entity;

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String email;



    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public abstract String getFullName();
    public abstract  String getRole();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}

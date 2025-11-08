package dev.lukaculjak20.HotelMgmtSys.entity;

/**
 * Describes a person
 *
 * @author LukaCuljak20
 * @version 1.2
 * @since 1.0
 */

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String email;



    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    /**
     * Combines first and last name into one string
     * @return First and last name in form of a singular string
     */
    public abstract String getFullName();
    /**
     * Gives person's role
     */
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

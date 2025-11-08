package dev.lukaculjak20.HotelMgmtSys.entity;

/**
 * Contains information about a guest
 *
 * @author LukaCuljak20
 * @version 1.2
 * @since 1.0
 */

public class Guest extends Person {
    private String phoneNumber;
    private String idNumber;


    private Guest(GuestBuilder builder){
        super(builder.name,builder.surname,builder.email);
        this.phoneNumber = builder.phoneNumber;
        this.idNumber = builder.idNumber;
    }


    public static GuestBuilder builder() {
        return new GuestBuilder();
    }

    /**
     * Makes additional input of a certain variable easier
     */
    public static class GuestBuilder{
        private String name;
        private String surname;
        private String email;
        private String phoneNumber;
        private String idNumber;

        public GuestBuilder firstName(String name) {
            this.name = name;
            return this;
        }
        public GuestBuilder lastName(String surname) {
            this.surname = surname;
            return this;
        }
        public GuestBuilder email(String email) {
            this.email = email;
            return this;
        }
        public GuestBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public GuestBuilder idNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }
        public GuestBuilder personalInfo(String firstName, String lastName, String email) {
            this.name = firstName;
            this.surname = lastName;
            this.email = email;
            return this;
        }
        public Guest build() {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalStateException("Please enter a valid name");
            }
            if (surname == null || surname.trim().isEmpty()) {
                throw new IllegalStateException("Please enter a valid surname");
            }

            return new Guest(this);
        }
    }

    /**
     * Getter for guest's phone number
     *
     * @return Guest's phone number
     */

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter fort guest's phone number
     *
     * @param phoneNumber Guest's phone number
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for guest's id number
     * @return Guest's ID number
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * Setter for guest's ID number
     * @param idNumber Guest's ID number
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Constructs Guest object
     *
     * @param firstName Guest's first name
     * @param lastName Guest's last name
     * @param email Guest's email
     * @param phoneNumber Guest's phone number
     * @param idNumber Guest's ID number
     */
    public Guest(String firstName,String lastName,String email, String phoneNumber, String idNumber) {
        super(firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
    }


    @Override
    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String getRole() {
        return "Guest";
    }
}

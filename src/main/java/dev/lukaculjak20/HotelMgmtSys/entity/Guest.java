package dev.lukaculjak20.HotelMgmtSys.entity;

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
        public GuestBuilder idNumber(String idNumber){
            this.idNumber = idNumber;
            return this;
        }
        //metoda za unos svih podataka klase person odjednom
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

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

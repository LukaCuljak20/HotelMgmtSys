package dev.lukaculjak20.HotelMgmtSys.entity;

public class Employee extends Person {

    private String employeeId;

    public Employee(String name, String surname, String email,String employeeId) {
        super(name, surname, email);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String getRole() {
        return "Employee";
    }
}

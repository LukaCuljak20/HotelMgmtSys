package dev.lukaculjak20.HotelMgmtSys.entity;

/**
 * Describes an employee
 *
 * Contains information about an employee and extends Person class
 *
 * @see dev.lukaculjak20.HotelMgmtSys.entity.Person
 * @author LukaCuljak20
 * @version 1.0
 * @since 1.2
 */

public class Employee extends Person {

    private String employeeId;

    public Employee(String name, String surname, String email,String employeeId) {
        super(name, surname, email);
        this.employeeId = employeeId;
    }

    /**
     * Gets employee id number
     *
     * @return Employee ID card number
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets employee id number to given value in parameter
     * @param employeeId Desired employee id card number
     */
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

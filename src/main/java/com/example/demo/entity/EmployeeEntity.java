package com.example.demo.entity;

import java.time.Year;

/**
 * Employee implementation to perform operation Employee entity
 */
public class EmployeeEntity implements Employee {
    private String name;
    private String lastname;
    private short yearOfBirth;
    private String phone;
    private String manager;

    /**
     * Constructor creating a new object (EmployeeEntity)
     *
     * @param name Employee's name
     * @param lastname Employee's lastname
     * @param yearOfBirth Employee's yearOfBirth
     * @param phone Employee's phone
     * @param manager Employee's manager
     */
    public EmployeeEntity(String name, String lastname, short yearOfBirth, String phone, String manager) {
        setName(name);
        setLastname(lastname);
        setYearOfBirth(yearOfBirth);
        setPhone(phone);
        setManager(manager);
    }
    /**
     * Method transforming EmployeeEntity to String
     *
     * @return Employee entity transformed to String
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", phone='" + phone + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        if (lastname == null || lastname.isEmpty()) {
            throw new IllegalArgumentException("Field empty, input lastname");
        } else {
            this.lastname = lastname;
        }
    }

    public void setYearOfBirth(short yearOfBirth) {
        if (yearOfBirth < 1920 || yearOfBirth > Year.now().getValue()) {
            throw new IllegalArgumentException("Input year > 1920 and < 2021");
        } else {
            this.yearOfBirth = yearOfBirth;
        }
    }

    public void setPhone(String phone) {

        if(phone.matches("(\\+*)\\d{11}")){
            this.phone = phone;
        }
        else{
            throw new IllegalArgumentException(("Input phone consist + and 11 number"));
        }
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String lastname() {
        return lastname;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short yearOfBirth() {
        return yearOfBirth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String phone() {
        return phone;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String manager() {
        return manager;
    }
}

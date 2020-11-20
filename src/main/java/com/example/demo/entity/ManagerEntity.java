package com.example.demo.entity;


import java.time.DateTimeException;
import java.time.Year;

/**
 * Manager implementation to perform operation Manager entity
 */
public class ManagerEntity implements Manager {
    private String name;
    private String lastname;
    private short yearOfBirth;
    private String phone;
    private String nameOfDepartment;

    public ManagerEntity() {
    }

    /**
     * Constructor creating a new object (ManagerEntity)
     *
     * @param name Manager's name
     * @param lastname Manager's lastname
     * @param yearOfBirth Manager's yearOfBirth
     * @param phone Manager's phone
     * @param nameOfDepartment Manager's department name
     */
    public ManagerEntity(String name, String lastname, short yearOfBirth, String phone, String nameOfDepartment) {
        setName(name);
        setLastname(lastname);
        setYearOfBirth(yearOfBirth);
        setPhone(phone);
        setNameOfDepartment(nameOfDepartment);
    }
    /**
     * Method transforming ManagerEntity to String
     *
     * @return Manager entity transformed to String
     */
    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", phone='" + phone + '\'' +
                ", nameOfDepartment='" + nameOfDepartment + '\'' +
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

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
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
    public String nameOfDepartment() {
        return nameOfDepartment;
    }
}

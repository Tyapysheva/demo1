package com.example.demo.entity;

public interface Employee extends Worker {
    /**
     * Method returning employee's manager
     *
     * @return manager Employee's manager
     * */
    String manager();
}

package com.example.demo;

import com.example.demo.entity.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SerializerWorker {


    private static final Type MANAGER_TYPE = new TypeToken<List<ManagerEntity>>() {
    }.getType();
    private static final Type Employee_TYPE = new TypeToken<List<EmployeeEntity>>() {
    }.getType();
/**
 * Method saving to file
 *
 * @param workerList List of workers
 * */
    public void saveToFile(List<Worker> workerList) {

        List<Employee> employeeList = new ArrayList<>();
        List<Manager> managerList = new ArrayList<>();

        for (Worker worker : workerList) {
            if (worker instanceof Employee) {
                employeeList.add((Employee) worker);
            }
            if (worker instanceof Manager) {
                managerList.add((Manager) worker);
            }
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter employeeWriter = null;
        try {
            employeeWriter = new FileWriter("Employee.json");
            employeeWriter.write(gson.toJson(employeeList));
            employeeWriter.close();
            FileWriter managerWriter = new FileWriter("Manager.json");
            managerWriter.write(gson.toJson(managerList));
            managerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Method reading from file
     *
     * @return workerList List of workers
     * */
    public List<Worker> readFromFile() {

        List<Worker> workerList = new ArrayList<>();
        List<Employee> employeeList = new ArrayList<>();
        List<Manager> managerList = new ArrayList<>();

        for (Worker worker : workerList) {
            if (worker instanceof Employee) {
                employeeList.add((Employee) worker);
            }
            if (worker instanceof Manager) {
                managerList.add((Manager) worker);
            }
        }
        Gson gson = new Gson();
        //parsing files to objects
        try {
            JsonReader employeeReader = new JsonReader(new FileReader("Employee.json"));
            employeeList = gson.fromJson(employeeReader, Employee_TYPE);
            JsonReader managerReader = new JsonReader(new FileReader("Manager.json"));
            managerList = gson.fromJson(managerReader, MANAGER_TYPE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        workerList.addAll(employeeList);
        workerList.addAll(managerList);
        return workerList;
    }
}

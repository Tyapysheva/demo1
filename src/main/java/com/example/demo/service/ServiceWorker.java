package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.Manager;
import com.example.demo.entity.Worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ServiceWorker {

    private List<Worker> workerList;

    /**
     * Method returning workers
     *
     * @return List of workers
     * */
    public List<Worker> getWorkerList() {
        return workerList;
    }

    /**
     * Constructor creating a new object (ServiceWorker)
     *
     * @param workerList List of workers
     */
    public ServiceWorker(List<Worker> workerList) {
        this.workerList = workerList;
    }

    /**
     * Method adding worker
     *
     * @param worker Worker
     *
     * */
    public void addWorker(Worker worker) {
        workerList.add(worker);
    }
    /**
     * Method removing worker
     *
     * @param index Worker's index
     * */
    public void removeWorker(int index) {
        if(index >= workerList.size()){
            System.out.println("List of workers has not such index");
        }
        else workerList.remove(index);
    }
    /**
     * Method searching workers by name
     *
     * @param name Worker's name
     * @return workerList List of workers
     * */
    public List<Worker> searchWorkerByName(String name) {
        return workerList.stream().filter(worker -> worker.name().equals(name)).collect(Collectors.toList());
    }

    /**
     * Method searching workers by lastname
     *
     * @param lastname Worker's lastname
     * @return workerList List of workers
     * */
    public List<Worker> searchWorkerByLastname(String lastname) {
        return workerList.stream().filter(worker -> worker.lastname().equals(lastname)).collect(Collectors.toList());
    }

    /**
     * Method searching workers by phone
     *
     * @param phone Worker's phone
     * @return workerList List of workers
     * */
    public List<Worker> searchWorkerByPhone(String phone) {
        return workerList.stream().filter(worker -> worker.phone().equals(phone)).collect(Collectors.toList());
    }

    /**
     * Method ascending sorting of workers by lastname
     *
     * @return workerList List of workers
     * */
    public List<Worker> sortWorkerByLastnameAsc() {

        workerList.sort((worker1, worker2) -> worker1.lastname().compareTo(worker2.lastname()));
        return workerList;
    }

    /**
     * Method descending sorting of workers by lastname
     *
     * @return workerList List of workers
     * */
    public List<Worker> sortWorkerByLastnameDesc() {

        workerList.sort((worker1, worker2) -> worker2.lastname().compareTo(worker1.lastname()));
        return workerList;
    }

    /**
     * Method sorting workers by year of birth
     *
     * @return workerList List of workers
     * */
    public List<Worker> sortWorkerByYearOfBirth() {

        workerList.stream().sorted((Comparator.comparing(Worker::yearOfBirth))).
                collect(Collectors.toList());
        return workerList;
    }
}

package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.service.ServiceWorker;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class Menu {


    private final String startOptions = "Menu:\n 1. Show all\n 2. Add employee\n 3. Add manager\n 4. Find by lastname\n " +
            "5. Find by name\n 6. Find by phone\n 7. Sort by lastname ASC\n 8. Sort by lastname DESC\n " +
            "9. Sort by year.\n 10. Delete by index\n 100. exit";


    public void initMenu() throws IOException {

        Scanner scanner = new Scanner(System.in);
        int key = Integer.MAX_VALUE;
        SerializerWorker serializerWorker = new SerializerWorker();
        ServiceWorker serviceWorker = new ServiceWorker(serializerWorker.readFromFile());
        Manager m = new ManagerEntity("S", "2", (short) 1995, "+11111111111", "F1");
        serviceWorker.addWorker(m);
        Employee em = new EmployeeEntity("Em", "Em1", (short) 1996, "+11111111111", "hfh");
        serviceWorker.addWorker(em);
        do {
            System.out.println(startOptions);
            String menuInput = scanner.nextLine();

                key = Integer.parseInt(menuInput);


            switch (key) {

                // return all workers
                case 1: {
                    System.out.println(serviceWorker.getWorkerList());
                    System.out.println("Press Enter ...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

               case 2: {
                    System.out.println("Input Lastname: \n");
                    String lastname = scanner.nextLine();
                    System.out.println("Input name: \n");
                    String name = scanner.nextLine();
                    System.out.println("Input yearOfBirth: \n");
                    String year = scanner.nextLine();
                    short yearOfBirth = Short.parseShort(year);
                    System.out.println("Input phone: \n");
                    String phone = scanner.nextLine();
                    System.out.println("Input manager: \n");
                    String manager = scanner.nextLine();
                    Worker employee = new EmployeeEntity(name, lastname, (short)yearOfBirth, phone, manager);
                    serviceWorker.addWorker(employee);
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    System.out.println("Input lastname: \n");
                    String lastname = scanner.nextLine();
                    System.out.println("Input name: \n");
                    String name = scanner.nextLine();
                    System.out.println("Input yearOfBirth: \n");
                    String year = scanner.nextLine();
                    short yearOfBirth = Short.parseShort(year);
                    System.out.println("Input phone: \n");
                    String phone = scanner.nextLine();
                    System.out.println("Input nameOfDepartment: \n");
                    String nameOfDepartment = scanner.nextLine();
                    Worker employee = new ManagerEntity(name, lastname, (short)yearOfBirth, phone, nameOfDepartment);
                    serviceWorker.addWorker(employee);
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                // search workers by lastname
                case 4: {
                    System.out.println("Input Lastname: \n");
                    String lastname = scanner.nextLine();
                    System.out.println(serviceWorker.searchWorkerByLastname(lastname));
                    scanner.nextLine();
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                // search workers  by name
                case 5: {
                    System.out.println("Input name: \n");
                    String name = scanner.nextLine();
                    System.out.println(serviceWorker.searchWorkerByName(name));
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                // search workers by phone
                case 6: {
                    System.out.println("Input phone: \n");
                    String phone = scanner.nextLine();
                    System.out.println(serviceWorker.searchWorkerByPhone(phone));
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                // sort workers by lastname ASC
                case 7: {
                    System.out.println(serviceWorker.sortWorkerByLastnameAsc());
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                // sort workers by lastname
                case 8: {
                    System.out.println(serviceWorker.sortWorkerByLastnameDesc());
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                // sort workers by year
                case 9: {
                    System.out.println(serviceWorker.sortWorkerByYearOfBirth());
                    System.out.println("Press Enter...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                // remove workers by index
                case 10: {
                    System.out.println("Input index : \n");
                    int index;

                    if (scanner.hasNextInt()){
                        index = scanner.nextInt();
                        scanner.nextLine();
                        serviceWorker.removeWorker(index);
                        System.out.println("Press Enter...");

                    }
                    else {
                        System.out.println("Incorrect value\nTry again ");
                        System.out.println("Press Enter...");
                        scanner.nextLine();
                    }
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                // exit and save data
                case 100: {
                    key = 100;
                    serializerWorker.saveToFile(serviceWorker.getWorkerList());
                    break;
                }
                default: {
                    System.out.println("Try again");
                    break;
                }
            }
        }
        while (key != 100);


       /* Manager m = new ManagerEntity("S", "2", (short) 1995, "12", "F1");

        serviceManager.addManager(m);
        serializerManager.saveToFile("Manager.json", serviceManager.getManagerList());
        serviceManager.sortManagerByLastnameDesc();
        System.out.println(serviceManager.getManagerList());
*/
    }
}

package company.model;

import company.controller.Controller;
import lombok.Setter;

import java.util.ArrayList;

public class Model {

    @Setter
    private Controller controller;
    private int counter = 0;
    private ArrayList<Employee> employees = new ArrayList<>();

    public void add(Employee employee){
        // Generate unique ID, Unique until 10^4 employees have been added
        // Which in this case will never happen
        String id = String.format ("%04d", counter);
        id += "EMPL";

        employee.setId(id);
        this.employees.add(employee);

        counter++;

        controller.handleModelChange();
    }

    public void delete(String id){
        employees.removeIf(employee -> employee.getId().equals(id));
        controller.handleModelChange();
    }

    public ArrayList<Employee> getAll(){
        return this.employees;
    }

    public Employee get(String id){
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return null;
    }

    public void updateAddress(String id, String address ){
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                employee.setAddress(address);
            }
        }
        controller.handleModelChange();
    }

    public void updatePhone(String id, String phone ){
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                employee.setPhone(phone);
            }
        }
        controller.handleModelChange();
    }
}

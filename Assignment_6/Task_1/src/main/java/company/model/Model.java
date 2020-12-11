package company.model;

import company.view.View;
import lombok.Setter;

import java.util.ArrayList;

public class Model {

    @Setter
    View view;
    int counter = 0;
    ArrayList<Employee> employees = new ArrayList<>();

    public void add(Employee employee){
        // Generate unique ID, Unique until 10^4 employees have been added
        // Which in this case will never happen
        String id = String.format ("%04d", counter);
        id += "EMPL";

        employee.setId(id);
        this.employees.add(employee);

        counter++;

        this.signalUpdate();
    }

    public void delete(String id){
        employees.removeIf(employee -> employee.getId().equals(id));
        this.signalUpdate();
    }

    public Employee get(String id){
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return null;
    }

    public void updateAdress(String id, String address ){
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                employee.setAddress(address);
            }
        }
        this.signalUpdate();
    }

    public void updatePhone(String id, String phone ){
        for (Employee employee : employees){
            if (employee.getId().equals(id)){
                employee.setPhone(phone);
            }
        }
        this.signalUpdate();
    }

    private void signalUpdate(){
        String out = "List of all employees: \n";
        for (Employee employee : employees){
            out += employee.toString() + "\n";
        }
        view.changeView(out);
    }
}

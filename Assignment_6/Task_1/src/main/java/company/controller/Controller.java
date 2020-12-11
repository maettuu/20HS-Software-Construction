package company.controller;

import company.model.Employee;
import company.model.Model;
import company.view.View;
import lombok.Setter;

public class Controller {

    @Setter
    Model model;
    @Setter
    View view;

    public void handleUserCommand(String input){
        String[] commands = input.split(" ");

        switch (commands[0]){
            case "create":
                handleCreateCommand(commands);
                break;
            case "print":
                handlePrintCommand(commands);
                break;
            case "update":
                handleUpdateCommand(commands);
                break;
            case "exit":
                view.destroy();
                break;
            case "help":
                view.changeView(
                        "Accepted commands: \n" +
                                "help: request help \n" +
                                "create <name> <surname> <address> <phone>: Create a new employee, seperate by space \n" +
                                "print <id> name|surname|phone|address|id: print a field of an employee, its " +
                                "its possible to give multiple commands like: print <id> name phone \n" +
                                "update <id> phone|address <new phone>|<new address>: update the field of an employee\n" +
                                "exit: exit the view"
                );
                break;
            default:
                view.changeView("Invalid format!\n" +
                        "Accepted commands: \n" +
                        "create print update exit \n" +
                        "Please try again, type help for help");

        }
    }

    void handleCreateCommand(String[] commands){
        if (commands.length != 5){
            view.changeView("Invalid format! \n" +
                    "To create a new Employee, please respect the following Format: \n" +
                    "create <name> <surname> <address> <phone> \n" +
                    "Please try again");

        }

        Employee newEmployee = new Employee(
                commands[1], commands[2], commands[3], commands[4]
        );
        this.model.add(newEmployee);
    }

    void handleUpdateCommand(String[] commands){
        Employee employee = model.get(commands[1]);
        if (commands.length != 4){
            view.changeView("Invalid format! \n" +
                    "To update an employee, please respect the following Format: \n" +
                    "update <id> phone <phone> \n" +
                    "or: \n" +
                    "update <id> address <address> \n" +
                    "Please try again");
        }

        switch (commands[2]){
            case "address":
                model.updateAdress(commands[1], commands[3]);
                break;
            case "phone":
                model.updatePhone(commands[1], commands[3]);
                break;
            default:
                view.changeView("Invalid format! \n" +
                        "To update an employee, please respect the following Format: \n" +
                        "update <id> phone <phone> \n" +
                        "or: \n" +
                        "update <id> address <address> \n" +
                        "Please try again");
        }
    }

    void handlePrintCommand(String[] commands) {
        String out = "";
        Employee employee = model.get(commands[1]);
        for (int i = 2; i < commands.length; i++) {
            switch (commands[i]) {
                case "address":
                    out += employee.getAddress() + " ";
                    break;
                case "phone":
                    out += employee.getPhone() + " ";
                    break;
                case "surname":
                    out += employee.getSurname() + " ";
                    break;
                case "name":
                    out += employee.getSurname() + " ";
                    break;
                case "id":
                    out += employee.getSurname() + " ";
                    break;
            }
        }

        this.view.changeView(out);
    }

}

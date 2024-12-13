package company.view;

import company.controller.Controller;
import company.model.Model;
import lombok.Setter;

import java.util.Scanner;

public class View {
    @Setter
    private Controller controller;

    private Boolean isOpen;

    public void changeView(String output){
        System.out.println(output);
    }

    public void open() {
        System.out.println("Welcome to the employee management system");
        System.out.println("type help for help");
        this.isOpen = true;
        while(this.isOpen){
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            this.handleInput(line);
        }
    }

    public void handleInput(String in){
        this.controller.handleUserCommand(in);
    }

    public void close(){
        System.out.println("Thanks for using our employee management system, bye!");
        this.isOpen = false;
    }
}

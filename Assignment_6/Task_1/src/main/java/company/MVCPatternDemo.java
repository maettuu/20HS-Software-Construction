package company;

import company.controller.Controller;
import company.model.Model;
import company.view.View;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MVCPatternDemo {
    public static void main(String args[]){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller();

        view.setController(controller);

        controller.setModel(model);
        controller.setView(view);

        model.setView(view);

        // 1) Create employees
        view.handleInput("create hans muster zürich 1298398");

        // 2) Print name, surname and ID
        view.handleInput("print 0000EMPL name surname id");

        // 3) Update the employee address
        view.handleInput("update 0000EMPL address brugg");

        // 4) Print the new address
        view.handleInput("print 0000EMPL address");

        // 5) Update the employee phone number
        view.handleInput("update 0000EMPL phone 1928398");

        // 6) Print the new address
        view.handleInput("print 0000EMPL phone");




    }

}

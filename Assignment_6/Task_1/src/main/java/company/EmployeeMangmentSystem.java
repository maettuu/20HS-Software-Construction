package company;

import company.controller.Controller;
import company.model.Model;
import company.view.View;

public class EmployeeMangmentSystem {
    public static void main(String args[]){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller();

        view.setController(controller);

        controller.setModel(model);
        controller.setView(view);

        model.setView(view);

        view.open();
    }
}

import controller.Controller;
import repository.IRepository;
import repository.Repository;
import ui.ASCIIUserInterface;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String args[]) {
        IRepository repository = new Repository();
        Controller controller = new Controller(repository);
        ASCIIUserInterface ui;

        // alternative: read input from file.
        /*try {
            ui = new ASCIIUserInterface(controller, "input");
            ui.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        ui = new ASCIIUserInterface(controller);
        ui.run();
    }
}

package controller;

import domain.execution.ProgramState;
import repository.IRepository;

/**
 * Created by alex on 10/11/15.
 */
public class Controller {

    private IRepository repository;
    private boolean debug = false;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    void oneStep(ProgramState state) {

    }

    void execute() {

    }


}

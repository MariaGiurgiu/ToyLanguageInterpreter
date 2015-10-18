package repository;

import domain.execution.ProgramState;

/**
 * Repository of ProgramState.
 */
public class Repository implements IRepository {

    private ProgramState[] programs;
    private int currentProgram;
    private int size;

    /**
     * Creates a repository of capacity 1.
     */
    public Repository() {
        programs = new ProgramState[1];
        currentProgram = 0;
        size = 0;
    }

    @Override
    public ProgramState getCurrentProgram() {
        return programs[currentProgram];
    }

    @Override
    public void addProgram(ProgramState program) {
        programs[size++] = program;
    }

    @Override
    public void removeCurrentProgram() {
        programs[currentProgram] = null;
        --size;
    }
}

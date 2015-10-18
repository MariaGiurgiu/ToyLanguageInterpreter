package repository;

import domain.execution.ProgramState;

/**
 * Interface for a repository of ProgramStates.
 */
public interface IRepository {

    /**
     * @return the current program.
     */
    ProgramState getCurrentProgram();

    /**
     * Adds a program to the repository.
     *
     * @param program that will be added.
     */
    void addProgram(ProgramState program);

    /**
     * Removes the current program from the repository.
     */
    void removeCurrentProgram();
}

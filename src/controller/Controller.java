package controller;

import domain.execution.*;
import domain.expressions.Expression;
import domain.statements.*;
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

    void oneStep(ProgramState state) throws ToyExecutionException {
        IStack stack = state.getExecutionStack();
        if (stack.isEmpty())
            throw new ToyExecutionException("Empty Stack. Nothing to execute.");
        IStatement current = stack.pop();
        if (current instanceof CompoundStatement) {
            CompoundStatement statement = (CompoundStatement) current;
            IStatement first = statement.getFirst();
            IStatement second = statement.getSecond();
            stack.push(second);
            stack.push(first);
            return;
        }
        if (current instanceof AssignStatement) {
            AssignStatement statement = (AssignStatement) current;
            IDictionary symbols = state.getSymbols();
            Expression expression = statement.getExpression();
            String name = statement.getName();
            int value = expression.eval(symbols);
            symbols.put(name, value);
            return;
        }
        if (current instanceof PrintStatement) {
            PrintStatement statement = (PrintStatement) current;
            IDictionary symbols = state.getSymbols();
            Expression expression = statement.getExpression();
            IList output = state.getOutput();
            int value = expression.eval(symbols);
            output.add(Integer.toString(value));
            return;
        }
        if (current instanceof IfStatement) {
            IfStatement statement = (IfStatement) current;
            IDictionary symbols = state.getSymbols();
            Expression expression = statement.getExpression();
            int value = expression.eval(symbols);
            IStatement branch;
            if (value != 0) {
                branch = statement.getThenStatement();
            } else {
                branch = statement.getElseStatement();
            }
            stack.push(branch);
        }

    }

    void execute() throws ToyExecutionException {
        ProgramState program = repository.getCurrentProgram();
        while (true) {
            oneStep(program);
            if (debug) {
                return;
            }
        }
    }

    String getCurrentProgram() {
        return repository.getCurrentProgram().toString();
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}

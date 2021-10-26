package be.heh.epm.application.employee;

import be.heh.epm.application.Command;

public class DeleteEmploye implements Command {

    // ATTRIBUTES
    int id;

    // CONSTRUCTORS
    public DeleteEmploye(int id) {
        this.id = id;
    }

    // GETTERS & SETTERS

    // METHODS
    @Override
    // Supprime un employé selon son ID
    public void execute() {
        Context.emp.deleteEmployed(id);
    }
}

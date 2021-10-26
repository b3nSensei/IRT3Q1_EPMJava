package be.heh.epm.application.modification;

import be.heh.epm.application.Command;
import be.heh.epm.application.employee.Context;
import be.heh.epm.application.employee.Employee;

public abstract class ModificationEmployee implements Command {
    private int empId;

    public ModificationEmployee(int empId) {
        this.empId = empId;
    }

    public abstract void modification(Employee employee);

    @Override
    public void execute() {
        Employee e = Context.emp.getEmployee(empId);
        if (e != null) {
            modification(e);
        }
        else {
            throw new NullPointerException("Pas d'employé pour cet id");
        }
    }
}

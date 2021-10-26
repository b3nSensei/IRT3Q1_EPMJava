package be.heh.epm.application.modification;

import be.heh.epm.application.employee.Employee;

public class ModificationName extends ModificationEmployee{
    private String name;

    public ModificationName(int empId, String name) {
        super(empId);
        this.name = name;
    }

    @Override
    public void modification(Employee employee) {
        employee.setName(name);
    }
}

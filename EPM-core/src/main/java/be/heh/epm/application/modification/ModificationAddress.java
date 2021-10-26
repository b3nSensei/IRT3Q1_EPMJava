package be.heh.epm.application.modification;

import be.heh.epm.application.employee.Employee;

public class ModificationAddress extends ModificationEmployee{
    private String address;

    public ModificationAddress(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    public void modification(Employee employee) {
        employee.setAddress(address);
    }
}

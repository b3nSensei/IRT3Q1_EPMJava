package be.heh.epm.application.modification;

import be.heh.epm.application.employee.Employee;

public class ModificationMail extends ModificationEmployee{
    private String mail;

    public ModificationMail(int empId, String mail) {
        super(empId);
        this.mail = mail;
    }

    @Override
    public void modification(Employee employee) {
        employee.setMail(mail);
    }
}

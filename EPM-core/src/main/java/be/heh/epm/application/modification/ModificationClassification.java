package be.heh.epm.application.modification;

import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.employee.Employee;
import be.heh.epm.application.schedule.PaymentSchedule;

public abstract class ModificationClassification extends ModificationEmployee{

    public ModificationClassification(int empId) {
        super(empId);
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    @Override
    public void modification(Employee employee) {
        employee.setPayClassification(getClassification());
        employee.setPaySchedule(getSchedule());
    }
}

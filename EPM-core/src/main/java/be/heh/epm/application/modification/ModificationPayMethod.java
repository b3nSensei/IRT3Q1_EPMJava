package be.heh.epm.application.modification;

import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.employee.Employee;
import be.heh.epm.application.payMethod.PaymentMethod;
import be.heh.epm.application.schedule.PaymentSchedule;

public abstract class ModificationPayMethod extends ModificationEmployee{

    public ModificationPayMethod(int empId) {
        super(empId);
    }

    public abstract PaymentMethod getMethod();

    @Override
    public void modification(Employee employee) {
        employee.setPayMethod(getMethod());
    }
}

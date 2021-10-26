package be.heh.epm.application.modification;

import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;

public class ModificationSalaried extends ModificationClassification{
    private double salary;

    public ModificationSalaried(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlyPaymentSchedule();
    }
}

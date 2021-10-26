package be.heh.epm.application.modification;

import be.heh.epm.application.classification.HourlyClassification;
import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.application.schedule.WeeklyPaymentSchedule;

public class ModificationHourly extends ModificationClassification{
    private double salary;

    public ModificationHourly(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklyPaymentSchedule();
    }
}

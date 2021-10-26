package be.heh.epm.application.modification;

import be.heh.epm.application.classification.CommissionClassification;
import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.application.schedule.TwoWeeksPayementSchedule;

public class ModificationCommissioned extends ModificationClassification{
    private double salary;
    private double commission;

    public ModificationCommissioned(int empId, double salary, double commission) {
        super(empId);
        this.salary = salary;
        this.commission = commission;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionClassification(salary, commission);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new TwoWeeksPayementSchedule();
    }
}

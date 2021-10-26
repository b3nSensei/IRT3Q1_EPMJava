package be.heh.epm.application.employee;

import be.heh.epm.application.classification.CommissionClassification;
import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.application.schedule.TwoWeeksPayementSchedule;

public class AddCommissionedEmployee extends AddEmployee{

    // ATTRIBUTES
    double salary;
    double commission;

    // CONSTRUCTOR
    public AddCommissionedEmployee(int id, String name, String address, String mail, double salary, double commission) {
        super(id, name, address, mail);
        this.salary = salary;
        this.commission = commission;
    }

    // GETTERS & SETTERS

    // METHODS
    @Override
    // Défini la classification sur Commissionned et la retourne
    public PaymentClassification makePayClassification() {
        return new CommissionClassification(salary, commission);
    }

    @Override
    // Définit le schéma de payement sur 1 vendredi sur 2 et la retourne
    public PaymentSchedule makePaySchedule() {
        return new TwoWeeksPayementSchedule();
    }
}

package be.heh.epm.application.employee;

import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.SalariedClassification;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployee{

    //ATTRIBUTES
    double salary;

    // CONSTRUCTORS
    public AddSalariedEmployee(int id, String name, String address, String mail, double salary) {
        super(id, name, address, mail);
        this.salary = salary;
    }

    // GETTERS & SETTERS

    // METHODS
    @Override
    // Défini l'employé comme Salarié et la retourne
    public PaymentClassification makePayClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    // Défini l'employé comme payé par mois
    public PaymentSchedule makePaySchedule() {
        return new MonthlyPaymentSchedule();
    }
}

package be.heh.epm.application.classification;

import be.heh.epm.application.Command;
import be.heh.epm.application.employee.Context;
import be.heh.epm.application.employee.Employee;

import java.time.LocalDate;

public class AddTimeCard implements Command {

    // ATTRIBUTES
    int empId;
    LocalDate date;
    double hours;
    TimeCard tc;

    // CONSTRUCTOR
    public AddTimeCard(int empId, LocalDate date, double hours) {
        this.empId = empId;
        this.date = date;
        this.hours = hours;
    }

    // GETTERS & SETTERS
    public LocalDate getDate() {
        return date;
    }

    public double getHours() {
        return hours;
    }

    // METHODS
    @Override
    public void execute() {
        // Récupérer l'enmployé
        Employee e = Context.emp.getEmployee(empId);
        if(e != null) { // Si l'employé existe...
            PaymentClassification pc = e.getPayClassification(); // On récupère sa classification
            if (pc instanceof HourlyClassification) { // S'il est payé à l'heure
                HourlyClassification hc = (HourlyClassification) pc;
                tc = new TimeCard(date, hours); // On lui crée sa TimeCard
                hc.addTimeCard(tc); // On lui ajoute
                Context.emp.save(e.getEmpID(), e); // Et on envoie pour la sauvegarde
            }
            else { // S'il n'est pas payé à l'heure
                throw new IllegalStateException("L'employé n'est pas payé à l'heure");
            }
        }
        else{ // S'il n'existe pas
            throw new NullPointerException("Aucun employé correspondant au numéro entré");
        }
    }
}

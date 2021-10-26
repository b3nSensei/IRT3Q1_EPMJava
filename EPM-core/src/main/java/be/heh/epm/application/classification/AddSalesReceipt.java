package be.heh.epm.application.classification;

import be.heh.epm.application.Command;
import be.heh.epm.application.employee.Context;
import be.heh.epm.application.employee.Employee;

import java.time.LocalDate;

public class AddSalesReceipt implements Command {

    // ATTRIBUTES
    int empId;
    LocalDate date;
    double saleAmount;
    SaleReceipt sr;

    // CONSTRUCTOR
    public AddSalesReceipt(int empId, LocalDate date, double saleAmount) {
        this.empId = empId;
        this.date = date;
        this.saleAmount = saleAmount;
    }

    // GETTERS & SETTERS
    public LocalDate getDate() {
        return date;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    // METHODS
    @Override
    public void execute() {
        // Récupérer l'enmployé
        Employee e = Context.emp.getEmployee(empId);
        if(e != null) { // Si l'employé existe...
            PaymentClassification pc = e.getPayClassification(); // On récupère sa classification
            if (pc instanceof CommissionClassification) { // S'il touche des commissions
                CommissionClassification cc = (CommissionClassification) pc;
                sr = new SaleReceipt(date, saleAmount); // On crée la reçu de vente
                cc.addSaleReceipt(sr); // Et on l'ajoute
                Context.emp.save(e.getEmpID(), e); // Et on envoie pour la sauvegarde
            }
            else { // S'il ne touche pas de commissions
                throw new IllegalStateException("L'employé n'est pas payé en commission.");
            }
        }
        else{ // Si l'employé n'existe pas
            throw new NullPointerException("Aucun employé correspondant au numéro entré");
        }
    }
}

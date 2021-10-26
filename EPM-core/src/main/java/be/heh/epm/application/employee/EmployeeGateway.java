package be.heh.epm.application.employee;

import java.util.Map;

public interface EmployeeGateway {
    // DECLARED METHODS
    public Employee getEmployee(int id); // Va chercher un employé selon son ID

    public void save(int id, Employee employee); // Sauvegarde un employé à l'ID définie

    public void deleteEmployed(int id); // Supprime l'employé indiqué par l'ID

    public Map getAllEmployees(); // Va chercher tous les employés
}

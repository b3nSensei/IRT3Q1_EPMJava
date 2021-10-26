package be.heh.epm.application.port.out;

import be.heh.epm.application.employee.Employee;
import java.util.ArrayList;


public interface EmployeePort {
    ArrayList<Employee> getAllEmployee();   //Interface de listing employee
    Employee getBy(int EmpID);              //Interface de recherche d'employee par ID
    Employee save(Employee employee);       //Interface de sauvegarde d'employee
    void deleteEmployee(int id);            //Interface de suppresion d'employee
}

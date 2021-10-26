package be.heh.epm.domain;

import be.heh.epm.application.employee.Employee;
import be.heh.epm.application.employee.EmployeeGateway;

import java.util.HashMap;
import java.util.Map;

public class InMemoryEmployGateway implements EmployeeGateway {
    private Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

    @Override
    public Employee getEmployee(int id) {
        return employeeMap.get(id);
    }

    @Override
    public void save(int id, Employee employee) {
        employeeMap.put(id, employee);
    }

    @Override
    public void deleteEmployed(int id) {
        employeeMap.remove(id);
    }

    @Override
    public Map getAllEmployees() {
        return employeeMap;
    }
}

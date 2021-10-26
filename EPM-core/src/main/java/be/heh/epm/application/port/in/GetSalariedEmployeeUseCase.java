package be.heh.epm.application.port.in;

import be.heh.epm.application.employee.Employee;

import java.util.ArrayList;

public interface GetSalariedEmployeeUseCase {
    public ArrayList<Employee> get();
}
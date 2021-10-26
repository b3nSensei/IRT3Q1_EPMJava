package be.heh.epm.application.service;

import be.heh.epm.application.employee.Employee;
import be.heh.epm.application.port.in.GetSalariedEmployeeUseCase;
import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.common.UseCase;

import java.util.ArrayList;

@UseCase
public class GetSalariedEmployeeService implements GetSalariedEmployeeUseCase {

    private EmployeePort employeePort;

    public GetSalariedEmployeeService(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public ArrayList<Employee> get() {
        return employeePort.getAllEmployee();
    }
}
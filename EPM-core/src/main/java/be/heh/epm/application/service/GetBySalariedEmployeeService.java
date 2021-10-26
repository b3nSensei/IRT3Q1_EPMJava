package be.heh.epm.application.service;

import be.heh.epm.application.employee.Employee;
import be.heh.epm.application.port.in.GetBySalariedEmployeeUseCase;
import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.common.UseCase;

@UseCase
public class GetBySalariedEmployeeService implements GetBySalariedEmployeeUseCase {

    private EmployeePort employeePort;

    public GetBySalariedEmployeeService(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    @Override
    public Employee getBy(int id) {
        return employeePort.getBy(id);
    }
}
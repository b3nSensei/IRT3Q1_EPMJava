package be.heh.epm.application.service;

import be.heh.epm.application.port.in.DelSalariedEmployeeUseCase;
import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.common.UseCase;

@UseCase
public class DelSalariedEmployeeService implements DelSalariedEmployeeUseCase {

    private EmployeePort employeePort;

    public DelSalariedEmployeeService(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void del(int delEmployee) {
        int id = delEmployee;
        employeePort.deleteEmployee(id);
    }
}
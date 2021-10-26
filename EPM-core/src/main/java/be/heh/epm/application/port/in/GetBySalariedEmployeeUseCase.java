package be.heh.epm.application.port.in;


import be.heh.epm.application.employee.Employee;

public interface GetBySalariedEmployeeUseCase {
    public Employee getBy(int id);
}
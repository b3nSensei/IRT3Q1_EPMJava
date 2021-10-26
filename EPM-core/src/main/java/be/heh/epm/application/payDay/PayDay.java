package be.heh.epm.application.payDay;

import be.heh.epm.application.Command;
import be.heh.epm.application.employee.Context;
import be.heh.epm.application.employee.Employee;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PayDay implements Command {
    LocalDate date;
    Map<Integer, PayCheck> payCheckList = new HashMap<Integer, PayCheck>();

    public PayDay(LocalDate date) {
        this.date = date;
    }

    @Override
    public void execute() {
        Map<Integer, Employee> employeeList = Context.emp.getAllEmployees();
        employeeList.forEach((k,v) -> {
            int empID = k;
            Employee e = v;
            if(e.isDatePay(date)) {
                PayCheck pc = new PayCheck(date);
                e.payDay(pc);
                payCheckList.put(empID, pc);
            }
        });
    }

    public PayCheck getPayChech (int empID) {
        return payCheckList.get(empID);
    }
}

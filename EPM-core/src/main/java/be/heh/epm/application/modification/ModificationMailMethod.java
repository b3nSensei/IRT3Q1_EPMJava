package be.heh.epm.application.modification;

import be.heh.epm.application.employee.Context;
import be.heh.epm.application.payMethod.DirectDepositMethod;
import be.heh.epm.application.payMethod.MailMethod;
import be.heh.epm.application.payMethod.PaymentMethod;

public class ModificationMailMethod extends ModificationPayMethod {
    // ATTRIBUTES
    private String mail;

    public ModificationMailMethod(int empId) {
        super(empId);
        mail = Context.emp.getEmployee(empId).getMail();
    }

    @Override
    public PaymentMethod getMethod() {
        return new MailMethod(mail);
    }
}

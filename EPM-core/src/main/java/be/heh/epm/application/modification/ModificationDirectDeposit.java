package be.heh.epm.application.modification;

import be.heh.epm.application.payMethod.DirectDepositMethod;
import be.heh.epm.application.payMethod.PaymentMethod;

public class ModificationDirectDeposit extends ModificationPayMethod {
    // ATTRIBUTES
    private String bank;
    private String account;

    public ModificationDirectDeposit(int empId, String bank, String account) {
        super(empId);
        this.bank = bank;
        this.account = account;
    }

    @Override
    public PaymentMethod getMethod() {
        return new DirectDepositMethod(bank, account);
    }
}

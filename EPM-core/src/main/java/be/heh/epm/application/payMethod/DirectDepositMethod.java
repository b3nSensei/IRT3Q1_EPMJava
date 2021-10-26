package be.heh.epm.application.payMethod;

public class DirectDepositMethod implements PaymentMethod {
    // ATTRIBUTES
    private String bank;
    private String account;

    // CONSTRUCTOR

    public DirectDepositMethod(String bank, String account) {
        this.bank = bank;
        this.account = account;
    }

    // GETTERS & SETTERS

    // METHODS

    @Override
    public String toString() {
        return "direct deposit into " + this.bank + " : " + this.account;
    }
}

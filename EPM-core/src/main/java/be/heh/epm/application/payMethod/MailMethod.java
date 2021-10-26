package be.heh.epm.application.payMethod;

public class MailMethod implements PaymentMethod {
    // ATTRIBUTES
    private String mail;

    // CONSTRUCTOR

    public MailMethod(String mail) {
        this.mail = mail;
    }

    // GETTERS & SETTERS

    // METHODS

    @Override
    public String toString() {
        return "mail : " + this.mail;
    }
}

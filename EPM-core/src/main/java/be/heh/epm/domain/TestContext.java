package be.heh.epm.domain;

import be.heh.epm.application.employee.Context;

public class TestContext {
    public static void setContext() {
        Context.emp = new InMemoryEmployGateway();
    }
}

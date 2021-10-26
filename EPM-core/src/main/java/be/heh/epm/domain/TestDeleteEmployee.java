package be.heh.epm.domain;

import be.heh.epm.application.employee.*;
import be.heh.epm.application.payMethod.PaymentMethod;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.application.schedule.TwoWeeksPayementSchedule;
import be.heh.epm.application.schedule.WeeklyPaymentSchedule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeleteEmployee {

    @Before
    public void setUp() throws Exception {
        TestContext.setContext();
    }

    @Test
    public void testAddSalariedEmployee() {
        int id = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(id, "Geo", "Mons", "geo@heh.be", 1000.0);
        t.execute();
        Employee e = Context.emp.getEmployee(id);
        assertNotNull(e);

        DeleteEmploye d = new DeleteEmploye(id);
        d.execute();
        e = Context.emp.getEmployee(id);
        assertNull(e);
    }
}

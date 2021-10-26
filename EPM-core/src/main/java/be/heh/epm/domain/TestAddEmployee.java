package be.heh.epm.domain;

import be.heh.epm.application.employee.*;
import be.heh.epm.application.payMethod.PaymentMethod;
import be.heh.epm.application.schedule.MonthlyPaymentSchedule;
import be.heh.epm.application.schedule.PaymentSchedule;
import be.heh.epm.application.schedule.TwoWeeksPayementSchedule;
import be.heh.epm.application.schedule.WeeklyPaymentSchedule;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAddEmployee {

    @Before
    public void setUp() throws Exception {
        TestContext.setContext();
    }

    @Test
    public void testAddSalariedEmployee() {
        AddSalariedEmployee t = new AddSalariedEmployee(1, "Geo", "Mons", "geo@heh.be", 1000.0);
        t.execute();

        Employee e = Context.emp.getEmployee(1);
        assertEquals("Geo", e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof MonthlyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("mail : geo@heh.be", pm.toString());
    }

    @Test
    public void testAddHourlyEmployee() {
        AddHourlyEmployee t = new AddHourlyEmployee(2, "Sev", "Mons", "sev@heh.be", 20.0);
        t.execute();

        Employee e = Context.emp.getEmployee(2);
        assertEquals("Sev", e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof WeeklyPaymentSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("mail : sev@heh.be", pm.toString());
    }

    @Test
    public void testAddCommissionnedEmployee() {
        AddCommissionedEmployee t = new AddCommissionedEmployee(1, "Ben", "Mons", "ben@heh.be", 250.0, 20);
        t.execute();

        Employee e = Context.emp.getEmployee(1);
        assertEquals("Ben", e.getName());

        PaymentSchedule ps = e.getPaySchedule();
        assertTrue(ps instanceof TwoWeeksPayementSchedule);

        PaymentMethod pm = e.getPayMethod();
        assertEquals("mail : ben@heh.be", pm.toString());
    }
}

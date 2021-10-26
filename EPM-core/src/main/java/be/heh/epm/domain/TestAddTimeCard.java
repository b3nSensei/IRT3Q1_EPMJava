package be.heh.epm.domain;

import be.heh.epm.application.classification.AddTimeCard;
import be.heh.epm.application.classification.HourlyClassification;
import be.heh.epm.application.classification.PaymentClassification;
import be.heh.epm.application.classification.TimeCard;
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

public class TestAddTimeCard {

    @Before
    public void setUp() throws Exception {
        TestContext.setContext();
    }


    @Test
    public void testAddTimeCard() {
        AddHourlyEmployee t = new AddHourlyEmployee(2, "Sev", "Mons", "sev@heh.be", 20.0);
        t.execute();

        LocalDate date = LocalDate.of(2020, 10, 23);
        AddTimeCard atc = new AddTimeCard(2, date, 10);
        atc.execute();

        Employee e = Context.emp.getEmployee(2);
        HourlyClassification pc = (HourlyClassification) e.getPayClassification();
        TimeCard tc = pc.getTimeCard(date);

        assertEquals(tc.getHours(), atc.getHours(), 0.01);
    }
}

package be.heh.epm.domain;

import be.heh.epm.application.classification.AddSalesReceipt;
import be.heh.epm.application.classification.AddTimeCard;
import be.heh.epm.application.employee.AddCommissionedEmployee;
import be.heh.epm.application.employee.AddHourlyEmployee;
import be.heh.epm.application.employee.AddSalariedEmployee;
import be.heh.epm.application.modification.ModificationDirectDeposit;
import be.heh.epm.application.payDay.PayCheck;
import be.heh.epm.application.payDay.PayDay;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class TestPayDay {
    @Before
    public void setUp() throws Exception {
        TestContext.setContext();
    }

    @Test
    public void testPayDay() {
        LocalDate date = LocalDate.of(2020, 11, 23);

        AddSalariedEmployee t = new AddSalariedEmployee(1, "Geo", "Mons", "geo@heh.be", 1000.0);
        t.execute();

        AddHourlyEmployee t2 = new AddHourlyEmployee(2, "Sev", "Mons", "sev@heh.be", 20.0);
        t2.execute();
        AddTimeCard tc = new AddTimeCard(2, date, 8);
        tc.execute();

        AddCommissionedEmployee t3 = new AddCommissionedEmployee(3, "Ben", "Mons", "ben@heh.be", 250.0, 20);
        t3.execute();
        AddSalesReceipt rc = new AddSalesReceipt(3, date, 1000);
        rc.execute();
        ModificationDirectDeposit mn = new ModificationDirectDeposit(3, "Belfius", "BE14 3204 5874 5231");
        mn.execute();

        LocalDate datePayDay = LocalDate.of(2020, 11, 27);
        PayDay payDay = new PayDay(datePayDay);
        payDay.execute();

        PayCheck pc1 = payDay.getPayChech(1);
        Assert.assertNull(pc1);

        PayCheck pc2 = payDay.getPayChech(2);
        Assert.assertNotNull(pc2);
        Assert.assertEquals(datePayDay, pc2.getDate());
        Assert.assertEquals(160.0, pc2.getSalary(), 0.01);
        Assert.assertEquals("mail : sev@heh.be", pc2.getMethod());

        PayCheck pc3 = payDay.getPayChech(3);
        Assert.assertNotNull(pc3);
        Assert.assertEquals(datePayDay, pc3.getDate());
        Assert.assertEquals(450.0, pc3.getSalary(), 0.01);
        Assert.assertEquals("direct deposit into Belfius : BE14 3204 5874 5231", pc3.getMethod());
    }
}

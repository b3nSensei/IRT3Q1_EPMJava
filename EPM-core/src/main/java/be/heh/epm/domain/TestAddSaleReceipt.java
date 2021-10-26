package be.heh.epm.domain;

import be.heh.epm.application.classification.*;
import be.heh.epm.application.employee.*;
import be.heh.epm.application.payDay.PayCheck;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestAddSaleReceipt {

    private AddSalariedEmployee Salariedemployee;
    private AddHourlyEmployee Hourlyemployee;
    private AddCommissionedEmployee Commissionnededemployee;
    private PayCheck pc;

    @Before
    public void setUp() throws Exception {
        TestContext.setContext();
    }


    @Test
    public void testSaleReceiptCard() {
        AddCommissionedEmployee t = new AddCommissionedEmployee(2, "Sev", "Mons", "sev@heh.be", 100.0, 20);
        t.execute();

        LocalDate date = LocalDate.of(2020, 10, 23);
        AddSalesReceipt asr = new AddSalesReceipt(2, date, 500);
        asr.execute();

        Employee e = Context.emp.getEmployee(2);
        CommissionClassification pc = (CommissionClassification) e.getPayClassification();
        SaleReceipt sr = pc.geSaleReceipt(date);

        assertEquals(sr.getSaleAmount(), asr.getSaleAmount(), 0.01);
    }
}

package com.form3.payments;

import static org.junit.Assert.assertEquals;

import com.form3.payments.model.DebtorParty;
import com.form3.payments.model.Payment;
import com.form3.payments.model.SenderCharge;
import java.io.IOException;
import java.util.List;
import org.junit.Test;


/**
 * Helper class that provides test data, as well as a simple test-case to sanity check that the
 * generated POJO model classes can be used to successfully deserialize the JSON test data file
 */
public class PaymentModelTest {

  @Test
  public void testModelDeserialisation() throws IOException {
    List<Payment> testPayments = TestData.loadPaymentsTestData();
    Payment testPayment = testPayments.iterator().next();
    assertEquals("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43", testPayment.getId());
    assertEquals("743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb", testPayment.getOrganisationId());

    List<SenderCharge> senderCharges = testPayment.getAttributes().getChargesInformation()
        .getSenderCharges();
    assertEquals("GBP", senderCharges.get(0).getCurrency());
    assertEquals(5.0, senderCharges.get(0).getAmount(), 0);
    assertEquals("USD", senderCharges.get(1).getCurrency());
    assertEquals(10.0, senderCharges.get(1).getAmount(), 0);

    DebtorParty debtorParty = testPayment.getAttributes().getDebtorParty();
    assertEquals("EJ Brown Black", debtorParty.getAccountName());
    assertEquals("GB29XABC10161234567801", debtorParty.getAccountNumber());
  }
}

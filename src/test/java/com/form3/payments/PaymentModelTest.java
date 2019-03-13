package com.form3.payments;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.form3.payments.model.Payment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.money.MonetaryAmount;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.ResourceUtils;
import org.zalando.jackson.datatype.money.MoneyModule;

/**
 * Helper class that provides test data, as well as a simple test-case to sanity check that the
 * generated POJO model classes can be used to successfully deserialize the JSON test data file
 */
public class PaymentModelTest {

  private static List<Payment> testPayments;

  @BeforeClass
  public static void setUp() throws IOException {
    testPayments = loadPaymentsTestData();
  }

  public static List<Payment> loadPaymentsTestData() throws IOException {
    Path resourceDirectory = Paths.get("src", "test", "resources").toAbsolutePath();
    File file = ResourceUtils.getFile(resourceDirectory.toString() + "/sample_payments.json");
    ObjectMapper mapper = new ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        .registerModule(new MoneyModule());
    return Arrays.asList(mapper.readValue(new FileInputStream(file), Payment[].class));
  }

  @Test
  public void testModelDeserialisation() {
    Payment testPayment = testPayments.get(0);
    assertEquals("4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43", testPayment.getId());
    assertEquals("743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb", testPayment.getOrganisationId());

  }

  @Test
  public void testMonteryValueDeserialisation() {
    Payment testPayment = testPayments.get(1);
    List<MonetaryAmount> senderCharges = testPayment.getAttributes().getChargesInformation()
        .getSenderCharges();
    // Test that the deserialisation from JSON -> MonetaryValue works
    assertEquals("GBP", senderCharges.get(0).getCurrency().getCurrencyCode());
    assertEquals(5.0, senderCharges.get(0).getNumber().doubleValue(), 0);
    assertEquals("USD", senderCharges.get(1).getCurrency().getCurrencyCode());
    assertEquals(10.0, senderCharges.get(1).getNumber().doubleValue(), 0);
  }
}

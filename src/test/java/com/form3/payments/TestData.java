package com.form3.payments;

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
import org.springframework.util.ResourceUtils;

class TestData {

  private static final String TEST_FILE = "sample_payments.json";

  static final Payment NO_ID_PAYMENT = new Payment().setVersion(0);

  static final String TEST_ID = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
  static final Payment TEST_PAYMENT = new Payment().setId(TEST_ID);

  static final String TEST_ORG_ID = "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb";
  static final Payment PAYMENT_WITH_ORG = new Payment().setId(TEST_ID)
      .setOrganisationId(TEST_ORG_ID);

  static List<Payment> loadPaymentsTestData() throws IOException {
    Path resourceDirectory = Paths.get("src", "test", "resources").toAbsolutePath();
    File file = ResourceUtils.getFile(resourceDirectory.toString() + "/" +TEST_FILE);
    ObjectMapper mapper = new ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    return Arrays.asList(mapper.readValue(new FileInputStream(file), Payment[].class));
  }
}

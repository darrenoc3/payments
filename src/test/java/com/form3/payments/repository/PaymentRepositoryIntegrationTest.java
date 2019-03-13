package com.form3.payments.repository;

import static org.junit.Assert.assertTrue;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.form3.payments.PaymentApplication;
import com.form3.payments.config.DynamoDBConfig;
import com.form3.payments.model.Payment;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PaymentApplication.class, DynamoDBConfig.class})
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
    "amazon.dynamodb.endpoint=http://localhost:8000/",
    "amazon.aws.accesskey=test1",
    "amazon.aws.secretkey=test231" })
@Ignore
public class PaymentRepositoryIntegrationTest {

  @Autowired
  private PaymentRepository repository;
  @Autowired
  private AmazonDynamoDB amazonDynamoDB;
  @Autowired
  private DynamoDBMapper mapper;

  private static final String EXPECTED_COST = "20";
  private static final String EXPECTED_PRICE = "50";

  @Before
  public void setup() throws Exception {
    mapper = new DynamoDBMapper(amazonDynamoDB);

    CreateTableRequest tableRequest = mapper
        .generateCreateTableRequest(Payment.class);
    tableRequest.setProvisionedThroughput(
        new ProvisionedThroughput(1L, 1L));
    amazonDynamoDB.createTable(tableRequest);

    //...

   // mapper.batchDelete(
   //     (List<Payment>) repository.findAll());
  }

  @Test
  public void sampleTestCase() {
    Payment payment = new Payment("3501");
    repository.save(payment);

    //Optional<Payment> result = repository.findById("3501");
    //assertTrue(result.isPresent());
  }
}
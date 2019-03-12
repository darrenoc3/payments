package com.form3.payments.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedList;
import com.form3.payments.model.Payment;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for storing Payment JSON objects keyed by Payment ID
 * Created with the help of https://github.com/zion3mx/spring-boot-dynamodb-example
 */
@Repository
public class PaymentRepository {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private DynamoDBMapper dbMapper;

  public List<Payment> readAll() {
    log.trace("Entering readAll()");
    PaginatedList<Payment> results = dbMapper.scan(Payment.class, new DynamoDBScanExpression());
    results.loadAllResults();
    return results;
  }

  public Optional<Payment> read(String id) {
    log.trace("Entering read() with {}", id);
    return Optional.ofNullable(dbMapper.load(Payment.class, id));
  }

  public void save(Payment Payment) {
    log.trace("Entering save() with {}", Payment);
    dbMapper.save(Payment);
  }

  public void delete(String id) {
    dbMapper.delete(new Payment(id));
  }
}
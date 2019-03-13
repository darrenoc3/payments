package com.form3.payments.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.form3.payments.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
/**
 * Component to create DynamoDB schema for Payment.class if it doesn't already exist
 */
class RepositoryInitialisation implements ApplicationListener<ContextRefreshedEvent> {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private DynamoDBMapper dbMapper;

  @Autowired
  private AmazonDynamoDB dynamoDB;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    log.info("Initialising DynamoDB repository");
    CreateTableRequest request = dbMapper
        .generateCreateTableRequest(Payment.class)
        .withProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
    try {
      // See if the table exists already
      DescribeTableResult result = dynamoDB.describeTable(request.getTableName());
      log.info("DynamoDB table already exists {}, {}", request.getTableName(),
          result.getTable().getTableStatus());
    } catch (ResourceNotFoundException expectedException) {
      // If not, create it
      CreateTableResult result = dynamoDB.createTable(request);
      log.info("DynamoDB table doesn't exist, creating table {}, {}", request.getTableName(),
          result.getTableDescription().getTableStatus());
    }
  }

}

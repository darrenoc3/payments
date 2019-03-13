package com.form3.payments.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Beans for AWS DynamoDB Configuration
 * Created with the help of https://github.com/derjust/spring-data-dynamodb-examples
 */
@Configuration
public class DynamoDBConfig {

  private final Logger log = LoggerFactory.getLogger(DynamoDBConfig.class);

  @Value("${amazon.aws.accesskey}")
  private String amazonAWSAccessKey;

  @Value("${amazon.aws.secretkey}")
  private String amazonAWSSecretKey;

  @Value("${amazon.aws.region}")
  private String amazonAWSRegion;

  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    log.trace("Entering amazonDynamoDb()");
    log.trace("Using Dynamo region {}", amazonAWSRegion);
    AWSCredentials foo = amazonAWSCredentials();
    return AmazonDynamoDBClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
        .withRegion(amazonAWSRegion)
        .build();
  }

  @Bean
  public DynamoDBMapper dynamoDbMapper(AmazonDynamoDB amazonDynamoDB) {
    log.trace("Entering dynamoDbMapper()");
    return new DynamoDBMapper(amazonDynamoDB);
  }

  @Bean
  public AWSCredentials amazonAWSCredentials() {
    return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
  }
}
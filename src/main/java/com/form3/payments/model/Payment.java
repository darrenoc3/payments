/**
 * Model generated from JSON by RoboPOJOGenerator: https://github.com/robohorse/RoboPOJOGenerator
 */

package com.form3.payments.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Payments")
public class Payment {

  @DynamoDBAttribute
  private String id;
  // note that tye isn't an attribute in the DB, since we only accept objects that have type=Payment
  private String type;
  @DynamoDBAttribute
  private String organisationId;
  @DynamoDBAttribute
  private int version;
  @DynamoDBAttribute
  private Attributes attributes;

  public void setOrganisationId(String organisationId) {
    this.organisationId = organisationId;
  }

  public String getOrganisationId() {
    return organisationId;
  }

  public void setAttributes(Attributes attributes) {
    this.attributes = attributes;
  }

  public Attributes getAttributes() {
    return attributes;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public int getVersion() {
    return version;
  }

  @Override
  public String toString() {
    return
        "Payment{" +
            "organisation_id = '" + organisationId + '\'' +
            ",attributes = '" + attributes + '\'' +
            ",id = '" + id + '\'' +
            ",type = '" + type + '\'' +
            ",version = '" + version + '\'' +
            "}";
  }
}

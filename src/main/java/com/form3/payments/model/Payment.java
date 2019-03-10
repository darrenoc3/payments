package com.form3.payments.model;

public class Payment {

  private String organisationId;
  private Attributes attributes;
  private String id;
  private String type;
  private int version;

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

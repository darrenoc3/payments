package com.form3.payments;

import static com.form3.payments.TestData.NO_ID_PAYMENT;
import static com.form3.payments.TestData.TEST_ORG_ID;
import static com.form3.payments.TestData.TEST_PAYMENT;
import static com.form3.payments.TestData.TEST_ID;
import static com.form3.payments.TestData.PAYMENT_WITH_ORG;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import com.form3.payments.controller.PaymentController;
import com.form3.payments.model.Payment;
import com.form3.payments.service.PaymentService;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

  @Mock
  private PaymentService service;

  @InjectMocks
  private PaymentController controller;

  @Test
  public void createShouldRespondWithCreatedAndPayment() throws Exception {
    when(service.create(NO_ID_PAYMENT)).thenReturn(NO_ID_PAYMENT);
    ResponseEntity result = controller.create(NO_ID_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.CREATED));
    assertThat(result.getBody(), equalTo(NO_ID_PAYMENT));
    verify(service).create(NO_ID_PAYMENT);
  }

  @Test
  public void createShouldRespondWithBadRequestIfIdIsPresent() throws Exception {
    ResponseEntity result = controller.create(TEST_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    verifyZeroInteractions(service);
  }

  @Test
  public void getShouldRespondWithOKAndPaymentIfPaymentExists() throws Exception {
    when(service.get(TEST_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    ResponseEntity result = controller.get(TEST_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.OK));
  }

  @Test
  public void getShouldRespondWithNotFoundIfNoSuchPayment() throws Exception {
    when(service.get(TEST_ID)).thenReturn(Optional.empty());
    ResponseEntity result = controller.get(TEST_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void findByOrgIdShouldRespondWithOKAndMultiplePayments()  {
    // Create another payment with a different ID, but the same organisationId
    Payment secondOrgPayment = new Payment()
        .setId("7eb8277a-6c91-45e9-8a03-a27f82aca350")
        .setOrganisationId(TEST_ORG_ID);
    when(service.findByOrganisationId(TEST_ORG_ID))
        .thenReturn(asList(PAYMENT_WITH_ORG, secondOrgPayment));
    List<Payment> result = service.findByOrganisationId(TEST_ORG_ID);
    assertThat(result, containsInAnyOrder(PAYMENT_WITH_ORG, secondOrgPayment));
  }

  @Test
  public void findByOrgIdShouldReplyWithNotFoundIfNoSuchPayments() throws Exception {
    when(service.findByOrganisationId(TEST_ORG_ID)).thenReturn(emptyList());
    ResponseEntity<List<Payment>> result = controller.findByOrganisationId(TEST_ORG_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void replaceShouldRespondWithOkAndUpdatedPayment() throws Exception {
    when(service.replace(TEST_PAYMENT)).thenReturn(Optional.of(TEST_PAYMENT));
    ResponseEntity result = controller.replace(TEST_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.OK));
    assertThat(result.getBody(), equalTo(TEST_PAYMENT));
  }

  @Test
  public void replaceShouldRespondWithNotFoundIfNoSuchPayment() throws Exception {
    when(service.replace(TEST_PAYMENT)).thenReturn(Optional.empty());
    ResponseEntity result = controller.replace(TEST_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void deleteShouldRespondWithNoContentIfDeleteSuccessful() throws Exception {
    when(service.delete(TEST_ID)).thenReturn(true);
    ResponseEntity result = controller.delete(TEST_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NO_CONTENT));
  }

  @Test
  public void deleteShouldRespondWithNotFoundIfNoSuchPayment() throws Exception {
    when(service.delete(TEST_ID)).thenReturn(false);
    ResponseEntity result = controller.delete(TEST_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }
}

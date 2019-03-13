package com.form3.payments;

import com.form3.payments.controller.PaymentController;
import com.form3.payments.model.Payment;
import com.form3.payments.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

  @Mock
  private PaymentService service;

  @InjectMocks
  private PaymentController controller;

  private static final Payment TEST_PAYMENT_WITHOUT_ID = new Payment().setVersion(0);

  private static final String TEST_PAYMENT_ID = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
  private static final Payment TEST_PAYMENT = new Payment().setId(TEST_PAYMENT_ID);

  @Test
  public void createShouldReplyWithCreatedAndPayment() throws Exception {
    when(service.create(TEST_PAYMENT_WITHOUT_ID)).thenReturn(TEST_PAYMENT_WITHOUT_ID);
    ResponseEntity result = controller.create(TEST_PAYMENT_WITHOUT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.CREATED));
    assertThat(result.getBody(), equalTo(TEST_PAYMENT_WITHOUT_ID));
    verify(service).create(TEST_PAYMENT_WITHOUT_ID);
  }

  @Test
  public void createShouldReplyWithBadRequestIfIdIsPresent() throws Exception {
    ResponseEntity result = controller.create(TEST_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    verifyZeroInteractions(service);
  }

  @Test
  public void getShouldReplyWithNotFoundIfNoSuchPayment() throws Exception {
    when(service.get(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    ResponseEntity result = controller.get(TEST_PAYMENT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void getShouldReplyWithPaymentIfPaymentExists() throws Exception {
    when(service.get(TEST_PAYMENT_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    ResponseEntity result = controller.get(TEST_PAYMENT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.OK));
  }

  @Test
  public void replaceShouldReplyWithNotFoundIfPaymentDoesNotExist() throws Exception {
    when(service.replace(TEST_PAYMENT)).thenReturn(Optional.empty());
    ResponseEntity result = controller.replace(TEST_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void replaceShouldReplyWithUpdatedPaymentAndOkIfPaymentExists() throws Exception {
    when(service.replace(TEST_PAYMENT)).thenReturn(Optional.of(TEST_PAYMENT));
    ResponseEntity result = controller.replace(TEST_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.OK));
    assertThat(result.getBody(), equalTo(TEST_PAYMENT));
  }

  @Test
  public void deleteShouldRespondWithNotFoundIfPaymentDoesNotExist() throws Exception {
    when(service.delete(TEST_PAYMENT_ID)).thenReturn(false);
    ResponseEntity result = controller.delete(TEST_PAYMENT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void deleteShouldRespondWithNoContentIfDeleteSuccessful() throws Exception {
    when(service.delete(TEST_PAYMENT_ID)).thenReturn(true);
    ResponseEntity result = controller.delete(TEST_PAYMENT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NO_CONTENT));
  }
}

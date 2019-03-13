package com.form3.payments;

import com.form3.payments.controller.PaymentController;
import com.form3.payments.model.Payment;
import com.form3.payments.service.PaymentService;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;
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
    ResponseEntity<Payment> result = controller.create(TEST_PAYMENT_WITHOUT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.CREATED));
    assertThat(result.getBody(), equalTo(TEST_PAYMENT_WITHOUT_ID));
  }
/*
  @Test
  public void createShouldReplyWithConflictIfPaymentAlreadyExists() throws Exception {
    when(service.create(TEST_PAYMENT)).thenReturn(Optional.empty());
    ResponseEntity<Payment> result = controller.create(TEST_PAYMENT);
    assertThat(result.getStatusCode(), is(HttpStatus.CONFLICT));
  } */

  @Test
  public void readShouldReplyWithNotFoundIfNoSuchPayment() throws Exception {
    when(service.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    ResponseEntity<Payment> result = controller.read(TEST_PAYMENT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.NOT_FOUND));
  }

  @Test
  public void readShouldReplyWithPaymentIfPaymentExists() throws Exception {
    when(service.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    ResponseEntity<Payment> result = controller.read(TEST_PAYMENT_ID);
    assertThat(result.getStatusCode(), is(HttpStatus.OK));
  }

/*
  private Matcher<ResponseEntity> responseEntityWithStatus(HttpStatus status) {

    return new TypeSafeMatcher<ResponseEntity>() {

      @Override
      protected boolean matchesSafely(ResponseEntity item) {

        return status.equals(item.getStatusCode());
      }

      @Override
      public void describeTo(Description description) {

        description.appendText("ResponseEntity with status ").appendValue(status);
      }
    };
  }

  private <T> Matcher<ResponseEntity<? extends T>> responseEntityThat(Matcher<T> categoryMatcher) {

    return new TypeSafeMatcher<ResponseEntity<? extends T>>() {
      @Override
      protected boolean matchesSafely(ResponseEntity<? extends T> item) {

        return categoryMatcher.matches(item.getBody());
      }

      @Override
      public void describeTo(Description description) {

        description.appendText("ResponseEntity with ").appendValue(categoryMatcher);
      }
    };
  } */
}

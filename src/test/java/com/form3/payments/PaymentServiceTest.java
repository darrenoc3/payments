package com.form3.payments;

import com.form3.payments.model.Payment;
import com.form3.payments.repository.PaymentRepository;
import com.form3.payments.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

  @Mock
  private PaymentRepository repository;

  @InjectMocks
  private PaymentService service;

  private static final String TEST_PAYMENT_ID = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
  private static final Payment TEST_PAYMENT= new Payment().setId(TEST_PAYMENT_ID);

  // Same ID but with extra data, to test replace
  private static final String TEST_ORG_ID = "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb";
  private static final Payment TEST_PAYMENT_WITH_ORG = new Payment().setId(TEST_PAYMENT_ID)
      .setOrganisationId(TEST_ORG_ID);

  @Test
  public void readShouldReturnEmptyOptionalWhenNoPaymentFound() {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    Optional<Payment> result = service.get(TEST_PAYMENT_ID);
    assertThat(result, is(Optional.empty()));
    verify(repository).read(TEST_PAYMENT_ID);
  }

  @Test
  public void readShouldReturnResultWhenPaymentFound() {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    Payment result = service.get(TEST_PAYMENT_ID).get();
    verify(repository).read(TEST_PAYMENT_ID);
    assertThat(result, is(equalTo(TEST_PAYMENT)));
  }

  @Test
  public void createShouldReturnNewPayment() {
    Payment result = service.create(TEST_PAYMENT);
    assertThat(result, is(equalTo(TEST_PAYMENT)));
    verify(repository).save(TEST_PAYMENT);
  }

  @Test
  public void replaceShouldReturnEmptyOptionalWhenExistingPaymentNotFound() {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    Optional<Payment> result = service.replace(TEST_PAYMENT);
    assertThat(result, is(Optional.empty()));
    verify(repository, never()).save(TEST_PAYMENT);
  }

  @Test
  public void replaceShouldOverwriteAndReturnNewDataWhenPaymentExists() {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    Payment result = service.replace(TEST_PAYMENT_WITH_ORG).get();
    assertThat(result, is(equalTo(TEST_PAYMENT_WITH_ORG)));
    verify(repository).save(TEST_PAYMENT_WITH_ORG);
  }

  @Test
  public void deleteShouldReturnFalseWhenPaymentNotFound() {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    boolean result = service.delete(TEST_PAYMENT_ID);
    assertThat(result, is(false));
  }

  @Test
  public void deleteShouldReturnTrueWhenPaymentDeleted() {
    when(repository.read(TEST_PAYMENT_ID))
        .thenReturn(Optional.of(TEST_PAYMENT));
    boolean result = service.delete(TEST_PAYMENT_ID);
    assertThat(result, is(true));
    verify(repository).delete(TEST_PAYMENT_ID);
  }
/*
  @Test
  public void listShouldReturnEmptyListWhenNothingFound() throws Exception {

    when(repository.readAll()).thenReturn(emptyList());
    List<Payment> result = service.list();
    assertThat(result, is(emptyCollectionOf(Payment.class)));
  }

  @Test
  public void listShouldReturnAllPayments() throws Exception {

    Payment payment1 = new Payment().withName(TEST_PAYMENT_ID);
    Payment payment2 = new Payment().withName("Dale Carnegie");
    when(repository.readAll()).thenReturn(asList(payment1, payment2));
    List<Payment> result = service.list();
    assertThat(result, containsInAnyOrder(payment1, payment2));
  } */
}

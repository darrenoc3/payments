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
  private static final Payment TEST_PAYMENT = new Payment(TEST_PAYMENT_ID);
  // Same ID but with extra data, to test updates
  private static final Payment TEST_PAYMENT_MODIFIED = new Payment(TEST_PAYMENT_ID)
      .setOrganisationId("743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb");

  private static final String TEST_PAYMENT_ID_2 = "216d4da9-e59a-4cc6-8df3-3da6e7580b77";
  private static final Payment TEST_PAYMENT_2 = new Payment(TEST_PAYMENT_ID);

  @Test
  public void readShouldReturnEmptyOptionalWhenNoPaymentFound() throws Exception {
    PaymentModelTest data = new PaymentModelTest();
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    Optional<Payment> result = service.read(TEST_PAYMENT_ID);
    assertThat(result, is(Optional.empty()));
  }

  @Test
  public void readShouldReturnResultWhenPaymentFound() throws Exception {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    Payment result = service.read(TEST_PAYMENT_ID).get();
    assertThat(result, is(equalTo(TEST_PAYMENT)));
  }

  @Test
  public void createShouldReturnNewCustomerWhenPaymentDoesntExistYet() throws Exception {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    Payment result = service.create(TEST_PAYMENT).get();
    assertThat(result, is(equalTo(TEST_PAYMENT)));
    verify(repository).save(TEST_PAYMENT);
  }

  @Test
  public void createShouldReturnEmptyOptionalWhenPaymentAlreadyExists() throws Exception {
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    Optional<Payment> result = service.create(TEST_PAYMENT_MODIFIED);
    assertThat(result, is(Optional.empty()));
    verify(repository, never()).save(TEST_PAYMENT_MODIFIED);
  }

/*
  @Test
  public void replaceShouldReturnEmptyOptionalWhenPaymentNotFound() throws Exception {

    Payment newPaymentData = new Payment().withName(TEST_PAYMENT_ID).withAddress("Sri Lanka");
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    Optional<Payment> result = service.replace(newPaymentData);
    assertThat(result, is(Optional.empty()));
    verify(repository, never()).save(newPaymentData);
  }

  @Test
  public void replaceShouldOverwriteAndReturnNewDataWhenPaymentExists() throws Exception {

    Payment oldPaymentData = new Payment().withName(TEST_PAYMENT_ID).withPhoneNumber("000000");
    Payment newPaymentData = new Payment().withName(TEST_PAYMENT_ID).withAddress("Sri Lanka");
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(oldPaymentData));
    Payment result = service.replace(newPaymentData).get();
    assertThat(result, is(equalTo(newPaymentData)));
    verify(repository).save(newPaymentData);
  }

  @Test
  public void updateShouldReturnEmptyOptionalWhenPaymentNotFound() throws Exception {

    Payment newPaymentData = new Payment().withName(TEST_PAYMENT_ID).withAddress("Sri Lanka");
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    Optional<Payment> result = service.update(newPaymentData);
    assertThat(result, is(Optional.empty()));
    verify(repository, never()).save(newPaymentData);
  }

  @Test
  public void updateShouldOverwriteExistingFieldAndReturnNewDataWhenPaymentExists()
      throws Exception {

    Payment oldPaymentData = new Payment().withName(TEST_PAYMENT_ID).withAddress("England");
    Payment newPaymentData = new Payment().withName(TEST_PAYMENT_ID).withAddress("Sri Lanka");
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(oldPaymentData));
    Payment result = service.update(newPaymentData).get();
    assertThat(result, is(equalTo(newPaymentData)));
    verify(repository).save(newPaymentData);
  }

  @Test
  public void updateShouldNotOverwriteExistingFieldIfNoNewValuePassedAndShouldReturnNewDataWhenPaymentExists()
      throws Exception {

    Payment oldPaymentData = new Payment().withName(TEST_PAYMENT_ID).withAddress("England");
    Payment newPaymentData = new Payment().withName(TEST_PAYMENT_ID).withPhoneNumber("000000");
    Payment expectedResult = new Payment().withName(TEST_PAYMENT_ID).withAddress("England")
        .withPhoneNumber("000000");
    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.of(oldPaymentData));
    Payment result = service.update(newPaymentData).get();
    assertThat(result, is(equalTo(expectedResult)));
    verify(repository).save(expectedResult);
  }

  @Test
  public void deleteShouldReturnFalseWhenPaymentNotFound() throws Exception {

    when(repository.read(TEST_PAYMENT_ID)).thenReturn(Optional.empty());
    boolean result = service.delete(TEST_PAYMENT_ID);
    assertThat(result, is(false));
  }

  @Test
  public void deleteShouldReturnTrueWhenPaymentDeleted() throws Exception {

    when(repository.read(TEST_PAYMENT_ID))
        .thenReturn(Optional.of(new Payment().withName(TEST_PAYMENT_ID)));
    boolean result = service.delete(TEST_PAYMENT_ID);
    assertThat(result, is(true));
    verify(repository).delete(TEST_PAYMENT_ID);
  }

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

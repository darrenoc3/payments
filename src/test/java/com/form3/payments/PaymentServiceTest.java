package com.form3.payments;

import static com.form3.payments.TestData.TEST_ORG_ID;
import static com.form3.payments.TestData.TEST_PAYMENT;
import static com.form3.payments.TestData.TEST_ID;
import static com.form3.payments.TestData.PAYMENT_WITH_ORG;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.form3.payments.model.Payment;
import com.form3.payments.repository.PaymentRepository;
import com.form3.payments.service.PaymentService;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

  @Mock
  private PaymentRepository repository;

  @InjectMocks
  private PaymentService service;

  @Test
  public void createShouldReturnNewPayment() {
    Payment result = service.create(TEST_PAYMENT);
    assertThat(result, is(equalTo(TEST_PAYMENT)));
    verify(repository).save(TEST_PAYMENT);
  }

  @Test
  public void readShouldReturnResultWhenPaymentFound() {
    when(repository.read(TEST_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    Payment result = service.get(TEST_ID).get();
    verify(repository).read(TEST_ID);
    assertThat(result, is(equalTo(TEST_PAYMENT)));
  }

  @Test
  public void readShouldReturnEmptyOptionalWhenNoPaymentFound() {
    when(repository.read(TEST_ID)).thenReturn(Optional.empty());
    Optional<Payment> result = service.get(TEST_ID);
    assertThat(result, is(Optional.empty()));
    verify(repository).read(TEST_ID);
  }

  @Test
  public void findByOrgIdShouldReturnMultiplePayments() {
    // Create another payment with a different ID, but the same organisationId
    Payment secondOrgPayment = new Payment()
        .setId("7eb8277a-6c91-45e9-8a03-a27f82aca350")
        .setOrganisationId(TEST_ORG_ID);
    when(repository.readByOrganisationId(TEST_ORG_ID))
        .thenReturn(asList(PAYMENT_WITH_ORG, secondOrgPayment));
    List<Payment> result = service.findByOrganisationId(TEST_ORG_ID);
    assertThat(result, containsInAnyOrder(PAYMENT_WITH_ORG, secondOrgPayment));
  }

  @Test
  public void findByOrgIdShouldReturnEmptyListWhenNothingFound() {
    when(repository.readByOrganisationId(TEST_ORG_ID)).thenReturn(emptyList());
    List<Payment> result = service.findByOrganisationId(TEST_ORG_ID);
    assertThat(result, is(emptyCollectionOf(Payment.class)));
  }

  @Test
  public void replaceShouldOverwriteAndReturnNewDataWhenPaymentExists() {
    when(repository.read(TEST_ID)).thenReturn(Optional.of(TEST_PAYMENT));
    Payment result = service.replace(PAYMENT_WITH_ORG).get();
    assertThat(result, is(equalTo(PAYMENT_WITH_ORG)));
    verify(repository).save(PAYMENT_WITH_ORG);
  }

  @Test
  public void replaceShouldReturnEmptyOptionalWhenExistingPaymentNotFound() {
    when(repository.read(TEST_ID)).thenReturn(Optional.empty());
    Optional<Payment> result = service.replace(TEST_PAYMENT);
    assertThat(result, is(Optional.empty()));
    verify(repository, never()).save(TEST_PAYMENT);
  }

  @Test
  public void deleteShouldReturnTrueWhenPaymentDeleted() {
    when(repository.read(TEST_ID))
        .thenReturn(Optional.of(TEST_PAYMENT));
    boolean result = service.delete(TEST_ID);
    assertThat(result, is(true));
    verify(repository).delete(TEST_ID);
  }

  @Test
  public void deleteShouldReturnFalseWhenPaymentNotFound() {
    when(repository.read(TEST_ID)).thenReturn(Optional.empty());
    boolean result = service.delete(TEST_ID);
    assertThat(result, is(false));
  }
}

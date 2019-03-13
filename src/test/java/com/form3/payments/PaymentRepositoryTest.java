package com.form3.payments;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.form3.payments.model.Payment;
import com.form3.payments.repository.PaymentRepository;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentRepositoryTest {

  @Mock
  private DynamoDBMapper dbMapper;

  @InjectMocks
  private PaymentRepository repository;

  private static final String TEST_PAYMENT_ID = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
  private static final Payment TEST_PAYMENT = new Payment(TEST_PAYMENT_ID);

  @Test
  @SuppressWarnings("unchecked")
  public void readAllShouldScanTheTable() {
    PaginatedScanList expectedResult = mock(PaginatedScanList.class);
    when(dbMapper.scan(eq(Payment.class), any(DynamoDBScanExpression.class)))
        .thenReturn(expectedResult);
    List<Payment> result = repository.readAll();
    assertThat(result, is(expectedResult));
    verify(expectedResult).loadAllResults();
  }

  @Test
  public void readShouldReturnEmptyOptionalWhenNoResult() {
    when(dbMapper.load(Payment.class, TEST_PAYMENT_ID)).thenReturn(null);
    Optional<Payment> result = repository.read(TEST_PAYMENT_ID);
    assertThat(result, is(Optional.empty()));
  }

  @Test
  public void readShouldWrapResultIntoOptional() {
    when(dbMapper.load(Payment.class, TEST_PAYMENT_ID)).thenReturn(TEST_PAYMENT);
    Optional<Payment> result = repository.read(TEST_PAYMENT_ID);
    assert (result.isPresent());
    assertThat(result.get(), is(equalTo(TEST_PAYMENT)));
  }

  @Test
  public void saveShouldPersistPayment() {
    repository.save(TEST_PAYMENT);
    verify(dbMapper).save(TEST_PAYMENT);
  }

  @Test
  public void deleteShouldDeletePaymentById() {
    repository.delete(TEST_PAYMENT_ID);
    verify(dbMapper).delete(any(Payment.class));
  }
}

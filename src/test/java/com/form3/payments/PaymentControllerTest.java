package com.form3.payments;

import com.form3.payments.controller.PaymentController;
import com.form3.payments.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentControllerTest {

  @Mock
  private PaymentService service;

  @InjectMocks
  private PaymentController controller;

  @Test
  public void getPayment() throws Exception {
  }


  @Test
  public void getPayments() throws Exception {
    //Payment payment = new Payment();

    //List<Payment> payments = Collections.singletonList(payment);

    //BDDMockito.given(paymentController.getAllPayments()).willReturn(payments);

  }

}

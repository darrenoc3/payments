package com.form3.payments;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.form3.payments.controller.PaymentController;
import com.form3.payments.model.Payment;
import java.util.Collections;
import java.util.List;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private PaymentController paymentController;

  @Test
  public void getPayment() throws Exception {
  }


  @Test
  public void getPayments() throws Exception {
    Payment payment = new Payment();

    List<Payment> payments = Collections.singletonList(payment);

    BDDMockito.given(paymentController.getAllPayments()).willReturn(payments);

  }

}

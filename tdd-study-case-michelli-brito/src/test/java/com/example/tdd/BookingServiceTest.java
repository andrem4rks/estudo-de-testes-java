package com.example.tdd;

import com.example.tdd.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

public class BookingServiceTest {

  @Autowired
  BookingService bookingService;

  @Test
  public void bookingServiceDaysCalculator() {
    String name = "Mopa";
    int days = bookingService.daysCalculatorWithDatabase(name);

    Assertions.assertEquals(days, 10);
  }
}

package com.example.tdd.service;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

  @Autowired
  BookingRepository bookingRepository;


  public int daysCalculatorWithDatabase(String name) {
    Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);

    return 10;
  }
}

package com.example.tdd;

import com.example.tdd.model.BookingModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@AutoConfigureMockMvc
public class BookingControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void bookingTestGetAll() throws Exception {
    mockMvc.perform(get("/bookings"))
        .andExpect(status().isOk());
  }

  @Test
  public void bookingTestSave() throws Exception {
    LocalDate checkIn = LocalDate.parse("2020-11-10");
    LocalDate checkOut = LocalDate.parse("2020-11-20");

    BookingModel bookingModel = new BookingModel("1", "Mopa", checkIn, checkOut, 2);

    mockMvc.perform(post("/bookings"))
        .content
  }
}

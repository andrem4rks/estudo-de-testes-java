package com.marks.testsstudycasealgaworks.filmes.controller;

import com.marks.testsstudycasealgaworks.controller.FilmeController;
import com.marks.testsstudycasealgaworks.model.Filme;
import com.marks.testsstudycasealgaworks.service.FilmeService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;



@WebMvcTest
public class FilmeControllerTest {

  @Autowired
  private FilmeController filmeController;

  @MockBean
  private FilmeService filmeService;

  @BeforeEach
  public void setup() {
    standaloneSetup(this.filmeController);
  }

  @Test
  public void deveRetornarSucesso_QuandoBuscarFilme() {

    Mockito.when(this.filmeService.obterFilme(1L))
        .thenReturn(new Filme(1L, "O Poderoso Chefão", "Sem descrição"));

    given()
          .accept(ContentType.JSON)
        .when()
          .get("/filmes/{codigo}", 1L)
        .then()
          .statusCode(HttpStatus.OK.value());
  }

  @Test
  public void deveRetornarNaoEncontrado_QuandoBuscarFilme() {

    Mockito.when(this.filmeService.obterFilme(5L))
        .thenReturn(null);

    given()
          .accept(ContentType.JSON)
        .when()
          .get("/filmes/{codigo}", 5L)
        .then()
          .statusCode(HttpStatus.NOT_FOUND.value());
  }

  @Test
  public void deveRetornarBadRequest_QuandoBuscarFilme() {

    given()
          .accept(ContentType.JSON)
        .when()
          .get("/filmes/{codigo}", -1L)
        .then()
          .statusCode(HttpStatus.BAD_REQUEST.value());

    Mockito.verify(this.filmeService, Mockito.never()).obterFilme(-1L);
  }
}

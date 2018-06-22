package com.softexpert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebTestClient(timeout = "36000")
public class QuoteControllerTest {

//	@Autowired
	private WebTestClient webTestClient;

	//@Test
	public void testQuotes() {
		webTestClient
				.get().uri("/quotes/aapl")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Quote.class).consumeWith(quote -> System.out.println("New quote: " + quote.getResponseBody().getPrice()));
	}

}

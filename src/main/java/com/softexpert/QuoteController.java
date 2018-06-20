package com.softexpert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class QuoteController {

	Duration pushInterval = Duration.ofSeconds(1);

	private List<Quote> quotes = Arrays.asList(
            new Quote("VMW", 215.35),
            new Quote("GOOG", 309.17),
            new Quote("CTXS", 112.11),
            new Quote("DELL", 92.23),
            new Quote("MSFT", 75.19),
            new Quote("ORCL", 115.72),
            new Quote("RHT", 111.19)
    );

	@GetMapping("/quotes")
	Flux<Quote> list() {
		return Flux.interval(pushInterval)
				.map(index -> {
                    return quotes.get(index.intValue() % quotes.size());
                })
				.log();
	}

}

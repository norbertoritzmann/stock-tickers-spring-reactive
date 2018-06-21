package com.softexpert;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class QuoteController {

	Duration pushInterval = Duration.ofSeconds(1);

	@GetMapping("/quotes/{symbol}")
	Flux<Quote> subscribe(@PathVariable("symbol") String symbol) {
		return Flux.interval(pushInterval)
				.map(index -> this.next(symbol))
				.log();
	}
	
	@GetMapping("/quotes/emitter/{symbol}")
	Flux<Quote> emitterSubscription(@PathVariable("symbol") String symbol) {
		return Flux.interval(pushInterval)
				.map(index -> this.next(symbol))
				.log();
	}

	Quote next(String symbol) {
		return new Quote(symbol, ThreadLocalRandom.current().nextDouble());
	}
}

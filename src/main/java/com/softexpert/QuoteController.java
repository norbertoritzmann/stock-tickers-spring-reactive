package com.softexpert;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

	Duration pushInterval = Duration.ofSeconds(1);

	@RequestMapping(path = "/{symbol}", method = RequestMethod.GET)
	Flux<Quote> subscribe(@PathVariable("symbol") String symbol) {
		return Flux.interval(pushInterval)
				.map(index -> this.next(symbol))
				.log();
	}
	
	@RequestMapping(path = "/quotes/emitter/{symbol}")
	Flux<Quote> emitterSubscription(@PathVariable("symbol") String symbol) {
		return Flux.interval(pushInterval)
				.map(index -> this.next(symbol))
				.log();
	}

	private Quote next(String symbol) {
		return new Quote(symbol, ThreadLocalRandom.current().nextDouble());
	}
}

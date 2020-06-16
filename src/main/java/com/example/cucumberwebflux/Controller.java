package com.example.cucumberwebflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/controller")
public class Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        LOG.info("Application is ready to handle requests");
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<Location> stream() {
        return Flux.just(new Location(13.4, 12.6), new Location(16.8, 20.0),
                new Location(21.2, 22.1));
    }
}

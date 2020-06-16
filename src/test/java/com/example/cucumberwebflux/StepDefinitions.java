package com.example.cucumberwebflux;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepDefinitions extends SpringContextDefinition {

    private final WebTestClient webTestClient;
    private WebTestClient.ResponseSpec responseSpec;

    StepDefinitions(WebTestClient webTestClient) {
        this.webTestClient = webTestClient;
    }

    @After
    public void cleanup() {
        responseSpec = null;
    }

    @When("I query stream")
    public void iQueryStream() {
        responseSpec = webTestClient.get().uri("/api/controller/stream").exchange();
    }

    @Then("I obtain {int} elements")
    public void iObtainElements(int count) {
        Flux<Location> responseBody = responseSpec
                .expectStatus()
                .is2xxSuccessful()
                .returnResult(Location.class)
                .getResponseBody();

        StepVerifier.create(responseBody).expectNextCount(count).expectComplete().verify();
    }
}

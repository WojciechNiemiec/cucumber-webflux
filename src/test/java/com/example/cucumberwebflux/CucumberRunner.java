package com.example.cucumberwebflux;

import io.cucumber.junit.platform.engine.Cucumber;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;

@Cucumber
@AutoConfigureWebClient
@SpringBootTest(classes = CucumberWebfluxApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberRunner {
}

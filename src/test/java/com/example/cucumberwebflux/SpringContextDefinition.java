package com.example.cucumberwebflux;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureWebTestClient
@SpringBootTest(classes = CucumberWebfluxApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringContextDefinition {
}

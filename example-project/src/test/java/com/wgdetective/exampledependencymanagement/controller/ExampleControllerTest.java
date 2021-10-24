package com.wgdetective.exampledependencymanagement.controller;

import java.util.Objects;

import com.wgdetective.exampledependencymanagement.ExampleDependencyManagementApplication;
import com.wgdetective.exampledependencymanagement.dto.ExampleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
        classes = {
                ExampleDependencyManagementApplication.class,
                ExampleController.class
        })
class ExampleControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testExample() {
        final var result = webTestClient.get()
                .uri("/example")
                .exchange()
                .expectBody(ExampleDto.class)
                .returnResult();
        assertThat(Objects.requireNonNull(result.getResponseBody()).getMessage())
                .isEqualTo("Hello Brave New World");
    }
}

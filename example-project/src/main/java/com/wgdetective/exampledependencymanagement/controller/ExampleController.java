package com.wgdetective.exampledependencymanagement.controller;

import java.util.UUID;

import com.wgdetective.exampledependencymanagement.dto.ExampleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ExampleController {

    @GetMapping("/example")
    public Mono<ExampleDto> example() {
        final var data = ExampleDto.builder()
                .id(UUID.randomUUID())
                .message("Hello Brave New World")
                .build();
        return Mono.just(data);
    }
}

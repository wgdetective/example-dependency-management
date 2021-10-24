package com.wgdetective.exampledependencymanagement.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExampleDto {
    private UUID id;
    private String message;
}

package com.wgdetective.exampledependencymanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExampleDependencyManagementApplication

fun main(args: Array<String>) {
    runApplication<ExampleDependencyManagementApplication>(*args)
}

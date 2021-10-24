import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply(from = "${rootProject.projectDir}/repositories.gradle.kts")

plugins {
//    id("root-plugin") version  "0.0.1-SNAPSHOT"
//  Moved to root-plugin
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.asciidoctor.convert") version "1.5.8"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
}

//rootPluginConfiguration {
//    orgSpringframeworkBoot = true
//    ioSpringDependencyManagement = true
//    orgAsciidoctorConvert = true
//}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

// BOM - v1
configure<DependencyManagementExtension> {
    imports {
        mavenBom("com.wgdetective.exampledependencymanagement:root-bom:0.0.1-SNAPSHOT")
    }
}

val snippetsDir by extra { file("build/generated-snippets") }

dependencies {
    // BOM - v2
    //api(platform(project(":root-bom")))

    // BOM - v3
    // api(platform("com.wgdetective.exampledependencymanagement:root-bom:0.0.1-SNAPSHOT"))


    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // Dependency version from bom
    implementation("it.unimi.dsi:fastutil")

    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    outputs.dir(snippetsDir)
}

tasks.asciidoctor {
    inputs.dir(snippetsDir)
    dependsOn(tasks.test)
}

plugins {
    `java-gradle-plugin`
    kotlin("jvm") version "1.5.31"
    `maven-publish`
}

apply(from = "${rootProject.projectDir}/repositories.gradle.kts")

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

gradlePlugin {
    plugins {
        create("simplePlugin") {
            id = "root-plugin"
            implementationClass = "com.wgdetective.exampledependencymanagement.plugin.RootPlugin"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["kotlin"])
        }
    }
}


plugins {
    `java-platform`
    `maven-publish`
}

apply(from = "${rootProject.projectDir}/repositories.gradle.kts")

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("it.unimi.dsi:fastutil:8.5.6")
    }
}

publishing {
    publications {
        create<MavenPublication>("wgdetectiveBomPlatform") {
            from(components["javaPlatform"])
        }
    }
}


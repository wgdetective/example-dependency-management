package com.wgdetective.exampledependencymanagement.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

open class RootPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.configurePlugins()
    }
}

internal fun Project.configurePlugins() {
    val rootPluginConfiguration: RootPluginConfiguration = extensions.create(
        "rootPluginConfiguration", RootPluginConfiguration::class.java
    )

    if (rootPluginConfiguration.orgSpringframeworkBoot) {
        plugins.apply("org.springframework.boot:2.5.6")
    }
    if (rootPluginConfiguration.ioSpringDependencyManagement) {
        plugins.apply("io.spring.dependency-management:1.0.11.RELEASE")
    }
    if (rootPluginConfiguration.orgAsciidoctorConvert) {
        plugins.apply("org.asciidoctor.convert:1.5.8")
    }
}

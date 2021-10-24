rootProject.name = "example-dependency-management"

pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

include("root-bom")
include("root-plugin")
include("example-project")



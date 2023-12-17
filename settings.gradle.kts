plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "OctopusRider"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("openai-client", "com.aallam.openai:openai-client:3.6.1")
            library("coroutines", "org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.7.2")
//            library("ktor-core", "io.ktor:ktor-client-core:2.3.7")
//            library("ktor-cio", "io.ktor:ktor-client-cio:2.3.7")
            library("slf4j-api", "org.slf4j:slf4j-api:1.7.35")
            library("slf4j-simple", "org.slf4j:slf4j-simple:1.7.35")
        }
    }
}



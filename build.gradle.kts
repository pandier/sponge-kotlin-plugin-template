import org.spongepowered.gradle.plugin.config.PluginLoaders
import org.spongepowered.plugin.metadata.model.PluginDependency

plugins {
    `java-library`
    kotlin("jvm") version "2.1.20"
    id("org.spongepowered.gradle.plugin") version "2.2.0"
    id("com.gradleup.shadow") version "8.3.6"
}

repositories {
    mavenCentral()
}

sponge {
    apiVersion("15.0.0-SNAPSHOT")
    license("MIT")
    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version("1.0")
    }
    plugin("example") {
        entrypoint("com.example.ExamplePlugin")
        description("This is an example plugin")
        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}

kotlin {
    jvmToolchain(21)
}

configurations.spongeRuntime {
    resolutionStrategy {
        eachDependency {
            if (target.name == "spongevanilla") {
                useVersion("1.21.5-15.0.0+")
            }
        }
    }
}

tasks.assemble {
    dependsOn(tasks.shadowJar)
}

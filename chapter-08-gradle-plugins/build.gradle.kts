plugins {
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.diffplug.spotless") version "7.0.2"
}

group = "com.example"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.example.App"
}

repositories {
    mavenLocal()
    maven {
        url = uri("http://nexus:8081/repository/maven-public/")
        isAllowInsecureProtocol = true
    }
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.shadowJar {
    archiveClassifier = "all"
}

tasks.named("assemble") {
    dependsOn(tasks.shadowJar)
}

spotless {
    java {
        googleJavaFormat()
    }
}

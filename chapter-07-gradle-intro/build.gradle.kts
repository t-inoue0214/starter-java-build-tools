plugins {
    java
    `maven-publish`
}

group = "com.example"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "com.example.App",
            "Class-Path" to configurations.runtimeClasspath.get()
                .joinToString(" ") { "lib/${it.name}" }
        )
    }
}

tasks.register<Zip>("createZip") {
    archiveFileName = "${project.name}-${project.version}.zip"
    destinationDirectory = layout.buildDirectory

    from(tasks.jar.get().archiveFile)
    from("src/main/resources/config.json")

    into("lib") {
        from(configurations.runtimeClasspath)
    }
}

tasks.named("assemble") {
    dependsOn("createZip")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = project.name
            from(components["java"])
            artifact(tasks.named<Zip>("createZip")) {
                extension = "zip"
            }
        }
    }

    repositories {
        maven {
            name = "NexusReleases"
            url = uri("http://nexus:8081/repository/maven-releases/")
            isAllowInsecureProtocol = true
            credentials {
                username = project.findProperty("nexusUsername") as String? ?: ""
                password = project.findProperty("nexusPassword") as String? ?: ""
            }
        }
        maven {
            name = "NexusSnapshots"
            url = uri("http://nexus:8081/repository/maven-snapshots/")
            isAllowInsecureProtocol = true
            credentials {
                username = project.findProperty("nexusUsername") as String? ?: ""
                password = project.findProperty("nexusPassword") as String? ?: ""
            }
        }
    }
}

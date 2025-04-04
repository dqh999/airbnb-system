plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.aribnb"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/dqh999/library-spring-boot")
        credentials {
            username = project.findProperty("user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("key") as String? ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation("org.axonframework:axon:4.11.1")
    implementation("com.dqhdev:global-error-handler:0.0.1-SNAPSHOT")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

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
	runtimeOnly("org.postgresql:postgresql")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.4")
	implementation("org.axonframework:axon-spring-boot-starter:4.11.1")
	implementation("com.dqhdev:global-error-handler:0.0.1-SNAPSHOT")
	compileOnly("org.projectlombok:lombok:1.18.38")
	annotationProcessor("org.projectlombok:lombok:1.18.38")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

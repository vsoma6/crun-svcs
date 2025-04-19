plugins {
    java
    id("org.springframework.boot") version "2.4.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

springBoot {
    mainClass.set("demo.RatingsDemoApplication")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation ("org.springframework.boot:spring-boot-starter-actuator")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.flywaydb:flyway-core")
    compileOnly ("org.projectlombok:lombok")
    runtimeOnly ("org.postgresql:postgresql")
    annotationProcessor ("org.projectlombok:lombok")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

plugins {
    java
    war
    id("org.springframework.boot") version "3.2.0-SNAPSHOT" apply false
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

dependencies {
    //implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

allprojects {
    apply {
        plugin("java")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
    }

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
}

subprojects {
    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

project(":multi1") {
    apply {
        plugin("war")
    }

    dependencies {
        implementation(project(":common"))

        implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")

        providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    }
}

project(":multi2") {
    apply {
        plugin("war")
    }

    dependencies {
        implementation(project(":common"))

        implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")

        providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    }
}
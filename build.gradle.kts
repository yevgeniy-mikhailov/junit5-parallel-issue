plugins {
    kotlin("jvm") version "1.5.10"
    java
    id("io.qameta.allure") version "2.9.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

allure {
    report {
        version.set("2.16.0")
    }
    adapter {
        allureJavaVersion.set("2.16.0")
        aspectjVersion.set("1.9.7")
        //categoriesFile.set(layout.projectDirectory.file("config/allure/categories.json"))
        frameworks {
            junit5 {
                enabled.set(true)
                autoconfigureListeners.set(true)
            }
        }
    }
    commandline {
        downloadUrlPattern.set("https://host/repository/maven-public/io/qameta/allure/allure-commandline/[version]/[module]-[version].zip")
        group.set("io.qameta.allure")
        module.set("allure-commandline")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("com.codeborne:selenide:6.1.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform {
        filter {
            includeTags("UI")
        }
    }
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.mode.default", "same_thread")
    systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "concurrent")
    systemProperty("junit.jupiter.execution.parallel.config.fixed.parallelism", "5")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "fixed")
}
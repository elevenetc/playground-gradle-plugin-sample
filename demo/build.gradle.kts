buildscript {
    repositories {
        maven {
            url = uri("../repo")
        }
    }

    dependencies {
        classpath("com.elevenetc.playground.gradle.plugin:playgroundPlugin:1.0.0")
    }
}

plugins {
    kotlin("jvm") version "1.3.71"
}

group = "com.elevenetc.playground.gradle.plugin.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}
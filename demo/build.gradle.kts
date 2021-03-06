plugins {
    kotlin("jvm") version "1.3.71"
    id("playground") version "1.0.0"
}

group = "com.abc.demo"
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

playground {
    enabled = true
    someString = "xxx"
}
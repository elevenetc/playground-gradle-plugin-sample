plugins {
    kotlin("jvm") version "1.3.71"
    id("java-gradle-plugin")
    //id("maven")
    //id("maven-publish")
    `maven-publish`
    `maven`
}

group = "com.elevenetc.playground.gradle.plugin"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

gradlePlugin {
    plugins {
        create("playgroundPlugin") {
            id = "com.elevenetc.playground.gradle.plugin"
            implementationClass = "com.elevenetc.playground.gradle.plugin.PlaygroundPlugin"
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    //classifier = "sources"
    from(sourceSets.main.get().allSource)
}

publishing {
    repositories {
        maven {
            // change to point to your repo, e.g. http://my.org/repo
            url = uri("./repo")
        }
    }
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["kotlin"])
            artifact(sourcesJar.get())
        }
    }
}


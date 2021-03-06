plugins {
    kotlin("jvm") version "1.3.71"
    id("java-gradle-plugin")
    `maven-publish`

}

group = "com.abc"
version = "1.0.0"

repositories {
    mavenCentral()
    google()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.android.tools.build", "gradle", "4.0.0")
    implementation("androidx.test", "rules", "1.2.0", ext = "aar")
    //implementation("com.google.guava", "guava", "29.0-jre")
}

gradlePlugin {
    plugins {
        create("playground") {
            id = "playground"
            implementationClass = "com.abc.Playground"
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
    from(sourceSets.main.get().allSource)
}

publishing {
    repositories {
        maven {
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


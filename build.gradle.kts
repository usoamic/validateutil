import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    maven
    kotlin("jvm") version "1.3.50"
    kotlin("kapt") version "1.3.50"
}

allprojects {
    group = "io.usoamic"
    version = "1.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.jetbrains.kotlin", "kotlin-stdlib", "1.3.50")
    compile("org.web3j", "core", "4.3.1")
    testCompile("org.jetbrains.kotlin", "kotlin-test-junit5", "1.3.50")
    testCompile("org.junit.jupiter", "junit-jupiter", "5.5.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }
}
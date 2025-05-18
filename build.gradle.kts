plugins {
    kotlin("jvm") version "2.1.20"
}

group = "xyz.mon0mon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val kotlinVersion = "1.10.2"
val jUnitVersion = "5.12.2"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testImplementation("org.assertj:assertj-core:3.27.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinVersion")
    testImplementation("io.mockk:mockk:1.14.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

/**
 * Coroutine optimised out solver
 * [link](https://youtrack.jetbrains.com/issue/KT-48678/Coroutine-debugger-disable-was-optimised-out-compiler-feature#focus=Comments-27-9812231.0-0)
 */
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.freeCompilerArgs += "-Xdebug"
}

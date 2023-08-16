plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    implementation("org.jetbrains.kotlin.kapt:org.jetbrains.kotlin.kapt.gradle.plugin:1.9.0")
    implementation("org.jetbrains.kotlin.plugin.jpa:org.jetbrains.kotlin.plugin.jpa.gradle.plugin:1.9.0")
    implementation("org.jetbrains.kotlin.plugin.spring:org.jetbrains.kotlin.plugin.spring.gradle.plugin:1.9.0")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.1.2")
    implementation("io.spring.dependency-management:io.spring.dependency-management.gradle.plugin:1.1.3")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:11.5.1")
}
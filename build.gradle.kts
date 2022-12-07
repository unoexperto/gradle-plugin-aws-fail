object Versions {
    val java = JavaVersion.VERSION_17

    const val kotlin = "1.7.22"

    const val awsSdk = "2.18.28" // https://mvnrepository.com/artifact/software.amazon.awssdk/aws-crt-client
}

plugins {
    kotlin("jvm") version "1.7.22"
    application
    idea

    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("maven-publish")
    id("ru.tutu.dependencies2files") version "0.3.0"
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

dependencies {

    implementation(kotlin("stdlib", Versions.kotlin))

    implementation("io.projectreactor.netty:reactor-netty-core:1.1.0")
    implementation("io.vertx:vertx-core:4.3.5")

    implementation("software.amazon.awssdk:aws-crt-client:${Versions.awsSdk}-PREVIEW")
    implementation("software.amazon.awssdk:s3:${Versions.awsSdk}") //{ exclude("software.amazon.awssdk", "apache-client") }

    testImplementation(kotlin("test-junit5", Versions.kotlin))
}

repositories {

    mavenLocal()
//    dependenciesToFiles.addRepository(this) {
//        saveMavenCentral()
//    }
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

tasks {

    dependenciesToFiles {
        saveDependenciesDir = "/home/${System.getProperty("user.name")}/.m2/repository/"
        offlineMode = false // you may check dependencies availability with offline toggle
    }
}


import com.android.build.api.dsl.androidLibrary
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.johnylie"
version = "1.0.2"

kotlin {
    jvm()
    androidLibrary {
        namespace = "io.github.johnylie.kotlin_greeting"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withJava() // enable java compilation support
        withHostTestBuilder {}.configure {}
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }

        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(
                    JvmTarget.JVM_11
                )
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(
        groupId = group.toString(),
        artifactId = "kotlin-greeting",
        version = version.toString()
    )

    pom {
        name = "kotlin-greeting"
        description = "A kotlin greeting library."
        inceptionYear = "2025"
        url = "https://github.com/johnylie/kotlin-greeting/"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "johnylie"
                name = "Johny Lie"
                url = "https://github.com/johnylie/"
            }
        }
        scm {
            url = "https://github.com/johnylie/kotlin-greeting/"
            connection = "scm:git:git://github.com/johnylie/kotlin-greeting.git"
            developerConnection = "scm:git:ssh://git@github.com/johnylie/kotlin-greeting.git"
        }
    }
}

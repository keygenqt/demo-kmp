import org.jetbrains.kotlin.cli.jvm.main

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
}

group = "my.company.name"
version = "1.0"

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    js(IR) {
        moduleName = "shared"
        binaries.executable()
        browser()
        binaries.library()
        nodejs()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.core)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.negotiation)
            implementation(libs.ktor.coroutines)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        jsMain.dependencies {
            implementation(npm("uuid", "9.0.0"))
            implementation(libs.ktor.client.js)
        }
    }
}

android {
    namespace = "my.company.name"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}

tasks.register("androidBuildLib") {
    dependsOn("bundleReleaseAar")
    doLast {
        copy {
            from(layout.buildDirectory.dir("outputs/aar/shared-release.aar"))
            into("${rootProject.rootDir}/../androidApp/app/libs")
        }
    }
}

tasks.register("jsBuildForAurora") {
    dependsOn("jsBrowserProductionWebpack")
    doLast {
        copy {
            from(layout.buildDirectory.dir("dist/js/productionExecutable"))
            into("${rootProject.rootDir}/../auroraApp/demo/qml/kmp")
        }
    }
}

tasks.register("jsBuildLibForReact") {
    dependsOn("jsNodeProductionLibraryDistribution")
    doLast {
        copy {
            from(layout.buildDirectory.dir("dist/js/productionLibrary"))
            into("${rootProject.rootDir}/../webApp/kmp/shared")
        }
    }
}

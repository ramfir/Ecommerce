plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    `android-config`
}

android {
    defaultConfig {
        applicationId = "com.firdavs.ecommerce"
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    // ===== compose =====
    buildFeatures.compose = true
    composeOptions {
        kotlinCompilerExtensionVersion = versions.composeCompiler
    }
}

dependencies {
    // ===== android =====
    implementation(libs.android)

    // ===== compose =====
    implementation(libs.compose)

    // ===== test =====
    testImplementation(libs.unitTests)
    androidTestImplementation(libs.androidTests)

    // ===== debug =====
    debugImplementation(libs.debug)
}
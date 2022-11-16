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
    implementation(project(":main:impl"))
    implementation(project(":product-details:impl"))
    implementation(project(":cart:impl"))
    implementation(project(":data:impl"))
    implementation(project(":common"))

    // ===== android =====
    implementation(libs.android)

    // ===== compose =====
    implementation(libs.compose)

    // ===== dagger =====
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)

    // ===== test =====
    testImplementation(libs.unitTests)
    androidTestImplementation(libs.androidTests)

    // ===== debug =====
    debugImplementation(libs.debug)
}
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    // Precompiled plugin with the base android configuration.
    // Declared in buildSrc/.../android-config.gradle.kts.
    `android-config`
}

android {
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

    // ===== dagger =====
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)
}
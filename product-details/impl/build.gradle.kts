plugins {
    id("com.android.library")
    id("kotlin-android")
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
    api(project(":product-details:api"))
    implementation(project(":data:api"))
    implementation(project(":common"))

    // ===== android =====
    implementation(libs.android)

    // ===== compose =====
    implementation(libs.compose)

    // ===== kotlin =====
    implementation(libs.coroutines)

    // ===== accompanist pager =====
    implementation(libs.accompanistPager)

    // ===== dagger =====
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)

    // ===== debug =====
    debugImplementation(libs.debug)
}
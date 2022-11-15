import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("com.google.devtools.ksp")
    // Precompiled plugin with the base android configuration.
    // Declared in buildSrc/.../android-config.gradle.kts.
    `android-config`
}

android {
    defaultConfig {
        // Getting The Movie DB API key from local.properties
        val tmdbApiKey = gradleLocalProperties(rootDir).getProperty("tmdb_api_key")
        buildConfigField("String", "TMDB_API_KEY", "\"$tmdbApiKey\"")
    }
}

dependencies {
    api(project(":data:api"))
    implementation(project(":common"))

    // ===== android =====
    implementation(libs.android)

    // ===== kotlin =====
    implementation(libs.coroutines)

    // ===== dagger =====
    implementation(libs.dagger)
    kapt(libs.daggerCompiler)

    // ===== retrofit =====
    implementation(libs.retrofit)
}
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.kps)
}

android {
    namespace = "com.books.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:firebase"))

    implementation(libs.hilt.core)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.android)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.json)
}
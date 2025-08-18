plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)

}

android {
    namespace = "com.example.favourite_ui"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk =  libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion( libs.versions.jvmTarget.get())
        targetCompatibility = JavaVersion.toVersion( libs.versions.jvmTarget.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api(project(":core_ui"))
    implementation(project(":feature_favourite:favourite_domain"))
    implementation(project(":feature_favourite:favourite_data"))
    implementation(project(":feature_home:home_ui"))
    implementation(project(":feature_home:home_domain"))
    implementation("com.google.accompanist:accompanist-navigation-animation:0.36.0")
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)


}
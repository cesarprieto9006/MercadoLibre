import com.example.buildsrc.Libs

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.junit)
    implementation(Libs.testCore)
    implementation(Libs.core)
    implementation(Libs.coroutines)
    implementation(Libs.core)
    implementation(Libs.android)
    kapt(Libs.hiltCompiler)
    androidTestImplementation(Libs.hiltTesting)
    kaptAndroidTest(Libs.hiltTesting)
    implementation(Libs.loginInterceptor)
    implementation(Libs.mockWebServer)
    implementation(Libs.retrofit)
    implementation(Libs.converterGson)
    implementation (Libs.timber)

}
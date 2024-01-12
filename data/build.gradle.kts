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

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.material)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.Test.Ext.junit)
    implementation(Libs.AndroidX.Test.Espresso.testCore)
    implementation(Libs.Arrow.core)
    implementation(Libs.Arrow.coroutines)
    implementation(Libs.Arrow.core)
    implementation(Libs.Hilt.android)
    kapt(Libs.Hilt.hiltCompiler)
    androidTestImplementation(Libs.Hilt.hiltTesting)
    kaptAndroidTest(Libs.Hilt.hiltTesting)
    implementation(Libs.OkHttp3.loginInterceptor)
    implementation(Libs.OkHttp3.mockWebServer)
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.converterGson)
    implementation (Libs.Timber.timber)

}
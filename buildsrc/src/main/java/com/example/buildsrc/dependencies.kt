package com.example.buildsrc

object Libs {

    private const val versionJunit = "1.1.5"
    private const val versionTestCore = "3.5.1"
    private const val versionNavigation = "2.7.6"
    private const val versionJUnit = "4.13.2"
    private const val versionHilt = "2.48.1"
    private const val versionArrow = "1.0.1"
    private const val versionInterceptor = "4.9.3"
    private const val versionTimber = "5.0.1"
    private const val versionRetrofit = "2.9.0"

    const val coreKtx = "androidx.core:core-ktx:1.12.0"
    const val appCompat = "androidx.appcompat:appcompat:1.6.1"
    const val material = "com.google.android.material:material:1.11.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val junit = "androidx.test.ext:junit-ktx:$versionJunit"
    const val testCore = "androidx.test.espresso:espresso-core:$versionTestCore"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$versionNavigation"
    const val junitJ = "junit:junit:$versionJUnit"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$versionNavigation"
    const val android = "com.google.dagger:hilt-android:$versionHilt"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$versionHilt"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:$versionHilt"
    const val inject = "javax.inject:javax.inject:1"
    const val splashScreen = "androidx.core:core-splashscreen:1.0.1"
    const val core = "io.arrow-kt:arrow-core:$versionArrow"
    const val coroutines = "io.arrow-kt:arrow-fx-coroutines:$versionArrow"
    const val retrofitArrow = "io.arrow-kt:arrow-core-retrofit:$versionArrow"
    const val retrofit = "com.squareup.retrofit2:retrofit:$versionRetrofit"
    const val converterGson = "com.squareup.retrofit2:converter-gson:$versionRetrofit"
    const val timber = "com.jakewharton.timber:timber:$versionTimber"
    const val loginInterceptor = "com.squareup.okhttp3:logging-interceptor:$versionInterceptor"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$versionInterceptor"
    const val coil = "io.coil-kt:coil:2.5.0"

}
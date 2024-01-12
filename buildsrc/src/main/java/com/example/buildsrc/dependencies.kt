package com.example.buildsrc

object Libs {

    object AndroidX {

        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.11.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"

        object Test {
            object Ext {
                private const val version = "1.1.5"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            object Espresso {
                private const val version = "3.5.1"
                const val testCore = "androidx.test.espresso:espresso-core:$version"
            }
        }

        object Navigation {
            private const val version = "2.7.6"
            const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val navigationUi = "androidx.navigation:navigation-ui-ktx:$version"
        }

    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object Hilt {
        private const val version = "2.48.1"
        const val android = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltTesting = "com.google.dagger:hilt-android-testing:$version"
    }

    object JavaX {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Splash {
        const val splashScreen = "androidx.core:core-splashscreen:1.0.1"
    }

    object Arrow {
        private const val version = "1.0.1"
        const val core = "io.arrow-kt:arrow-core:$version"
        const val coroutines = "io.arrow-kt:arrow-fx-coroutines:$version"
        const val retrofit = "io.arrow-kt:arrow-core-retrofit:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Timber {
        private const val version = "5.0.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }

    object OkHttp3 {
        private const val version = "4.9.3"
        const val loginInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
    }

    object Coil {
        const val coil = "io.coil-kt:coil:2.5.0"
    }

}
package com.example.mercadolibre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startAnimationSplash()
        setContentView(R.layout.activity_main)
    }

    private fun startAnimationSplash() {
        runBlocking {
            installSplashScreen()
            delay(2000)
        }
    }
}
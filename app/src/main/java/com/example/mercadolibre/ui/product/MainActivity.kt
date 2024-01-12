package com.example.mercadolibre.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mercadolibre.R
import com.example.mercadolibre.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

const val TIME_ANIMATION =2000L

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navHost: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startAnimationSplash()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureBundle()
        configureNavigationController()
    }

    private fun startAnimationSplash() {
        runBlocking {
            installSplashScreen()
            delay(TIME_ANIMATION)
        }
    }

    private fun configureBundle() {
        val bundle = Bundle()
        Bundle().apply {
            (supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment)
                .navController.setGraph(
                    R.navigation.nav_main,
                bundle
            )
        }
    }

    private fun configureNavigationController() {
        navHost = supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        navController = navHost.navController
    }
}
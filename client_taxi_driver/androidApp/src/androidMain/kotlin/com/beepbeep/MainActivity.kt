package com.beepbeep

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import org.koin.android.ext.android.inject
import dev.icerock.moko.geo.LocationTracker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val locationTracker by inject<LocationTracker>()
        locationTracker.bind(lifecycle, this, supportFragmentManager)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
            this.window.navigationBarColor =
                ContextCompat.getColor(this, android.R.color.transparent)
            MainView()
        }
    }
}

package com.thoren.manganimu

import ManganimuTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.thoren.manganimu.ui.ManganimuApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()
            WindowCompat.setDecorFitsSystemWindows(window, false)
            ManganimuTheme {
                ManganimuApp()
            }
        }
    }
}
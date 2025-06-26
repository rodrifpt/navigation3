package com.cox.navigation3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.cox.navigation3.ui.nav.DestinationRoute
import com.cox.navigation3.ui.nav.NavigationLogin
import com.cox.navigation3.ui.theme.Navigation3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3Theme {
               NavigationLogin(DestinationRoute.Login)
            }
        }
    }
}

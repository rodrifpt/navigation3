package com.cox.navigation3.ui.nav

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.cox.navigation3.ui.nav.DestinationRoute.PlansDetails
import com.cox.navigation3.ui.screens.DashboardScreen
import com.cox.navigation3.ui.screens.FloorPlansScreen
import com.cox.navigation3.ui.screens.MoreScreen
import com.cox.navigation3.ui.screens.ValuationScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomMenuNavigation() {

    fun isTopLevel(entry: Any): Boolean {
        return entry is TopLevelRoute
    }

    val topLevelBackStack = remember { TopLevelBackStack<Any>(Dashboard) }

    val currentEntry = topLevelBackStack.backStack.lastOrNull()
    val showBottomBar = currentEntry?.let { isTopLevel(it) } == true


    var onNavigate by remember { mutableStateOf<DestinationRoute?>(null) }

    onNavigate?.let { key ->
        NavigationApp(
            startKey = key,
            onBack = { onNavigate = null }
        )
        return
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    TOP_LEVEL_ROUTES.forEach { topLevelRoute ->
                        val isSelected = topLevelRoute == topLevelBackStack.topLevelKey

                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                topLevelBackStack.addTopLevel(topLevelRoute)
                            },
                            icon = {
                                Icon(
                                    imageVector = topLevelRoute.icon,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(text = topLevelRoute.title)
                            }
                        )
                    }
                }
            }
        }
    ) {  innerPadding ->
        NavDisplay(
            backStack = topLevelBackStack.backStack,
            entryDecorators = listOf(
                rememberSceneSetupNavEntryDecorator(),
                rememberSavedStateNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            onBack = { topLevelBackStack.removeLast() },
            entryProvider = entryProvider {
                entry<Dashboard> {
                    DashboardScreen("Dashboard screen")
                }
                entry<FloorPlans> {
                    FloorPlansScreen(
                        onClick = { planId ->
                            onNavigate = PlansDetails(planId)
                        }
                    )
                }

                entry<Valuation> {
                    ValuationScreen("Valuation screen")
                }
                entry<More> {
                    MoreScreen("More screen")
                }
            }
        )
    }
}

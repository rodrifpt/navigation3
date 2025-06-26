package com.cox.navigation3.ui.nav

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.cox.navigation3.ui.nav.DestinationRoute.PlansDetails
import com.cox.navigation3.ui.screens.PlanDetailScreen
import com.cox.navigation3.ui.screens.TermsOfUseScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun <T : NavKey> NavigationApp(startKey: T, onBack: () -> Unit) {
    val backStack = rememberNavBackStack(startKey)

    NavDisplay(
        backStack = backStack,
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        transitionSpec = {
            ContentTransform(
                slideInHorizontally(initialOffsetX = { it }),
                slideOutHorizontally()
            )
        },
        popTransitionSpec = {
            ContentTransform(
                slideInHorizontally(),
                slideOutHorizontally(targetOffsetX = { it })
            )
        },
        sceneStrategy = rememberListDetailSceneStrategy(),
        onBack = { onBack() },
        entryProvider = entryProvider {
            entry<PlansDetails>(
                //metadata = TwoPaneScene.twoPane()
            ) { key ->
                PlanDetailScreen(
                    planId = key.planId,
                    onBackClick = {onBack()}
                )
            }
            entry<TermsOfUse> {
                TermsOfUseScreen("Terms of use  screen")
            }
        }
    )
}

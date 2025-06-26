package com.cox.navigation3.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface TopLevelRoute: NavKey {
    val icon: ImageVector
    val title: String
}

data object Dashboard : TopLevelRoute {
    override val icon = Icons.Default.Home
    override val title = "Dashboard"
}

data object FloorPlans : TopLevelRoute {
    override val icon = Icons.Default.ShoppingCart
    override val title = "Floor Plans"
}

data object Valuation : TopLevelRoute {
    override val icon = Icons.Default.CheckCircle
    override val title = "Valuation"
}

data object More : TopLevelRoute {
    override val icon = Icons.Default.Menu
    override val title = "More"
}

data object TermsOfUse: NavKey

val TOP_LEVEL_ROUTES: List<TopLevelRoute> = listOf(Dashboard, FloorPlans, Valuation, More)


@Serializable
sealed interface DestinationRoute:NavKey {
    @Serializable
    data object Login : DestinationRoute

    @Serializable
    data object Dashboard : DestinationRoute

    @Serializable
    data class PlansDetails(val planId: Int) : DestinationRoute
}

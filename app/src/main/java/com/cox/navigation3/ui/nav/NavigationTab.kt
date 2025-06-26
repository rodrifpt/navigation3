package com.cox.navigation3.ui.nav

/*
@Composable
fun NavigationTab(
    topLevelBackStack: TopLevelBackStack<Any>,
    showBottomBar: MutableState<Boolean>
) {

    var onNavigate by remember { mutableStateOf<DestinationKey?>(null) }

    onNavigate?.let { key ->
        NavigationApp(startKey = key)
        return
    }

    NavDisplay(
        backStack = topLevelBackStack.backStack,
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        //onBack = { topLevelBackStack.removeLast() },
        onBack = {
            //topLevelBackStack.removeLast()
            showBottomBar.value = true
        },
        entryProvider = entryProvider {
            entry<Dashboard> {
                DashboardScreen("Dashboard screen")
            }
            entry<FloorPlans> {
                FloorPlansScreen(
                    onClick = { planId ->
                        topLevelBackStack.add(PlansDetails(planId))
                        //onNavigate = PlansDetails(planId)
                        //topLevelBackStack.add(PlansDetails(planId))
                        showBottomBar.value = false
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
*/
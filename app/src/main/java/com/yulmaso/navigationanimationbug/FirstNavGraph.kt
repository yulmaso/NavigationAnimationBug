package com.yulmaso.navigationanimationbug

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

const val FirstGraphRoute = "firstGraph"

private const val FirstScreenRoute = "firstScreen"

fun NavGraphBuilder.firstOldNavGraph(externalNavController: NavController) {
    composable(FirstGraphRoute) {
        AppNavHost(
            navController = rememberNavController(),
            startDestination = FirstScreenRoute
        ) {
            firstGraphScreens(externalNavController)
        }
    }
}

fun NavGraphBuilder.firstNewNavGraph(externalNavController: NavController) {
    navigation(
        route = FirstGraphRoute,
        startDestination = FirstScreenRoute
    ) {
        firstGraphScreens(externalNavController)
    }
}

private fun NavGraphBuilder.firstGraphScreens(externalNavController: NavController) {
    composable(FirstScreenRoute) {
        FirstScreen(onNavigateNext = remember { { externalNavController.navigate(SecondGraphRoute) } })
    }
}

@Composable
private fun FirstScreen(
    onNavigateNext: () -> Unit
) {
    SimpleScreen(
        title = "Screen 1.1",
        description = "To reproduce the bug quickly click the in-app \"back\" button twice on the Screen 2.2 and Screen 2.1",
        onNavigateNext = onNavigateNext
    )
}
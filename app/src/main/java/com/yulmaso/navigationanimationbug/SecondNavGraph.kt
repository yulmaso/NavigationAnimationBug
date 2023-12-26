package com.yulmaso.navigationanimationbug

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

const val SecondGraphRoute = "secondGraph"

private const val FirstScreenRoute = "firstScreen"
private const val SecondScreenRoute = "secondScreen"

fun NavGraphBuilder.secondOldNavGraph(externalNavController: NavController) {
    composable(SecondGraphRoute) {
        val internalNavController = rememberNavController()
        AppNavHost(
            navController = internalNavController,
            startDestination = FirstScreenRoute
        ) {
            secondGraphScreens(
                externalNavController = externalNavController,
                internalNavController = internalNavController
            )
        }
    }
}

fun NavGraphBuilder.secondNewNavGraph(externalNavController: NavController) {
    navigation(
        route = SecondGraphRoute,
        startDestination = FirstScreenRoute
    ) {
        secondGraphScreens(
            externalNavController = externalNavController,
            // ! There is no internal navController
            internalNavController = externalNavController
        )
    }
}

private fun NavGraphBuilder.secondGraphScreens(
    externalNavController: NavController,
    internalNavController: NavController
) {
    composable(FirstScreenRoute) {
        FirstScreen(
            onNavigateBack = remember { { externalNavController.popBackStack() } },
            onNavigateNext = remember { { internalNavController.navigate(SecondScreenRoute) } }
        )
    }
    composable(SecondScreenRoute) {
        SecondScreen(
            onNavigateBack = remember { { internalNavController.popBackStack() } }
        )
    }
}

@Composable
private fun FirstScreen(
    onNavigateBack: () -> Unit,
    onNavigateNext: () -> Unit
) {
    SimpleScreen(
        title = "Screen 2.1",
        onNavigateBack = onNavigateBack,
        onNavigateNext = onNavigateNext
    )
}

@Composable
private fun SecondScreen(
    onNavigateBack: () -> Unit
) {
    SimpleScreen(
        title = "Screen 2.2",
        onNavigateBack = onNavigateBack
    )
}
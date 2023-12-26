package com.yulmaso.navigationanimationbug

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

const val SecondGraphRoute = "secondGraph"

private const val FirstScreenRoute = "firstScreen"
private const val SecondScreenRoute = "secondScreen"

fun NavGraphBuilder.secondNavGraph(externalNavController: NavController) {
    composable(SecondGraphRoute) {
        val internalNavController = rememberNavController()
        CommonNavHost(
            navController = internalNavController,
            startDestination = FirstScreenRoute
        ) {
            composable(FirstScreenRoute) {
                FirstScreen(
                    onNavigateBack = externalNavController::popBackStack,
                    onNavigateNext = remember { { internalNavController.navigate(SecondScreenRoute) } }
                )
            }
            composable(SecondScreenRoute) {
                SecondScreen(
                    onNavigateBack = internalNavController::popBackStack
                )
            }
        }
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
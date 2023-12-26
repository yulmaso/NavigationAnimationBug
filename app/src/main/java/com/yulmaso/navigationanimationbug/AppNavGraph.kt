package com.yulmaso.navigationanimationbug

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    builder: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        builder = builder,
        enterTransition = { fadeIn(animationSpec = tween(100)) },
        exitTransition = { fadeOut(animationSpec = tween(100)) }
//        enterTransition = { EnterTransition.None },
//        exitTransition = { ExitTransition.None }
    )
}

@Composable
// Navigation graph containing the bug
fun AppOldNavGraph() {
    val navController = rememberNavController()
    AppNavHost(
        navController = navController,
        startDestination = FirstGraphRoute
    ) {
        firstOldNavGraph(externalNavController = navController)
        secondOldNavGraph(externalNavController = navController)
    }
}

@Composable
// Navigation graph without the bug
fun AppNewNavGraph() {
    val navController = rememberNavController()
    AppNavHost(
        navController = navController,
        startDestination = FirstGraphRoute
    ) {
        firstNewNavGraph(externalNavController = navController)
        secondNewNavGraph(externalNavController = navController)
    }
}
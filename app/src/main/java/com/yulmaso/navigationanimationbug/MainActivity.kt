package com.yulmaso.navigationanimationbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yulmaso.navigationanimationbug.ui.theme.NavigationAnimationBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAnimationBugTheme {
                AppNavGraph()
            }
        }
    }
}

@Composable
fun CommonNavHost(
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
//        enterTransition = { EnterTransition.None },
//        exitTransition = { ExitTransition.None }
    )
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    CommonNavHost(
        navController = navController,
        startDestination = FirstGraphRoute
    ) {
        firstNavGraph(externalNavController = navController)
        secondNavGraph(externalNavController = navController)
    }
}
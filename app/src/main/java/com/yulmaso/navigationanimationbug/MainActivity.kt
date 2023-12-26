package com.yulmaso.navigationanimationbug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yulmaso.navigationanimationbug.ui.theme.NavigationAnimationBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAnimationBugTheme {
                AppOldNavGraph()
//                AppNewNavGraph()
            }
        }
    }
}